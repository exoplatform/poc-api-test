Feature: Calendar api

    #----------------      Get      --------------------#

  Scenario: Mary create a calendar, John connect and ask calendar, he can't see the mary's calendar
    Given As mary, I create a calendar with name "calMary"
    When As john, I get calendar
    Then Calendar named "calMary" is not show
    And As mary, I get calendar
    And As mary, I delete calendar named "calMary"


#  CAL-1123 : The calendar don't has user if no specified and no one has edit rights
  @eXoApiError
  Scenario: I create a calendar with mary and groups /platform/users
    Given As mary, I create a calendar with name "calMarygroups" and groups "/platform/users".
    When As john, I get calendar
    Then Calendar named "calMarygroups" is show
    And As mary, I get calendar
    And As mary, I delete calendar named "calMarygroups"
    And As mary, I get calendar
    And Calendar named "calMarygroups" is not show

#  CAL-1124 : John can't see the calendar. In request we can see that john is in view permission
  @eXoApiError
  Scenario:  I create a calendar with owner mary and give the right view to john
    Given As mary, I create a calendar with name "calMaryShareView" and give view permission for "john" .
    When As john, I get calendar
    Then Calendar named "calMaryShareView" is show
    And As mary, I get calendar
    And As mary, I delete calendar named "calMaryShareView"

  # CAL-1127: all the types are 0
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



    #----------------      Post     --------------------#

  #CAL-1135 : John can't add a group
  #CAL-1123 : John is not the owner
@eXoApiError
  Scenario: I create a calendar with all the fields fill
    Given As john, I create a calendar with thoses fields fill : name "johnCalenNew", description "newDescription", color "black", groups "/platform/users", timezone "Europe/Brussels", editPermission "mary", viewPermission "mary"
    When As john, I get calendar
    Then Calendar named "johnCalenNew" is show
    Then The description of the calendar named "johnCalenNew" is "newDescription"
    Then The color of the calendar named "johnCalenNew" is "black"
    Then The groups of the calendar named "johnCalenNew" is "/platform/users"
    Then The timezone of the calendar named "johnCalenNew" is "Europe/Brussels"
    Then The editPermission of the calendar named "johnCalenNew" contains "mary;"
    Then The viewPermission of the calendar named "johnCalenNew" contains "mary;"
    Then As john, I delete calendar named "johnCalenNew"

#  CAL-1124 : edit/view permission is fill but the users can't see it
@eXoApiError
  Scenario: I give view permission to 2 users, the both can see it
    Given As john, I create a calendar with name "calShareTwo" and edit/view permission for mary;james
    When As mary, I get calendar
    Then Calendar named "calShareTwo" is show
    When As james, I get calendar
    Then Calendar named "CalShareTwo" is show
    And As john, I get calendar
    And As john, I delete calendar named "CalShareTwo"

