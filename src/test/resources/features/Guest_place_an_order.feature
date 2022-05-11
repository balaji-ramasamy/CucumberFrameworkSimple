Feature: place an order

  Scenario: using default payment option
    Given I'm a guest customer
    And my billing details are
      | firstName | lastName | country            | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And I have a "Blue Shoes" in the cart
    And I'm on the checkout page
    When I provide the billing details
    And I place an order
    Then the order should be placed successfully
