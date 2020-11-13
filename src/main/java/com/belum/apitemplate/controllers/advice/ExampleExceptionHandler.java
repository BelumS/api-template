package com.belum.apitemplate.controllers.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by bel-sahn on 7/29/19
 */
@RestControllerAdvice
@Slf4j
public class ExampleExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse> handleCatchAllException(Exception e) {
        final ApiResponse error = new ApiResponse(new ApiRequest("500", e.getMessage()), e);
        final ResponseEntity<ApiResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        log.error("handle catchAllException: {}", responseEntity);
        return responseEntity;
    }
}
