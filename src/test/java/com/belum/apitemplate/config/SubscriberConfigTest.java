package com.belum.apitemplate.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class SubscriberConfigTest {
    private SubscriberConfig config;

    @BeforeEach
    void setup() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("spring.kafka.bootstrap-servers", "localhost");
        config = new SubscriberConfig(mockEnvironment);
    }

    @Test
    void test() {
        assertNotNull(config);
    }

    @Test
    void testSubscriberProps() {
        assertNotNull(config.subscriberProps());
    }

    @Test
    void testConsumerFactory() {
        assertNotNull(config.consumerFactory());
    }

    @Test
    void testListenerContainerFactory() {
        assertNotNull(config.kafkaListenerContainerFactory());
    }
}
