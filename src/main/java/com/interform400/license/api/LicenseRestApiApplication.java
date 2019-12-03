package com.interform400.license.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication
public class LicenseRestApiApplication {

    private static final Logger logger = LoggerFactory.getLogger(LicenseRestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LicenseRestApiApplication.class, args);

        logger.info("Hello Spring Boot");
    }

}
