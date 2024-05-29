package com.example.pages;

import com.example.annotation.cucumber.CucumberGlueScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@CucumberGlueScope
public class ForgotPasswordPage extends BasePage {

    private static final String EMAIL_INPUT_XPATH = "//input[@id='email']";
    private static final String RETRIEVE_PASSWORD_BUTTON_XPATH = "//button[@id='form_submit']";

    @FindBy(xpath = EMAIL_INPUT_XPATH)
    private WebElement emailInput;

    @FindBy(xpath = RETRIEVE_PASSWORD_BUTTON_XPATH)
    private WebElement retrievePasswordButton;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickRetrievePasswordButton() {
        retrievePasswordButton.click();
    }
}
