package com.belum.apitemplate.utils;

import ch.qos.logback.classic.spi.LoggingEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatternMaskingLayoutTest {
    private PatternMaskingLayout layout;

    @BeforeEach
    void setup() {
        layout = new PatternMaskingLayout();
    }

    @Test
    void test() {
        assertNotNull(layout);
    }

    @Test
    void testDoLayout() {
        assertNotNull(layout.doLayout(new LoggingEvent()));
    }
}
