package com.belum.apitemplate.controllers.advice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ExampleExceptionHandlerTest {
    private ExampleExceptionHandler handler;

    @BeforeEach
    void setup() {
        handler = new ExampleExceptionHandler();
    }

    @Test
    void test() {
        assertNotNull(handler);
    }

    @Test
    void testCatchAllException() {
        assertNotNull(handler.handleCatchAllException(new Exception()));
    }
}
