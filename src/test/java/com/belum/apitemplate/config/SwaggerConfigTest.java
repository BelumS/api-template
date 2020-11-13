package com.belum.apitemplate.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SwaggerConfigTest {
    private SwaggerConfig config;

    @BeforeEach
    void setup() {
        config = new SwaggerConfig();
    }

    @Test
    void test() {
        assertNotNull(config);
    }

    @Test
    void testApiV1() {
        assertNotNull(config.apiV1());
    }

    @Test
    void testApiV2() {
        assertNotNull(config.apiV2());
    }
}
