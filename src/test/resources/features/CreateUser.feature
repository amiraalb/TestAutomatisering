Feature: Create an account successfully

  Scenario Outline: Create an account successfully by filling in all the mandatory fields and checking in the mandatory boxes
    Given I am using "<browser>" on the create an account page
    When I fill in birthdate "<birthdate>"
    And I fill in firstname "<firstname>"
    And I fill in lastname "<lastname>"
    And I fill in email "<email>"
    And I fill in confirmEmail "<confirmEmail>"
    And I fill in password "<password>"
    And I fill in confirmPassword "<confirmPassword>"
    And I click on the mandatory check boxes and confirm button
    Then A new account is successfully created

    Examples:
      | browser | birthdate  | firstname | lastname  | email                     | confirmEmail              | password  | confirmPassword |
      | chrome  | 25/01/1992 | Amira     | Test      | amira_test100@hotmail.com | amira_test100@hotmail.com | Amira1234 | Amira1234       |
      | edge    | 30/06/1984 | Anna      | Svensson  | test100@hotmail.com       | test100@hotmail.com       | Anna1234  | Anna1234        |
      | firefox | 01/01/1991 | Johan     | Johansson | johantest100@hotmail.com  | johantest100@hotmail.com   | Johan1234 | Johan1234       |
