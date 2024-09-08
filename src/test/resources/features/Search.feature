Feature: Searching for an item on an e-commerce website.

  Scenario: Search for an existing item
    When the user searches for "shirt"
    Then five related results should be displayed

  Scenario: Search for an item that does not exist
    When the user searches for "spaceship"
    Then a message should indicate that no items were found