package com.belum.apitemplate.domain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.util.ReflectionTestUtils;

import static com.belum.apitemplate.constants.TestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class HeartBeatTest {
    private HeartBeat heartBeat;

    @Before
    public void setup() {
        heartBeat = new HeartBeat();
        ReflectionTestUtils.setField(heartBeat, "applicationName", NAME);
        ReflectionTestUtils.setField(heartBeat, "applicationVersion", VERSION);
        ReflectionTestUtils.setField(heartBeat, "applicationTimestamp", BUILD_TIMESTAMP);
        ReflectionTestUtils.setField(heartBeat, "applicationEnvironment", ENV);
        ReflectionTestUtils.setField(heartBeat, "applicationBranch", BRANCH);
    }

    @Test
    public void testConstructor() {
        assertNotNull(heartBeat);
    }

    @Test
    public void testGetName() {
        assertEquals(NAME, heartBeat.getApplicationName());
    }

    @Test
    public void testGetVersion() {
        assertEquals(VERSION, heartBeat.getApplicationVersion());
    }

    @Test
    public void testGetBuildTimestamp() {
        assertNotNull(heartBeat.getApplicationTimestamp());
    }

    @Test
    public void testGetEnv() {
        assertEquals(ENV, heartBeat.getApplicationEnvironment());
    }

    @Test
    public void testGetBranch() {
        assertEquals(BRANCH, heartBeat.getApplicationBranch());
    }
}
