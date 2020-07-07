package com.belum.apitemplate.services.impl;

import com.belum.apitemplate.repositories.ExampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

/**
 * Created by bel-sahn on 7/30/19
 */
@Service
public class ExampleServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private ExampleRepository repository;

}
