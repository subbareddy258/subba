@searchLivingProducts
Feature: Search Living Products
  As a user
  I want to search for living products
  So that I can find the desired items

  Background:
    Given I am on the Urban Ladder home page

  Scenario: Search for a living product
    When I search for "sofa"
    Then I should see search results related to "sofa"

  Scenario Outline: Search for different living products
    When I search for "<product>"
    Then I should see search results related to "<product>"

    Examples:
      | product  |
      | chair    |
      | table    |
