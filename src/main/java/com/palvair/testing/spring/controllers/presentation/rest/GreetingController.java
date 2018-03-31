package com.palvair.testing.spring.controllers.presentation.rest;

import com.palvair.testing.spring.controllers.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
        final String message = String.format("Hello %s", name);
        return new Greeting(message);
    }

}
