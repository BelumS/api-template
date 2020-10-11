package com.belum.apitemplate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClientInfoTest {
    private ClientInfo info;

    @BeforeEach
    void setup() {
        info = new ClientInfo(
                "ID",
                "SECRET",
                "TEST",
                "TEST",
                LocalDate.now(),
                LocalDate.now().plusDays(1)
        );
    }

    @Test
    void test() {
        info = new ClientInfo();
        assertNotNull(info);
    }

    @Test
    void testAlt() {
        assertNotNull(info);
    }

    @Test
    void testClientId() {
        assertNotNull(info.getClientId());
    }

    @Test
    void testClientSecret() {
        assertNotNull(info.getClientSecret());
    }

    @Test
    void testIssuer() {
        assertNotNull(info.getIssuer());
    }

    @Test
    void testSubject() {
        assertNotNull(info.getSubject());
    }

    @Test
    void testIssuedAt() {
        assertNotNull(info.getIssuedAt());
    }

    @Test
    void testExpiresAt() {
        assertNotNull(info.getExpiresAt());
    }

    @Test
    void testToString() {
        assertNotNull(info.toString());
    }
}
