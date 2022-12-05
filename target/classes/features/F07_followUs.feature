@smoke
  Feature: F07_followUs |  users could open followUs links

    Scenario: user opens facebook link
      When user click on facebook
      Then user navigated to page in new tap "https://www.facebook.com/nopCommerce"

      Scenario:  user opens twitter link
        When user click on twitter icon
        Then user navigated to page in new tap "https://twitter.com/nopCommerce"


    Scenario: user opens rss link
      When user click on rss icon
      Then user navigated to page in new tap "https://demo.nopcommerce.com/nopcommerce-new-release"

    Scenario: user opens youtube link
      When user click on youtube icon
      Then user navigated to page in new tap "https://www.youtube.com/user/nopCommerce"

