package com.example.steps;

import com.example.pages.SecurePage;
import com.example.util.Navigator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

import static com.example.util.Navigator.verifyIsOnPage;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Data
@RequiredArgsConstructor
public class SecurePageTestStep {

    private final WebDriver driver;
    private final SecurePage securePage;

    @Then("I should be on the secure page")
    public void i_should_be_on_the_secure_page() throws Throwable {
        String flashMessage = securePage.getFlashMessage();
        assertThat(flashMessage, containsString("You logged into a secure area!"));
    }

    @When("I log out")
    public void i_log_out() throws Throwable {
        securePage.clickLogoutButton();
    }

    @Given("I navigate to the secure page directly")
    public void i_navigate_to_the_secure_page_directly() {
        Navigator.goTo(driver, "/secure");
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() throws Throwable {
        verifyIsOnPage(driver, "/login");
    }

}
