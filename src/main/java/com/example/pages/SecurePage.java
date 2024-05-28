package com.example.pages;

import com.example.annotation.cucumber.CucumberGlueScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@CucumberGlueScope
public class SecurePage extends BasePage {

    private static final String LOGOUT_BUTTON_XPATH = "//a[@href='/logout']";

    @FindBy(xpath = LOGOUT_BUTTON_XPATH)
    private WebElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.click();
    }

}
