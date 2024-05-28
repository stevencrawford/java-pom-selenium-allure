Feature: Forgotten Password

  Background:
    Given I navigate to the forgot password page

  Scenario: User can request a password reset
    When I enter an email address "test@example.com"
    And I click the Retrieve Password button
    Then I should see a confirmation message containing "Your e-mail's been sent!"

  Scenario: User cannot request a password reset with an invalid email
    When I enter an email address "invalid_email"
    And I click the Retrieve Password button
    Then I should see a confirmation message containing "Your e-mail's been sent!"
