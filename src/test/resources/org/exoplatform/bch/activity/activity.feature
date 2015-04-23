Feature: When an activity is created, it appears in the Activity Streams

  Scenario: the activity appears in the Activity Stream of the owner of the activity
    Given I publish an activity with title "Hello World!"
    When I consult my Activity Stream
    Then this activity is present in the stream