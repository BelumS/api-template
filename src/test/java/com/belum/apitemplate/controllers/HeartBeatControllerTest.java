package com.belum.apitemplate.controllers;

import com.belum.apitemplate.domain.HeartBeat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.util.ReflectionTestUtils;

import static com.belum.apitemplate.constants.TestConstants.*;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class HeartBeatControllerTest {
    private HeartBeatController controller;

    @Before
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
    public void testConstructor() {
        assertNotNull(controller);
    }

    @Test
    public void testAppDetails() {
        assertNotNull(controller.getApplicationDetails());
    }
}
