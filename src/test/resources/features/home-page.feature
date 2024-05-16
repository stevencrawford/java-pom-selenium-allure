Feature: Home Page Content Test

  Scenario: Verify Home Page title is present and correct
    Given I navigate to the homepage
    Then I should see title as "Welcome to the-internet"
