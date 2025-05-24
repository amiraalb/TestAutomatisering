Feature: Create an account - password missmatch.

  Scenario: Verify that account is not created and an error message is displayed when password doesn't match.
    Given I am using "<browser>" on the create an account page
    When I fill in birthdate "<birthdate>"
    And I fill in firstname "<firstname>"
    And I fill in lastname "<lastname>"
    And I fill in email "<email>"
    And I fill in confirmEmail "<confirmEmail>"
    And I fill in password "<password>"
    And I fill in confirmPassword "<confirmPassword>"
    And I click on the mandatory check boxes and confirm button
    Then An error message is displayed and the account is not created.


    Examples:
      | browser | birthdate  | firstname | lastname | email                      | confirmEmail               | password  | confirmPassword |
      | chrome  | 25/01/1992 | Amira     | Test     | amira_test1234@hotmail.com | amira_test1234@hotmail.com | Amira1234 | Amira12345      |
      | edge    | 30/06/1984 | Anna      | Svensson | test1235@hotmail.com       | test1235@hotmail.com       | Anna1234  | Anna12345       |
