@smoke
Feature: Slider| user could click on page sliders


  Scenario: user could click on page sliders
    When User Clicks on Nokia Slider
    And Nokia URL should be appeared

    Scenario: user click on second slider
      When User clicks on iphone slider
      Then Iphone URL should be appeared
