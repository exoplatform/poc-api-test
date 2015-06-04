Cucumber test, rest API eXo platform

##  Informations
Cucumber test for the rest API Calendar with plf 4.2.x
Calendar rest api adress : http://<'adress of plf'>:8080/rest/private/v1/calendar

##  Configuration
Java jdk : 1.8 minimum

##  Functional Tests
Functional tests use Cucumber (example in *activity.feature*)
```cucumber
Feature: When an activity is created, it appears in the Activity Streams

  Scenario: the activity appears in the Activity Stream of the owner of the activity
    Given I publish an activity with title "Hello World!"
    When I consult my Activity Stream
    Then this activity is present in the stream
```

Cucumber call the REST API through Retrofit REST Client library
```maven
mvn test
```

##  How to run :
- mvn clean install the project
- Write the ip of the computer where Platform is running in the class ConnectedStepDefinitions.
- Launch as cucumber test from class CalendarFuncTest


Tags on features :
@eXoApiError -> The feature run well but there is a bug on platform so the test will fail.

