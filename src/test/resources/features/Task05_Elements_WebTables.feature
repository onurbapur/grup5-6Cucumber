#Test1: Add new row
# Test2: Delete a row
# Test3: Edit a row
# Test4: Get text from a cell ex: kierra's email

@TS_WT_001
Feature: Web Tables Tests

  Background:
    Given Navigate to Web Site
    And Go to Web Tables in Elements


  Scenario: Add a new row
    When Click to Add Button for new record
    And Enter the credentials of person
      | firstName  | mehmet                   |
      | lastName   | Falanca                  |
      | email      | falancaAhmet@falanca.com |
      | age        | 40                       |
      | salary     | 15000                    |
      | department | SDET-QA                  |
    Then verify add new row by checking email is "falancaAhmet@falanca.com"

  @TC_WT_Delete_001
  Scenario: Delete a row by email
    When Click Delete Button on a row by email "cierra@example.com"
    Then Verify that the row by email "cierra@example.com" is deleted

  @TC_WT_Edit_001
  Scenario:Edit salary by email
    When Click Edit Button on a row by email "alden@example.com"
    And Edit Salary "15000"
    And Click Submit Button
    Then Verify that Salary is "15000" on a row by email "alden@example.com"


  Scenario: Add a new record and delete it
    When Click to Add Button for new record
    And Enter the credentials of person
      | firstName  | mehmet                   |
      | lastName   | Falanca                  |
      | email      | falancaAhmet@falanca.com |
      | age        | 40                       |
      | salary     | 15000                    |
      | department | SDET-QA                  |
    When Click Delete Button on a row by email "falancaAhmet@falanca.com"
    Then Verify that the row by email "falancaAhmet@falanca.com" is deleted

  @wip
  Scenario: Get text of any cell
    When Get text from "Kierra" 's email
    Then Verify that the text you get equals "kierra@example.com"

