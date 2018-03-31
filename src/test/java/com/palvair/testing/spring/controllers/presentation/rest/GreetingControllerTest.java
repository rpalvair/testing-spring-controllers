package com.palvair.testing.spring.controllers.presentation.rest;

import com.palvair.testing.spring.controllers.infrastructure.spring.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class GreetingControllerTest {

    private static final String GREETING_URL = "/greeting";
    private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void should_return_message_with_the_name() throws Exception {
        mockMvc.perform(get(GREETING_URL)
                .param("name", "Ruddy")
                .accept(MediaType.parseMediaType(MEDIA_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE))
                .andExpect(jsonPath("$.message").value("Hello Ruddy"));
    }

    @Test
    public void should_return_default_message() throws Exception {
        mockMvc.perform(get(GREETING_URL)
                .accept(MediaType.parseMediaType(MEDIA_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE))
                .andExpect(jsonPath("$.message").value("Hello World"));
    }
}