
Feature: Radio Buttons Tests

  Background:
    Given Navigate to Web Site
    And Go to Radio Buttons in Elements


  Scenario: Radio Buttons are clickable
    Then Verify that Radio Buttons are clickable

  Scenario: Yes Radio Button Test
    When Click to Yes Button
    Then Verify Yes text

  Scenario: Impressive Radio Button Test
    When Click to Impressive Button
    Then Verify Impressive text

  Scenario: No Radio Button Test
    When Click to No Button
    Then Verify No text

