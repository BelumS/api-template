package com.belum.apitemplate.controllers;

import com.belum.apitemplate.exceptions.FileWriteFailedException;
import com.belum.apitemplate.services.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FileControllerTest {
    @Mock
    private FileService service;

    private FileController controller;

    private ResponseEntity<String> responseEntity;

    @BeforeEach
    void setup() throws FileWriteFailedException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        responseEntity = controller.getResource();
        controller = new FileController(service);
    }

    @Test
    void testGetResourcesStatusCode() throws IOException, FileWriteFailedException {
        Mockito.when(service.generateCsv()).thenReturn(File.createTempFile("test", "txt"));
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetResourcesRequestBody() throws IOException, FileWriteFailedException {
        Mockito.when(service.generateCsv()).thenReturn(File.createTempFile("test", "txt"));
        assertThat(responseEntity.getBody()).isInstanceOf(String.class);
    }
}
