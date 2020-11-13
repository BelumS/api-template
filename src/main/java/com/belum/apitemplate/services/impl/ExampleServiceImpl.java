package com.belum.apitemplate.services.impl;

import com.belum.apitemplate.repositories.ExampleRepository;
import com.belum.apitemplate.services.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by bel-sahn on 7/30/19
 */
@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {
    private final ExampleRepository repository;

    public ExampleServiceImpl(ExampleRepository repository) {
        this.repository = repository;
    }

}
