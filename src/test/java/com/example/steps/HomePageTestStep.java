package com.example.steps;

import com.example.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTestStep extends BaseCucumberTestStep {

    @Autowired
    private HomePage homePage;

    @Before
    public void setUpBeforeScenarioAndBeforeFeature() throws Exception {
        super.setUp();
    }

    @After
    public void tearDownAfterScenario(Scenario scenario) throws Exception {
        super.tearDown(scenario);
    }

    @Given("^I navigate to the homepage$")
    public void i_navigate_to_the_homepage() throws Throwable {
        homePage.init();
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
