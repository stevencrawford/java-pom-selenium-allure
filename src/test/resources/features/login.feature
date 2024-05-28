Feature: Login

  Scenario: User can log in with valid credentials
    Given I navigate to the login page
    When I enter a username "tomsmith" and password "SuperSecretPassword!"
    And I click the Login button
    Then I should be on the secure page
    And I should see a flash message containing "You logged into a secure area!"

  Scenario: User cannot log in with invalid credentials
    Given I navigate to the login page
    When I enter a username "invaliduser" and password "invalidpassword"
    And I click the Login button
    Then I should see a flash message containing "Your username is invalid!"

  Scenario Outline: User cannot log in with various invalid credential combinations
    Given I navigate to the login page
    When I enter a username "<username>" and password "<password>"
    And I click the Login button
    Then I should see a flash message containing "<expectedMessage>"

    Examples:
      | username    | password             | expectedMessage                |
      | tomsmith    | InvalidPassword      | Your password is invalid!      |
      | invaliduser | SuperSecretPassword! | Your username is invalid!      |
      |             |                      | Your username is invalid!      |
      | tomsmith    |                      | Your password is invalid!      |

  Scenario: User can log out from the secure page
    Given I navigate to the login page
    When I enter a username "tomsmith" and password "SuperSecretPassword!"
    And I click the Login button
    And I should be on the secure page
    When I log out
    Then I should be redirected to the login page

  Scenario: User cannot access the secure page directly without logging in
    Given I navigate to the secure page directly
    Then I should be redirected to the login page
    And I should see a flash message containing "You must login to view the secure area!"
