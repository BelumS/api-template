package com.belum.apitemplate.controllers;

import com.belum.apitemplate.domain.AppDetails;
import com.belum.apitemplate.domain.HeartBeat;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class HeartBeatController {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @NonNull
    @Autowired
    private final HeartBeat heartBeat;

    @GetMapping("/heartbeat")
    public AppDetails getApplicationDetails() {
        AppDetails details = new AppDetails(
                heartBeat.getApplicationName(),
                heartBeat.getApplicationVersion(),
                heartBeat.getApplicationTimestamp(),
                heartBeat.getApplicationEnvironment(),
                heartBeat.getApplicationBranch());
        log.info(" --~-~-~-- HEARTBEAT --~-~-~-- \n{}", details);
        return details;
    }
}
