package com.belum.apitemplate.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.belum.apitemplate.constants.TestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class AppDetailsTest {

    private AppDetails details;

    @Before
    public void setup() {
        details = new AppDetails(NAME, VERSION, BUILD_TIMESTAMP, ENV, BRANCH);
    }

    @Test
    public void testConstructor() {
        assertNotNull(details);
    }

    @Test
    public void testGetName() {
        assertEquals(NAME, details.getName());
    }

    @Test
    public void testGetVersion() {
        assertEquals(VERSION, details.getVersion());
    }

    @Test
    public void testGetBuildTimestamp() {
        assertNotNull(details.getBuildTimestamp());
    }

    @Test
    public void testGetEnv() {
        assertEquals(ENV, details.getEnv());
    }

    @Test
    public void testGetBranch() {
        assertEquals(BRANCH, details.getBranch());
    }

    @Test
    public void testToString() {
        assertNotNull(details.toString());
    }
}
