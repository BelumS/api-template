package com.belum.apitemplate.services;

import com.belum.apitemplate.domain.ClientInfo;
import com.belum.apitemplate.services.impl.JwtServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtServiceTest {
    private JwtService service;
    private static final ClientInfo CLIENT_INFO = new ClientInfo(
            "ID",
            "SECRET",
            "TEST",
            "TEST",
            LocalDate.now(),
            LocalDate.now().plusDays(1)
    );

    @BeforeEach
    void setup() {
        MockEnvironment environment = new MockEnvironment();
        service = new JwtServiceImpl(environment);
    }

    @Test
    void test() {
        assertNotNull(service);
    }

    @Test
    void testCreateJwt() throws UnsupportedEncodingException {
        assertNotNull(service.createJwt(CLIENT_INFO));
    }

    @Test
    void testDecodeJwt() throws UnsupportedEncodingException {
        assertNotNull(service.decodeJwt(service.createJwt(CLIENT_INFO)));
    }
}
