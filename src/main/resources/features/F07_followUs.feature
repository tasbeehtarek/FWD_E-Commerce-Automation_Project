@smoke
  Feature: F07_followUs |  users could open followUs links

    Background: user log into system
      Given user navigate to Home page
      And user click on login
      When user enter valid "test1999@gmail.com" and valid "p@ssw0rd"
      And user clicks login button
      Then user logged in successfully

    Scenario: user opens facebook link
      When user click on facebook
      Then navigated to facebook "https://www.facebook.com/nopCommerce"

      Scenario:  user opens twitter link
        When user click on twitter icon
        Then navigated to twitter "https://twitter.com/nopCommerce"


    Scenario: user opens rss link
      When user click on rss icon
      Then navigated to rss "https://demo.nopcommerce.com/nopcommerce-new-release"

    Scenario: ouser opens youtube link
      When user click on youtube icon
      Then navigated to youtube "https://www.youtube.com/user/nopCommerce"

