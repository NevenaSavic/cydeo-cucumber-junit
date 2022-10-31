@Regression @smoke @wip @login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given user is on the library login page

@Librarian @smoke
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

@Student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

@Admin
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard