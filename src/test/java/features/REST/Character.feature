Feature: Test Rick and Morty Character API

  @regression
  Scenario: As a user I want to successfully get all characters
    Given I set a basic request to character
    When I get the results
    Then I should receive a json response with first page characters

  @regression
  Scenario Outline: As a user I want to successfully get a filtered list of characters
    Given I set a basic request to character
    Given I filter with <param> and <value>
    When I get the results
    Then I should receive a json response with <param> and <value> characters

    Examples:
      | param   | value       |
      | name    | Johnny Depp |
      | status  | Alive       |
      | status  | unknown     |
      | species | Alien       |
      | type    | Mytholog    |
      | gender  | Genderless  |

@regression
  Scenario Outline: As a user I want to get an error filtering with invalid parameter
    Given I set a basic request to character
    Given I filter with <param> and <value>
    When I get the results
    Then I should receive a 404 Not Found error

    Examples:
      | param | value |
      | name  | 14    |
      | page  | 43    |
