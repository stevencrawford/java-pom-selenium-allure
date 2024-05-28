package com.example.pages;

import com.example.annotation.cucumber.CucumberGlueScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@CucumberGlueScope
public class LoginPage extends BasePage {

    private static final String USERNAME_INPUT_XPATH = "//input[@id='username']";
    private static final String PASSWORD_INPUT_XPATH = "//input[@id='password']";
    private static final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";

    @FindBy(xpath = USERNAME_INPUT_XPATH)
    private WebElement usernameInput;

    @FindBy(xpath = PASSWORD_INPUT_XPATH)
    private WebElement passwordInput;

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    @Autowired
    private SecurePage securePage;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public SecurePage clickLoginButton() {
        loginButton.click();
        return securePage;
    }

    public SecurePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }
}
