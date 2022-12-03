@smoke
  Feature: F04_Search | users will be able to search for products with different parameters
    Background: user log into system
      Given user navigate to Home page
      And user click on login
      When user enter valid "test1999@gmail.com" and valid "p@ssw0rd"
      And user clicks login button
      Then user logged in successfully

    Scenario Outline: Logged user could search using product name
      When user click on search field
      And user enter "<productname>" to search
      Then user find the product and relative products

      Examples:
      |productname|
        |book   |
        |laptop |
        |nike  |

    Scenario Outline: Logged user could search for product using sku
      When user click on search field
      And user enter "<sku>" to search
      Then user find "<sku>" product

      Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|

