package com.belum.apitemplate.controllers;

import com.belum.apitemplate.exceptions.FileWriteFailedException;
import com.belum.apitemplate.services.FileService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("${api.basePath}/${api.version.v1}/file")
@Slf4j
public class FileController {
    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Get File", notes = "Retrieves a file")
    public ResponseEntity<String> getResource() throws FileWriteFailedException {
        log.debug("Creating a file ...");
        File file = service.generateCsv();
        return ResponseEntity.ok("Created: " + file.getName());
    }
}
