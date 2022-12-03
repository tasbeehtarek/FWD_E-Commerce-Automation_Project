@smoke
Feature: Shopping Cart | user could add products to Shopping Cart


  Scenario: user could add products to the Cart
    Given user go to home page
    When user add HTC_M8Android to the cart
    And user click add_to_cart button_1
    Then success message appears_1
    When user add Apple_MacBook to the cart
    And user click add_to_cart button_2
    Then success message appears_2
    When user add gift card to the cart
    And user fills the mandatory fields
    And user click add_to_cart button_3
    Then success message appears_3


  Scenario: user could add products to the Cart
    Given user go to home page
    When user add HTC_M8Android to the cart
    And user click add_to_cart button_1
    Then success message appears_1
    When user add nokia_lumia_1020 to the cart
    And user click add_to_cart button_2
    Then success message appears_2
    When user add gift card to the cart
    And user fills the mandatory fields
    And user click add_to_cart button_3
    Then success message appears_3