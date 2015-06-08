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

      # John can't see the calendar. In request we can see that john is in view permission
  @eXoApiError
  Scenario:  I create a calendar with owner mary and give the right view to john
    Given As mary, I create a calendar with name "calMaryShareView" and give view permission for "john" .
    When As john, I get calendar
    Then Calendar named "calMaryShareView" is show
    And As mary, I get calendar
    And As mary, I delete calendar named "calMaryShareView"

  # all the types are 0
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

  # Two calendars with the same name are created

  Scenario: When i create 2 calendar with the same name i get back an error
    Given As john, I create a calendar with name "calJo"
    When As john, I create a calendar with name "calJo"
    When As john, I get calendar
    And  As john, I delete calendar named "calJo"
    And  As john, I delete calendar named "calJo"

#TODO
  Scenario: I create a calendar with all the fields fill

#TODO
  Scenario: I give view permission to 2 users, the both can see it
#TODO
  Scenario: I give editionPermission to 2 users, both can edit

  Scenario Outline: Create a calendar with differents chars for the name
    When I create a calendar with name "<title>"
    Then the HTTP status code of the response is <status>
    Examples:
      | title         | status |
      |  mon calendar |  201   |
      |  @#$@%$  ^&*& |  400   |
      |  ""''         |  400   |
      |               |  400   |

  # 401 unauthorized make the test failed
  @Error
  Scenario: Create a calendar with an other user name
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

  # receiver unauthorized make the test failed

   Scenario: John update the mary calendar but he doesn't have the edit rights
    Given As mary, I create a calendar with name "CalNotShareJohn"
    Given As mary, I get calendar
    When As john, I edit the description of calendar "CalNotShareJohn" for "Here its a true description"
    Then I receive error : Unauthorized, 401
    Given As mary, I get calendar
    Then As mary, I delete calendar named "CalNotShareJohn"

    #Problem to edit

    Scenario: John update the id of his calendar
      Given As john, I create a calendar with name "idToUp"
      Given As john, I get calendar
      When As john, I edit the id of calendar named "idToUp" for "cal11232"
      Then As john, I get calendar
      Then The calendar "idToUp" has not the id "cal11232"
      And As john, I get calendar
      And As john, I delete calendar named "IdToUp"


    Scenario: John update all the fields ( not id, owner )
      Given As john, I create a calendar with name "CaleditAll"
      Given As john, I get calendar
      When As john, I edit all fields for calendar named "CaleditAll" : name "newName", description "newDescription", color "black", groups "/platform/web-contributors", timezone "Europe/Brussels", editPermission "mary", viewPermission "mary"
      Then As john, I get calendar
      Then Calendar named "newName" is show
      Then Calendar named "CaleditAll" is not show
      Then The description of the calendar named "newName" is "newDescription"
      Then The color of the calendar named "newName" is "black"
      Then The groups of the calendar named "newName" is "/platform/web-contributors"
      Then The timezone of the calendar named "newName" is "Europe/Brussels"
      Then The editPermission of the calendar named "newName" contains "mary"
      Then The viewPermission of the calendar named "newName" contains "mary"
      Then As john, I delete calendar named "newName"

    Scenario: John update the owner of his calendar for mary
      Given As john, I create a calendar with name "calForMary"
      Given As john, I get calendar
      When As john, I edit field owner for calendar name "calForMary" to "mary"
      Then I receive error : Unauthorized, 401
      Then As john, I delete calendar named "calForMary"

    Scenario: John update the name of the calendar for amn existing name


  Scenario: John update the mary's calendar and he have the edit rights. Also check that a share calendar has type 1
    Given As mary, I create a calendar with name "CalShareJohn" and edit right for john
    Given As john, I get calendar
    Given Calendar type 1 with name CalShareJohn is show
    When As john, I edit the description of calendar "calShareJohn" for "Here its a true description"
    Then As mary, I get calendar
    Then The calendar named "calShareJohn" has description "Here its a true description"
    And I delete calendar named "calShareJohn"

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


  @Test
  Scenario: Mary create a calendar and give edit right to John. John delete the calendar. He will not be able to see it
    Given As mary, I create a calendar with name "shareJohn" and edit right for john
    Given As mary, I get calendar
    Given Calendar named "shareJohn" is show
    When As john, I delete calendar named "shareJohn"
    Then As john, I get calendar
    Then Calendar named "shareJohn" is not show
    And As mary, I get calendar
    And As mary, I delete calendar named "shareJohn"