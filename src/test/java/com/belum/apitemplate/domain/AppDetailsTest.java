package com.belum.apitemplate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.belum.apitemplate.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppDetailsTest {
    private AppDetails details;

    @BeforeEach
    public void setup() {
        details = new AppDetails(NAME, VERSION, BUILD_TIMESTAMP, ENV, BRANCH);
    }

    @Test
    void testConstructor() {
        assertNotNull(details);
    }

    @Test
    public void testGetName() {
        assertEquals(NAME, details.getName());
    }

    @Test
    void testGetVersion() {
        assertEquals(VERSION, details.getVersion());
    }

    @Test
    void testGetBuildTimestamp() {
        assertNotNull(details.getBuildTimestamp());
    }

    @Test
    void testGetEnv() {
        assertEquals(ENV, details.getEnv());
    }

    @Test
    void testGetBranch() {
        assertEquals(BRANCH, details.getBranch());
    }

    @Test
    void testToString() {
        assertNotNull(details.toString());
    }
}
