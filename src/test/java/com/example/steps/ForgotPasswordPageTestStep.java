package com.example.steps;

import com.example.pages.ForgotPasswordPage;
import com.example.util.Navigator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Data
@RequiredArgsConstructor
public class ForgotPasswordPageTestStep {

    private final WebDriver driver;
    private final ForgotPasswordPage forgotPasswordPage;

    @Given("I navigate to the forgot password page")
    public void i_navigate_to_the_forgot_password_page() throws Throwable {
        Navigator.goTo(driver, "/forgot_password");
    }

    @When("I enter an email address {string}")
    public void i_enter_an_email_address(String email) throws Throwable {
        forgotPasswordPage.enterEmail(email);
    }

    @When("I click the Retrieve Password button")
    public void i_click_the_retrieve_password_button() throws Throwable {
        forgotPasswordPage.clickRetrievePasswordButton();
    }

    @Then("I should see a confirmation message containing {string}")
    public void i_should_see_a_confirmation_message_containing(String expectedMessage) throws Throwable {
        String actualMessage = driver.findElement(By.id("content")).getText();
        assertThat(actualMessage, containsString(expectedMessage));
    }
}
