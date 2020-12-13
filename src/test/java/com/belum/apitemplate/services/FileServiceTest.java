package com.belum.apitemplate.services;

import com.belum.apitemplate.services.impl.FileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class FileServiceTest {
    private FileService service;

    @BeforeEach
    void setup() {
        service = new FileServiceImpl();
    }

    @Test
    void test() {
        assertNotNull(service);
    }
}
