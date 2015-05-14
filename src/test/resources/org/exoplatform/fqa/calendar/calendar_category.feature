Feature: All the test about the category api

  Scenario: When you ask for category, the basic categories are displayed
    When I get the list of categories
    Then the list contains the default categories