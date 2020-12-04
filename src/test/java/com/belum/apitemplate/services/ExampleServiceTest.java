package com.belum.apitemplate.services;

import com.belum.apitemplate.repositories.ExampleRepository;
import com.belum.apitemplate.services.impl.ExampleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ExampleServiceTest {
    private ExampleService service;

    @Mock
    private ExampleRepository repository;

    @BeforeEach
    void setup() {
        service = new ExampleServiceImpl(repository);
    }

    @Test
    void test() {
        assertNotNull(service);
    }
}
