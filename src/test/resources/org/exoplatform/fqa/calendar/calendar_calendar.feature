Feature: Calendar api

    #Get

    Scenario: I create a calendar with a different owner from the authentificated one, i can't see it
      Given As mary, I create a calendar with name "calMary"
      When As john,  I get calendar
      Then Calendar named "calMary" is not show
#      And As mary, I delete calendar named "calMary"
#
#    Scenario: I create a calendar with owner mary and groups /platform/administrators
#      Given I log with "mary"
#      Given I create a calendar with name "calMarygroups" with "Mary" as owner and groups "/platform/administrators".
#      When I log with "john"
#      When I get calendar
#      Then Calendar named "calMarygroups" is show
#      And I log with "mary"
#      And I delete calendar named "calMarygroups"
#
#    Scenario:  I create a calendar with owner mary and give the right view to john
#      Given I log with "mary"
#      Given I create a calendar with name "calMaryShareView" with "mary" as owner and view permission for "john".
#      And I log with "John"
#      When I get calendar
#      Then Calendar named "calMaryShareView" is show
#      And I log with "mary"
#      And I delete calendar named "calMaryShareView"
#
#   Scenario: I get a calendar by id
#     Given I create a calendar with name "calId"
#     When I search calendar by id "id"
#     Then Calendar named "calId" is show
#     And I delete calendar named "calId"
#
#   Scenario: I show the calendar by type ( query input )
#    Given I create a calendar with name "calShareMary"
#     Given I share calendar named "calShareMary" with user "mary"
#     When I search calendar by type "<type>" i get calendar with name "<name>"
#     Then I delete calendar named "calShareMary"
#
#   Examples:
#   | type         | name |
#   | personal     |  John Smith   |
#   | group        |  Development   |
#   | group        |  Administration   |
#   | group        |  Users   |
#   | group        |  Content Management   |
#   | group        |  Executive Board   |
#   | group        |  Employees   |
#   | group        |  Executive Board   |
#   | shared       |  calShareMary   |
#
#
#     # TODO : Calendar ICS
#
#    #Post
#
#  Scenario: When i create 2 calendar with the same name i get back an error
#    Given I create a calendar with name "titi"
#    When I create a calendar with name "titi"
#    Then I receive error : bad request, 400
#
#  Scenario Outline: Create a calendar
#    When I create a calendar with name "<title>"
#    Then the HTTP status code of the response is <status>
#    Examples:
#      | title         | status |
#      |  mon calendar |  201   |
#      |  @#$@%$  ^&*& |  400   |
#      |  ""''         |  400   |
#      |               |  400   |
#
#  Scenario: Create a calendar with an other user name
#    When I create a calendar with name "testCal" and user name different from owner
#    Then I receive error : Unauthorized, 401

#    Put
#
#  Scenario: John update his calendar
#    Given I create a calendar with name "calToUp"
#    When I edit the description of the calendar named "calToUp" to "Here its a true description"
#    Then I get calendar
#    And The description of the calendar named "calToUp" is "Here its a true description"
#    And I delete calendar named "calToUp"
#
#  Scenario: John update the mary calendar but he doesn't have the edit rights
#    Given I log with "mary"
#    Given I create a calendar with name "calNotShare"
#    And I log with "john"
#    When I edit the description of the calendar named "calNotShare" to "Here its a true description"
#    Then I receive error : Unauthorized, 401
#    And I log with "mary"
#    And I delete calendar named "calNotShare"
#
#  Scenario: John update the mary's calendar and he have the edit rights
#    Given I log with "mary"
#    Given I create a calendar with name "calShareJohn" and edit rights for "john"
#    Given I log with "john"
#    When I edit the description of the calendar named "calShareJohn" to "Here its a true description"
#    Then I log with "mary"
#    Then I get calendar
#    Then The calendar named "calShareJohn" has description "Here its a true description"
#    And I delete calendar named "calShareJohn"
#
#    #delete
#
#  Scenario: John delete his calendar
#    Given I create a calendar with name "calToDelete"
#    When I delete calendar named "calToDelete"
#    Then I get calendar
#    And The calendar named "calToDelete" is not show
#
#  Scenario: John try to delete the mary's calendar without any rights
#    Given I log with "mary"
#    Given I create a calendar with name "maryNotDelete"
#    Given I log with "john"
#    When I delete calendar named "maryNotDelete"
#    Then I receive error : Unauthorized, 401
#    Then I log with "mary"
#    Then I delete calendar named "maryNotDelete"

