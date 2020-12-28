package com.belum.apitemplate.controllers;

import com.belum.apitemplate.config.security.SecurityConfig;
import com.belum.apitemplate.services.FileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
@SpringJUnitWebConfig(classes = {FileController.class, FileService.class, SecurityConfig.class})
class FileControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileService mockService;

    @Test
    void testGetSuccess() throws Exception {
        Mockito.when(mockService.generateCsv()).thenReturn(File.createTempFile("test", "txt"));
        var result = mockMvc.perform(get("/api/v1/file"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void testGetReturns404() throws Exception {
        Mockito.when(mockService.generateCsv()).thenReturn(File.createTempFile("test", "txt"));
        mockMvc.perform(get("/fail"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
