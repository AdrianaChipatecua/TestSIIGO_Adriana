@test
Feature: The user can login to the application

  Scenario: The user can login with valid credentials
    Given Laura is on the login page
    When she enters valid credentials
    Then the user is redirected to the home page


  Scenario: The user create a client
    Given Laura is on the login page
    And she enters valid credentials
    When she goes to the create client form
    Then the user is redirected to the create client page

