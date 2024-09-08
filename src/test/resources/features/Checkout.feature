Feature: Checkout an item on an e-commerce website.

  Background:
    Given the user is registered

  Scenario: Checkout a men's jacket successfully
    Given the user has added a men's jacket to the cart
    When the user proceeds to checkout
    Then the total price should be displayed
      And the user should receive a confirmation
