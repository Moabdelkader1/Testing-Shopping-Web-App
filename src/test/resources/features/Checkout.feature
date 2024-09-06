Feature: Checkout an item on an e-commerce website.

  Scenario: Checkout a men's jacket successfully
    Given the user is registered
      And the user has added a men's jacket to the cart
    When the user proceeds to checkout
    Then the total price should be displayed
      And the user should receive a confirmation

