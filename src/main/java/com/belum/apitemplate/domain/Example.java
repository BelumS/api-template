package com.belum.apitemplate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by bel-sahn on 7/30/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Example {
    private String key = "key";
    private String value = "value";

    @Override
    public String toString() {
        return "{"
                + "\"key\":\"" + key + "\","
                + "\"value\":\"" + value + "\""
                + "}";
    }
}
