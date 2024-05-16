package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.util.Navigator.waitOn;

@Component
public class HomePage extends BasePage {

    public static final String titleFieldSel = "//div/h1[@class='heading']";

    @FindBy(xpath = titleFieldSel)
    WebElement titleField;

    @Autowired
    public HomePage(WebDriver driver) {
        this.driver = driver;
        init();
    }

    public void init() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        waitOn(driver, By.xpath(titleFieldSel));
        return titleField.getText();
    }

}
