@smoke
Feature: Home Page Content Test

  Background:
    Given I navigate to the homepage

  Scenario: Verify Home Page title is present and correct
    Then I should see title as "Welcome to the-internet"

  Scenario Outline: Verify Home Page has sample of correct links
    Then I should see a link with text "<linkText>"

    Examples:
      | linkText |
      | A/B Testing |
      | Checkboxes |
      | Dropdown |
      | Horizontal Slider |
      | WYSIWYG Editor |
