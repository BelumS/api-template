package com.belum.apitemplate.controllers.advice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by bel-sahn on 7/29/19
 */
@JsonPropertyOrder({"request", "response"})
@Getter
@ToString
@AllArgsConstructor
public final class ApiResponse {
    private final ApiRequest request;
    private final Object payload;
}
