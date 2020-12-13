package com.belum.apitemplate.services.impl;

import com.belum.apitemplate.domain.Example;
import com.belum.apitemplate.exceptions.FileWriteFailedException;
import com.belum.apitemplate.services.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Service
@Slf4j
@NoArgsConstructor
public class FileServiceImpl implements FileService {
    private static final String FILE_PATH = "src/main/resources/misc/";
    private static final String FILE_CSV = ".csv";
    private static final String FILE_ZIP = ".zip";
    private static final String LOCAL_FILE_PATH = "file";
    private static final String MAX_FILE_SIZE_KEY = "MAX FILE SIZE";
    private static final int MAX_FILE_SIZE_VALUE = 1024 * 25;

    @Override
    @Retryable(value = FileWriteFailedException.class, backoff = @Backoff(1000))
    public File generateCsv() throws FileWriteFailedException {
        try {
            File outputFile = new File(fullFileName(FILE_CSV));
            final JsonNode data = convertToJson();

            CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
            JsonNode csvFirstRow = data.elements().next();
            csvFirstRow.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);

            CsvSchema schema = csvSchemaBuilder.build();
            CsvMapper csvMapper = new CsvMapper();
            csvMapper.writerFor(JsonNode.class)
                    .with(schema)
                    .writeValue(outputFile, data);

            log.debug("Writing {} line items to {}/\"{}\".", 0, LOCAL_FILE_PATH, outputFile.getName());

            if (outputFile.length() > MAX_FILE_SIZE_VALUE) {
                log.warn("WARNING: Attached file exceeds: \"{}\" @ {}bytes, compressing ...", MAX_FILE_SIZE_KEY, outputFile.length());
                return zipFile(outputFile);
            }
            return outputFile;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new FileWriteFailedException();
        }
    }

    private JsonNode convertToJson() throws JsonProcessingException {
        try {
            Example example = new Example();
            return new ObjectMapper().readTree(example.toString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private File zipFile(File file) throws IOException {
        final String csvFileName = file.getName();
        final String zipFilePath = fullFileName(FILE_ZIP);

        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

            ZipEntry zipEntry = new ZipEntry(csvFileName);
            zipOutputStream.putNextEntry(zipEntry);

            byte[] content = new byte[(int) file.length()];
            int length;

            while ((length = fileInputStream.read(content)) >= 0) {
                zipOutputStream.write(content, 0, length);
            }

            if (Files.deleteIfExists(Path.of(URI.create(zipFilePath)))) {
                log.debug("Compression completed, deleting \"{}\"", csvFileName);
            }
            return new File(zipFilePath);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private static String fullFileName(String fileExtension) {
        return FILE_PATH + LOCAL_FILE_PATH + fileExtension;
    }
}
