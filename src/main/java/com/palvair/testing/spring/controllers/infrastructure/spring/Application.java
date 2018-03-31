package com.palvair.testing.spring.controllers.infrastructure.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.palvair.testing.spring.controllers")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
