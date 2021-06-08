@smoke
Feature: Codewars Verification

  @TC1
  Scenario: User logs into CodeWars
    Then the user is on the homepage and title is "Home | Codewars"

  @TC2
  Scenario:User enrolls in a course
    When the user clicks train button
    Then user enrolls in a course and title should start with "Training on"

  @TC3
  Scenario Outline:User search the keyword and validate
    When the user search the  '<keyword>'
    Then user sees the results related with keyword
    Examples:
      | keyword    |
      | Java       |
      | Javascript |





