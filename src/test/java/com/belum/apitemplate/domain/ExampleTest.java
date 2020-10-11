package com.belum.apitemplate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExampleTest {
    private Example example;

    @BeforeEach
    void setup() {
        example = new Example();
    }

    @Test
    void test() {
        assertNotNull(example);
    }

    @Test
    void testAlt() {
        example = new Example("Key", "Value");
        assertNotNull(example);
    }

    @Test
    void testKey() {
        String unExpected = example.getKey();
        String actual = "New Key";
        example.setKey(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testValue() {
        String unExpected = example.getValue();
        String actual = "New Value";
        example.setValue(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testToString() {
        assertNotNull(example.toString());
    }
}
