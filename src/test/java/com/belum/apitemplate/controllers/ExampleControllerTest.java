package com.belum.apitemplate.controllers;

import com.belum.apitemplate.domain.Example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExampleControllerTest {
    private ExampleController controller;
    private ResponseEntity<Example> responseEntity;

    @BeforeEach
    void setup() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        controller = new ExampleController();
        responseEntity = controller.getResource();
    }

    @Test
    void test() {
        assertNotNull(controller);
    }

    @Test
    void testGetResourcesStatusCode() {
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetResourcesRequestBody() {
        assertThat(responseEntity.getBody()).isInstanceOf(Example.class);
    }
}
