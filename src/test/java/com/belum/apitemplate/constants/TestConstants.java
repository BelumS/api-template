package com.belum.apitemplate.constants;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public final class TestConstants {
    private TestConstants(){}

    public static final String NAME = "TEST";
    public static final String VERSION = "0.0.1";
    public static final String BUILD_TIMESTAMP = ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)).toString();
    public static final String ENV = "local";
    public static final String BRANCH = "master";
}
