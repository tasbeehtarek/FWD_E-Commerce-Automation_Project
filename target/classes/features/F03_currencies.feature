
@smoke
Feature: F03_Currency | testing currency
  Background: user log into system
    Given user navigate to Home page
    And user click on login
    When user enter valid "test1999@gmail.com" and valid "p@ssw0rd"
    And user clicks login button
    Then user logged in successfully

  Scenario: user could select euro currency
    When user select euro option
    Then euro symbol is displayed on all products
    When user choose USD from dropdown menu
    Then usd is selected successfully



