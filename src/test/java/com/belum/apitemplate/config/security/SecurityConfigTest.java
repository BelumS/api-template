package com.belum.apitemplate.config.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SecurityConfigTest {
    private SecurityConfig config;

    @BeforeEach
    void setup() {
        config = new SecurityConfig();
    }

    @Test
    void test() {
        assertNotNull(config);
    }

    @Test
    void testCorsConfigurationSource() {
        assertNotNull(config.corsConfigurationSource());
    }
}