#  CAL-1124 : edit/view permission is fill but the users can't see it
  @eXoApiError
  Scenario: I give editionPermission to 2 users, both can edit
    Given As john, I create a calendar with name "calShareTwo" and edit/view permission for mary;james
    When As mary, I get calendar
    Then Calendar named "calShareTwo" is show
    Then As mary, I edit the description of calendar "calShareTwo" for "maryDescription"
    When As james, I get calendar
    Then Calendar named "CalShareTwo" is show
    Then The description of the calendar named "CalShareTwo" is "maryDescription"
    Then As james, I edit the description of calendar "calShareTwo" for "jamesDescription"
    And As john, I get calendar
    Then The description of the calendar named "CalShareTwo" is "jamesDescription"
    And As john, I delete calendar named "CalShareTwo"

  Scenario Outline: Create a calendar with differents chars for the name
    When I create a calendar with name "<title>"
    Then the HTTP status code of the response is <status>
    Examples:
      | title         | status |
      |  mon calendar |  201   |
      |  @#$@%$  ^&*& |  400   |
      |  ""''         |  400   |
      |               |  400   |


  Scenario: Create a calendarCalTypeChange with an other user name
    When I create a calendar with name "testCal" and user name different from owner
    Then I receive error : Unauthorized, 401

  #----------------      Put     --------------------#



  Scenario:John update the description of the calendar.
    Given As john, I create a calendar with name "calToUp"
    Given As john, I get calendar
    When As john, I edit the description of calendar "calToUp" for "my new description"
    Then As john, I get calendar
    And The description of the calendar named "calToUp" is "my new description"
    And As john, I delete calendar named "calToUp"


   Scenario: John update the mary calendar but he doesn't have the edit rights
    Given As mary, I create a calendar with name "CalNotShareJohn"
    Given As mary, I get calendar
    When As john, I edit the description of calendar "CalNotShareJohn" for "Here its a true description"
    Then I receive error : Unauthorized, 401
    Given As mary, I get calendar
    Then As mary, I delete calendar named "CalNotShareJohn"


    Scenario: John update the id of his calendar
      Given As john, I create a calendar with name "idToUp"
      Given As john, I get calendar
      When As john, I edit the id of calendar named "idToUp" for "cal11232"
      Then As john, I get calendar
      Then The calendar "idToUp" has not the id "cal11232"
      And As john, I get calendar
      And As john, I delete calendar named "idToUp"

  # CAL-1136 : impossible to edit the groups
    @eXoApiError
    Scenario: John update all the fields ( not id, owner )
      Given As john, I create a calendar with name "CaleditAll"
      Given As john, I get calendar
      When As john, I edit all fields for calendar named "CaleditAll" : name "newName", description "newDescription", color "black", groups "/platform/users", timezone "Europe/Brussels", editPermission "mary", viewPermission "mary"
      Then As john, I get calendar
      Then Calendar named "newName" is show
      Then Calendar named "CaleditAll" is not show
      Then The description of the calendar named "newName" is "newDescription"
      Then The color of the calendar named "newName" is "black"
      Then The groups of the calendar named "newName" is "/platform/users"
      Then The timezone of the calendar named "newName" is "Europe/Brussels"
      Then The editPermission of the calendar named "newName" contains "mary;"
      Then The viewPermission of the calendar named "newName" contains "mary"
      Then As john, I delete calendar named "newName"

# CAL-1137 : return code is 200 but the field is not edit
  @eXoApiError
    Scenario: John update the owner of his calendar for mary
      Given As john, I create a calendar with name "calForMary"
      Given As john, I get calendar
      When As john, I edit field owner for calendar name "calForMary" to "mary"
      Then I receive error : Unauthorized, 401
      Then As john, I delete calendar named "calForMary"

    # CAL-1124 : john can't see the calendar
  @eXoApiError
  Scenario: John update the mary's calendar and he have the edit rights
    Given As mary, I create a calendar with name "calShareJohn" and edit/view permission for john
    Given As john, I get calendar
    When As john, I edit the description of calendar "calShareJohn" for "Here its a true description"
    Then As mary, I get calendar
    Then The description of the calendar named "calShareJohn" is "Here its a true description"
    And As mary, I delete calendar named "calShareJohn"


  #TODO : Create a calendar with mary. Give edit/view permission for john and james. John try to remove the edit/view permission of james. He can't do it.

        #----------------      Delete     --------------------#


  Scenario: John delete his calendar
    Given As john, I create a calendar with name "calDelJohn21"
    Given As john, I get calendar
    When As john, I delete calendar named "calDelJohn21"
    Then As john, I get calendar
    Then Calendar named "calDelJohn21" is not show

  Scenario: John try to delete the mary's calendar without any rights
    Given As mary, I create a calendar with name "maryNotDelete"
    Given As mary, I get calendar
    When As john, I delete calendar named "maryNotDelete"
    Then I receive error : Unauthorized, 401
    Given As mary, I get calendar
    Then As mary, I delete calendar named "maryNotDelete"

        # Jira : CAL-1134
  @eXoApiError
  Scenario: Mary create a calendar and give edit right to John. John delete the calendar. He will not be able to see it and the calendar is type 0 ( not share )
    Given As john, I create a calendar with name "CalTypeChange" and edit/view permission for mary
    Given As mary, I get calendar
    Given Calendar type 1 with name CalTypeChange is show
    When As mary, I delete calendar named "CalTypeChange"
    Then As mary, I get calendar
    Then Calendar named "CalTypeChange" is not show
    And As john, I get calendar
    Given Calendar type 0 with name CalTypeChange is show
    And As john, I delete calendar named "CalTypeChange"