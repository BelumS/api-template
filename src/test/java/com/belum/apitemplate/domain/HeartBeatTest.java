package com.belum.apitemplate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static com.belum.apitemplate.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HeartBeatTest {
    private HeartBeat heartBeat;

    @BeforeEach
    public void setup() {
        heartBeat = new HeartBeat();
        ReflectionTestUtils.setField(heartBeat, "applicationName", NAME);
        ReflectionTestUtils.setField(heartBeat, "applicationVersion", VERSION);
        ReflectionTestUtils.setField(heartBeat, "applicationTimestamp", BUILD_TIMESTAMP);
        ReflectionTestUtils.setField(heartBeat, "applicationEnvironment", ENV);
        ReflectionTestUtils.setField(heartBeat, "applicationBranch", BRANCH);
    }

    @Test
    void testConstructor() {
        assertNotNull(heartBeat);
    }

    @Test
    void testGetName() {
        assertEquals(NAME, heartBeat.getApplicationName());
    }

    @Test
    void testGetVersion() {
        assertEquals(VERSION, heartBeat.getApplicationVersion());
    }

    @Test
    void testGetBuildTimestamp() {
        assertNotNull(heartBeat.getApplicationTimestamp());
    }

    @Test
    void testGetEnv() {
        assertEquals(ENV, heartBeat.getApplicationEnvironment());
    }

    @Test
    void testGetBranch() {
        assertEquals(BRANCH, heartBeat.getApplicationBranch());
    }
}
