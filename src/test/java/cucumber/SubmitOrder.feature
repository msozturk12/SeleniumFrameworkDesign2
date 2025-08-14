@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
    Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and <password>
    When  I add <productName> to Cart
    And   Checkout <productName> and submit the order
    Then  "THANKYOU FOR THE ORDER." message is displayed on ConfirmationsPage

    Examples:
      | name              | password | productName |
      | Test123@gmail.com | Test123  | ZARA COAT 3 |

