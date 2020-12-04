package com.belum.apitemplate.controllers;

import com.belum.apitemplate.domain.HeartBeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static com.belum.apitemplate.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HeartBeatControllerTest {
    private HeartBeatController controller;

    @BeforeEach
    public void setup() {
        HeartBeat heartBeat = new HeartBeat();
        ReflectionTestUtils.setField(heartBeat, "applicationName", NAME);
        ReflectionTestUtils.setField(heartBeat, "applicationVersion", VERSION);
        ReflectionTestUtils.setField(heartBeat, "applicationTimestamp", BUILD_TIMESTAMP);
        ReflectionTestUtils.setField(heartBeat, "applicationEnvironment", ENV);
        ReflectionTestUtils.setField(heartBeat, "applicationBranch", BRANCH);

        controller = new HeartBeatController(heartBeat);
    }

    @Test
    void testConstructor() {
        assertNotNull(controller);
    }

    @Test
    void testAppDetails() {
        assertNotNull(controller.getApplicationDetails());
    }
}
