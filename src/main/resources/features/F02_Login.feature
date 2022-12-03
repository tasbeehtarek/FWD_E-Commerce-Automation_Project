
@smoke
Feature: F02_Login | users could login

  Scenario:  user could login with valid data
    Given user navigates to Home page
    And  user clicks on login button
    When user enter valid "test1999@gmail.com" and valid "p@ssw0rd"
    And user clicks login button
    Then user logged in successfully

    Scenario: user login with invalid username and password
      Given user navigates to Home page
      And  user clicks on login button
      When user enter valid "test11@ail.com" and valid "613p@"
      And user clicks login button
      Then user could not login





