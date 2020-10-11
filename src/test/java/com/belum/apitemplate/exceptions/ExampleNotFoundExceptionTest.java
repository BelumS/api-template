package com.belum.apitemplate.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExampleNotFoundExceptionTest {
    private ExampleNotFoundException exception;

    @BeforeEach
    void setup() {
        exception = new ExampleNotFoundException();
    }

    @Test
    void test() {
        assertNotNull(exception);
    }

    @Test
    void testMessage() {
        exception = new ExampleNotFoundException("Message");
        assertNotNull(exception);
    }

    @Test
    void testCause() {
        exception = new ExampleNotFoundException(new IllegalArgumentException());
        assertNotNull(exception);
    }

    @Test
    void testAlt() {
        exception = new ExampleNotFoundException("Message", new IllegalArgumentException());
        assertNotNull(exception);
    }
}
