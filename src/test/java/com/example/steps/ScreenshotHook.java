package com.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class ScreenshotHook {

    private static final Map<String, Boolean> erroredScenarios = new HashMap<>();

    private final WebDriver driver;

    @After
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
}
