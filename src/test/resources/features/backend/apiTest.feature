@testAPI
Feature: Verify the API endpoints

  Scenario: Verify the request to get the list of users.
    Given Laura starts the test
    When she consults the list of users on page "1"
    Then the list of users will be displayed

  Scenario: User without password tries to register via API
    Given Eve starts the test
    When she tries to log in without sending the password
    Then the error message "Missing password" will be displayed

  Scenario: The user makes a change to the system
    Given Eve starts the test
    When she makes a change to the system
    Then the date of the change should be recorded

  Scenario: The user tries to be deleted with a non-existent id
    Given Eve starts the test
    When she tries to delete a user with a non-existent id
    Then the response code 204 will be generated