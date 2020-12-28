package com.belum.apitemplate.controllers;

import com.belum.apitemplate.config.security.SecurityConfig;
import com.belum.apitemplate.domain.HeartBeat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@SpringJUnitWebConfig(classes = {HeartBeatController.class, HeartBeat.class, SecurityConfig.class})
class HeartBeatControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSuccess() throws Exception {
        var result = mockMvc.perform(get("/heartbeat")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andReturn();

        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void testGetReturns404() throws Exception {
        mockMvc.perform(get("/fail")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
