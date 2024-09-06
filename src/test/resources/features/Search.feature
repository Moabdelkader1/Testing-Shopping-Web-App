Feature: Searching for an item on an e-commerce website.

  Scenario: Search for an existing item
    Given the user is registered
    When the user searches for "shirt"
    Then five related results should be displayed