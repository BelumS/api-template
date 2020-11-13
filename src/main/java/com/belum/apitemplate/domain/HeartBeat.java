package com.belum.apitemplate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
@Getter
public class HeartBeat {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version}")
    private String applicationVersion;

    @Value("${spring.application.timestamp}")
    private String applicationTimestamp;

    @Value("${spring.application.environment}")
    private String applicationEnvironment;

    @Value("${spring.application.branch}")
    private String applicationBranch;
}
