package com.example.steps;

import com.example.configuration.CucumberSpringConfiguration;
import com.example.util.Navigator;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberSpringConfiguration.class)
public class BaseCucumberTestStep {

    private static final Map<String, Boolean> erroredScenarios = new HashMap<>();

    @Autowired
    protected WebDriver driver;

    public void setUp() throws Exception {
        Navigator.goTo(driver, "/");
    }

    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            if (!erroredScenarios.containsKey(scenario.getId())) {
                Allure.getLifecycle().addAttachment(
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")),
                        "image/png",
                        "png",
                        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
                );
                erroredScenarios.put(scenario.getId(), Boolean.TRUE);
            }
        }

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("return window.sessionStorage.clear();");
    }

    @AfterTestClass
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }

}

