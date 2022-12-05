@smoke
  Feature: F04_Search | users will be able to search for products with different parameters

    Scenario Outline: Logged user could search using product name
     // Given user enter to login page
     // And nd User Enter valid username and valid password
      When User search with "<ProductName>"
      Then User can find "<ProductName>"

      Examples:
        | ProductName |
        | books       |
        | Laptops     |
        | nike        |

    Scenario: User need to search with sku
      When  user search with "NK_FRC_RS"
      And click on product image
      Then Page should be appeared with sku

