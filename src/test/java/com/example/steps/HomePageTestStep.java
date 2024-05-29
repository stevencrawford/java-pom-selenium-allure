package com.example.steps;

import com.example.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

import static com.example.util.Navigator.goTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Data
@RequiredArgsConstructor
public class HomePageTestStep {

    private final WebDriver driver;
    private final HomePage homePage;

    @Given("^I navigate to the homepage$")
    public void i_navigate_to_the_homepage() throws Throwable {
        goTo(driver, "/");
    }

    @Then("^I should see title as \"([^\"]*)\"$")
    public void i_should_see_title_as(String title) throws Throwable {
        assertThat(homePage.getTitle(), is(title));
    }

    @Then("^I should see a link with text \"([^\"]*)\"$")
    public void i_should_see_a_link_with_text(String text) throws Throwable {
        assertThat(homePage.containsLink(text), is(true));
    }

}
