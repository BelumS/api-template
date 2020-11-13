package com.belum.apitemplate.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PublisherConfigTest {
    private PublisherConfig config;

    @BeforeEach
    void setup() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("spring.kafka.bootstrap-servers", "localhost");
        config = new PublisherConfig(mockEnvironment);
    }

    @Test
    void test() {
        assertNotNull(config);
    }

    @Test
    void testPublisherPropertiesBean() {
        assertNotNull(config.publisherProperties());
    }

    @Test
    void testProducerFactoryBean() {
        assertNotNull(config.producerFactory());
    }

    @Test
    void testKafkaTemplateBean() {
        assertNotNull(config.kafkaTemplate());
    }
}
