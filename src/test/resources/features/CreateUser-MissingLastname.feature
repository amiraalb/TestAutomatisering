Feature: Create an account - missing lastname.

  Scenario: Verify that account is not created and an error message is displayed when missing to fill in the lastname.
    Given I am using "<browser>" on the create an account page
    When I fill in birthdate "<birthdate>"
    And I fill in firstname "<firstname>"
    And I fill in email "<email>"
    And I fill in confirmEmail "<confirmEmail>"
    And I fill in password "<password>"
    And I fill in confirmPassword "<confirmPassword>"
    And I click on the mandatory check boxes and confirm button
    Then An error message is displayed.

    Examples:
      | browser | birthdate  | firstname |  | email                      | confirmEmail               | password  | confirmPassword |
      | chrome  | 25/01/1992 | Amira     |  | amira_test1234@hotmail.com | amira_test1234@hotmail.com | Amira1234 | Amira1234       |
      | edge    | 30/06/1984 | Anna      |  | test1235@hotmail.com       | test1235@hotmail.com       | Anna1234  | Anna1234        |
