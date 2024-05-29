package com.example.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.util.Navigator.waitOn;
import static org.openqa.selenium.By.xpath;

public abstract class BasePage {

    private static final String FLASH_XPATH = "//div[@id='flash']";

    @Autowired
    protected WebDriver driver;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public String getFlashMessage() {
        waitOn(driver, xpath(FLASH_XPATH));
        WebElement flash = driver.findElement(xpath(FLASH_XPATH));
        return flash.getText();
    }
}
