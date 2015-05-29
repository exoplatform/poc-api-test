Feature: Calendar api

    #----------------      Get      --------------------#
    Scenario: Mary create a calendar. John connect and ask calendar. He can't see the mary's calendar
      Given As mary, I create a calendar with name "calMary"
      When As john, I get calendar
      Then Calendar named "calMary" is not show
      And As mary, I get calendar
      And As mary, I delete calendar named "calMary"

     # The calendar don't has user if no specified and no one has edit rights
  @eXoApiError
    Scenario: I create a calendar with mary and groups /platform/users
       Given As mary, I create a calendar with name "calMarygroups" and groups "/platform/users".
       When As john, I get calendar
       Then Calendar named "calMarygroups" is show
       And As mary, I get calendar
       And As mary, I delete calendar named "calMarygroups"

      # Jonh can't see the calendar. In request we can see that john is in view permision
  @eXoApiError
  Scenario:  I create a calendar with owner mary and give the right view to john
        Given As mary, I create a calendar with name "calMaryShareView" and give view permission for "john" .
        When As john, I get calendar
        Then Calendar named "calMaryShareView" is show
        And As mary, I get calendar
        And As mary, I delete calendar named "calMaryShareView"


    #error, json get is null
  @eXoApiError
   Scenario Outline: I show the calendar by type ( query input )
     Given As john, I get calendar
     Then Calendar type <type> with name <name> is show
      Examples:
        | type         | name |
        | 0        |  John Smith   |
        | 2        |  Development   |
        | 2        |  Administration   |
        | 2        |  Users   |
        | 2        |  Content Management   |
        | 2        |  Executive Board   |
        | 2        |  Employees   |
        | 2        |  Executive Board   |
#        | shared       |  calShareMary   |


     # TODO : Calendar ICS

    #----------------      Post     --------------------#

  # Two calendars with the same name are created
  @eXoApiError
  Scenario: When i create 2 calendar with the same name i get back an error
    Given As john, I create a calendar with name "calJo"
    When As john, I create a calendar with name "calJo"
    Then I receive error : bad request, 400
    When As john, I get calendar
    And  As john, I delete calendar named "calJo"


#  Scenario Outline: Create a calendar
#    When I create a calendar with name "<title>"
#    Then the HTTP status code of the response is <status>
#    Examples:
#      | title         | status |
#      |  mon calendar |  201   |
#      |  @#$@%$  ^&*& |  400   |
#      |  ""''         |  400   |
#      |               |  400   |


  Scenario: Create a calendar with an other user name
    When I create a calendar with name "testCal" and user name different from owner
    Then I receive error : Unauthorized, 401

  #----------------      Put     --------------------#
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
        #----------------      Delete     --------------------#
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


    Scenario:
    Given I ask for ics


  @Test
  Scenario: Mary create a calendar and give edit right to John. John delete the calendar. He will not be able to see it
    Given As mary, I create a calendar with name "shareJohn" and edit right for john
    Given As john, I get calendar
    Given Calendar named "shareJohn" is show
    When As john, I delete calendar named "shareJohn"
    Then As john, I get calendar
    Then Calendar named "shareJohn" is not show
    And As mary, I get calendar
    And As mary, I delete calendar named "shareJohn"

