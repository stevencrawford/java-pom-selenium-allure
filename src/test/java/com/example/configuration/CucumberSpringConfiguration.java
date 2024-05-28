package com.example.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.URI;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Configuration
@ComponentScan({"com.example.pages"})
@PropertySource("classpath:application.properties")
public class CucumberSpringConfiguration {

    @Value(value = "${selenium.grid.url}")
    private String seleniumGridURL;

    @Bean(destroyMethod = "quit")
    @Scope(SCOPE_CUCUMBER_GLUE)
    public WebDriver driver() throws Exception {
        WebDriver driver = new RemoteWebDriver(URI.create(seleniumGridURL).toURL(), getCapabilities());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browser = System.getProperty("browser");
        switch (browser) {
            case "firefox" -> capabilities.setBrowserName(Browser.FIREFOX.browserName());
            case "edge" -> capabilities.setBrowserName(Browser.EDGE.browserName());
            default -> capabilities.setBrowserName(Browser.CHROME.browserName());
        }
        return capabilities;
    }

    private DesiredCapabilities getMobileCapabilities() {
        DesiredCapabilities dc = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", false);
        dc.merge(chromeOptions);
        return dc;
    }

}
