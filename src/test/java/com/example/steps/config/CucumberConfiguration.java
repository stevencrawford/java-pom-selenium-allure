package com.example.steps.config;

import com.example.config.TestConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfiguration.class)
public class CucumberConfiguration {
}

