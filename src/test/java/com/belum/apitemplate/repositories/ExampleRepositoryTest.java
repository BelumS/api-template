package com.belum.apitemplate.repositories;

import com.belum.apitemplate.repositories.impl.ExampleRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ExampleRepositoryTest {
    private ExampleRepository repository;

    @BeforeEach
    void setup() {
        repository = new ExampleRepositoryImpl();
    }

    @Test
    void test() {
        assertNotNull(repository);
    }
}
