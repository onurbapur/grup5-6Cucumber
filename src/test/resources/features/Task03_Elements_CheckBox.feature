Feature: Check Boxes Test
  Background:
    Given Navigate to Web Site
    And Go to Check Box in Elements

  Scenario: Select all file by select Home file
    When Select the Home
    Then Verify that result paragraph is display

  Scenario: Download CheckBox Test
    When Click to Plus Button
    And Click Download File Button
    Then Verify expected text by click Download