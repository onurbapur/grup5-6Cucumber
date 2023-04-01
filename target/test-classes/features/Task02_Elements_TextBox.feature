Feature: Elements Text Box Tests

  Background:
    Given Navigate to Web Site
    And Go to Text Box in Elements


  Scenario: Test empty email
    When Enter the credentials
      | name             | Ahm             |
      | email            |                 |
      | currentAddress   | Istanbul/TURKEY |
      | permanentAddress | Ankara/TURKEY   |
    Then Verify that get error message by empty email


  Scenario: Test invalid email
    When Enter the credentials
      | name             | Ahm                     |
      | email            | falancaAhmetfalanca.com |
      | currentAddress   | Istanbul/TURKEY         |
      | permanentAddress | Ankara/TURKEY           |
    Then Verify that get error message by invalid email

  Scenario: Successfully registration
    When Enter the credentials
      | name             | Ahmet Falanca            |
      | email            | falancaAhmet@falanca.com |
      | currentAddress   | Istanbul/TURKEY          |
      | permanentAddress | Ankara/TURKEY            |
    Then Verify that get output box

  Scenario: Get empt boxes after successfully registration
    When Enter the credentials
      | name             | Ahmet Falanca            |
      | email            | falancaAhmet@falanca.com |
      | currentAddress   | Istanbul/TURKEY          |
      | permanentAddress | Ankara/TURKEY            |
    Then Verify that boxes are empty
