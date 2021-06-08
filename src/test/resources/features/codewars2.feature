@smoke
Feature: Codewars Verification

  @TC4
  Scenario Outline:User provides invalid credentials
    When the user provides the invalid '<username>' and '<password>'
    Then the user shouldn't be able to login
    Examples:
      | username                   | password          |
      | wrongusername@username.com | codewars          |
      | username@gmail.com         | password123       |



