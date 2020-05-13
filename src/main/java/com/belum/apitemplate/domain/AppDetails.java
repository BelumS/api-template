package com.belum.apitemplate.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AppDetails {
    @NonNull
    private final String name;

    @NonNull
    private final String version;

    @NonNull
    private final String buildTimestamp;

    @NonNull
    private final String env;

    @Override
    public String toString() {
        return String.format("{" +
                "\n\t\"appName\": \"%s\"," +
                "\n\t\"appVersion\": \"%s\", " +
                "\n\t\"timeStamp\": \"%s\", " +
                "\n\t\"env\": \"%s\"" +
                "\n}", name, version, buildTimestamp, env);
    }
}
