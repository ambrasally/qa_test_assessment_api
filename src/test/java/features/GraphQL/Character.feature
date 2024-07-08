Feature: Test Rick and Morty Character API

@regression
  Scenario: Query Rick and Morty API for characters
    Given I have a GraphQL query for characters
    When I send the query to the Rick and Morty GraphQL API
    Then I receive a response containing character details