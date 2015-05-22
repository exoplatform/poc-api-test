Feature: All the test about the category api

  Scenario: When you ask for category, the basic categories are displayed
    When I get the list of categories
    Then the list contains the default categories


  Scenario: When you ask for category, you personnal categories are displayed
    Given I add a personnal category named "personnalCat"
    When  I get the list of categories
    Then the list contains the personnal categories

