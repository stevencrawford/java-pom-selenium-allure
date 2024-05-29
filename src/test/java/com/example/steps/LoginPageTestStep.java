package com.example.steps;

import com.example.pages.LoginPage;
import com.example.pages.SecurePage;
import com.example.steps.config.CucumberConfiguration;
import com.example.util.Navigator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Data
@RequiredArgsConstructor
public class LoginPageTestStep extends CucumberConfiguration {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final SecurePage securePage;

    @Given("I navigate to the login page")
    public void i_navigate_to_the_login_page() throws Throwable {
        Navigator.goTo(driver, "/login");
    }

    @When("I enter a username {string} and password {string}")
    public void i_enter_a_valid_username_and_password(String username, String password) throws Throwable {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the Login button")
    public void i_click_the_login_button() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() throws Throwable {
        String successMessage = loginPage.getFlashMessage();
        assertThat(successMessage, containsString("You logged into a secure area!"));
    }

    @Then("I should see a flash message containing {string}")
    public void i_should_see_a_flash_message_containing(String expectedMessage) throws Throwable {
        String errorMessage = loginPage.getFlashMessage();
        assertThat(errorMessage, containsString(expectedMessage));
    }
}
