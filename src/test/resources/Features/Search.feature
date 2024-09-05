Feature: Searching for an item on an e-commerce website.

  Scenario: Search for an item that already exists
    Given the user registered
    When the user searches for shirt
    Then five related results should be shown