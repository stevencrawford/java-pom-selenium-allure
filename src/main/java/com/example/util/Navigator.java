package com.example.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public final class Navigator {

    public static final String HOST = "https://the-internet.herokuapp.com/";

    public static void goTo(final WebDriver driver, final String relativeUrl) {
        driver.manage().deleteAllCookies();
        if (!relativeUrl.startsWith("/")) {
            driver.get(HOST + "/" + relativeUrl);
        } else {
            driver.get(HOST + relativeUrl);
        }
    }

    public static void waitOn(final WebDriver driver, final By elementSelector) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.of(30, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(5, ChronoUnit.SECONDS))
                .until(presenceOfElementLocated(elementSelector));
    }

    /**
     * Takes a screenshot of current screen and returns it as Base64 encoded
     *
     * @param driver WebDriver to use to take screenshot
     * @return Base64 encoded image
     */
    public static String takeScreenshot(final WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}
