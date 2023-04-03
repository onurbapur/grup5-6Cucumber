@TC_WT_SelectRows
Feature: Select Rows and Previous and Next Buttons

  Background: Go to Web Tables in Elements
    Given Navigate to Web Site
    And Go to Web Tables in Elements

  @TC_WT_SelectRows_001 @wip
  Scenario: Select number of lines  for a page
    When Add 10 new rows by JavaFaker
    And Select 5 rows for a page
    Then verify that there are 5 rows on the page
