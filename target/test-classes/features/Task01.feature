Feature: Basepage and Homepage Tests

  Scenario: Home Icon Test
    Given Navigate to Web Site
    When Click to HomeIcon
    Then Open Home Page

  Scenario: Test The Footer
    Given Navigate to Web Site
    Then Verify The Footer Text

  Scenario: Open Toolsqa Web Site
    Given Navigate to Web Site
    When Click to JOIN NOW
    Then Open ToolsQa Web Site on new Window

  Scenario: Menu List Size
    Given Navigate to Web Site
    Then The Menu Has Six Items