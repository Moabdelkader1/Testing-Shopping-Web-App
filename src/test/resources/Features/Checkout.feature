Feature: Checkout an item on an e-commerce website.

  Scenario: Checkout a men's jacket successfully
    Given the user is registered
      And the user adds a jacket to the cart
    When the user checkout jacket from the cart
    Then The purchase is completed and total price should appear
      And the user receives a confirmation


