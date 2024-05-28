package com.example.steps;

import com.example.pages.LoginPage;
import com.example.pages.SecurePage;
import com.example.util.Navigator;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTestStep extends BaseCucumberTestStep {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private SecurePage securePage;

    @AfterStep
    public void tearDownAfterScenario(Scenario scenario) throws Exception {
        super.tearDown(scenario);
    }

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
        this.securePage = loginPage.clickLoginButton();
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
