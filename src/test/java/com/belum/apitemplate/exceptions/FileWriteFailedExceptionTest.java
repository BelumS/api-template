package com.belum.apitemplate.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileWriteFailedExceptionTest {
    private FileWriteFailedException exception;

    @BeforeEach
    void setup() {
        exception = new FileWriteFailedException();
    }

    @Test
    void test() {
        assertNotNull(exception);
    }

    @Test
    void testMessage() {
        exception = new FileWriteFailedException("Message");
        assertNotNull(exception);
    }

    @Test
    void testCause() {
        exception = new FileWriteFailedException(new IllegalArgumentException());
        assertNotNull(exception);
    }

    @Test
    void testAlt() {
        exception = new FileWriteFailedException("Message", new IllegalArgumentException());
        assertNotNull(exception);
    }
}
