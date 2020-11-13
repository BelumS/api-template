package com.belum.apitemplate.services;

import com.belum.apitemplate.repositories.ExampleRepository;
import com.belum.apitemplate.services.impl.ExampleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
class ExampleServiceTest {
    @InjectMocks
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
