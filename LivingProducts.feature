@searchLivingProducts
Feature: Filter Living Products
  As a user
  I want to filter living products
  So that I can refine my search

  Background:
    Given I am on the Urban Ladder search page

  Scenario: Search living product and find max and min price
    When I select PrayerUnits from living products
    Then I Get All prices and found max and min price


  Scenario: Search living product and sort by low to high price
    When I select PrayerUnits from living products
    Then find all prices in low to high range




