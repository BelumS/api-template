package com.belum.apitemplate.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationConfigTest {
    private ApplicationConfig config;

    @BeforeEach
    void setup() {
        config = new ApplicationConfig();
    }

    @Test
    void testConstructor() {
        assertNotNull(config);
    }

    @Test
    void testRestTemplateBean() {
        assertNotNull(config.restTemplate(new RestTemplateBuilder()));
    }

    @Test
    void testCacheManagerBean() {
        assertNotNull(config.cacheManager());
    }

    @Test
    void testRetryTemplateBean() {
        assertNotNull(config.retryTemplate());
    }
}
