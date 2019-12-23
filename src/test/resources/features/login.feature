Feature: As a User I verify the various postive and negative Testcases on Login page

  @test 
  @testCase:VerifyErrorMessageWhenBothEmailIdAndPasswordAreBlank 
  @testCase:VerifyErrorMessageWhenOnlyEmailIdIsBlank 
  @testCase:VerifyErrorMessageWhenOnlyPasswordIsBlank 
  @testCase:VerifyErrorMessageWhenEmailIdFormatIsIncorrect 
  @testCase:VerifyErrorMessageWhenEmailIdIsCorrectButPasswordIsIncorrect 
  @testCase:VerifyErrorMessageWhenEmailIdIsInCorrectButPasswordIsCorrect
  Scenario Outline: Verify validations on login with Email Id and password
    Given I launch browser and open application
    When I enter "<email id>" and "<password>"
    And I click on Login button
    Then I verify the error message

    Examples: 
      | email id                    | password         |
      |                             |                  |
      | lr.user.test2019@gmail.com  |                  |
      |                             | Loginradius@2019 |
      | lr.user.test2019            | Loginradius@2019 |
      | lr.user.test2019@gmail.com  | abcd             |
      | lr.user.test2019@gmail.coma | Loginradius@2019 |

  @test 
  @testCase:VerifySuccessfulLoginWithEmailIdAndPassword
  Scenario Outline: Verify successful login with Email Id and password
    Given I launch browser and open application
    When I enter "<email id>" and "<password>"
    And I click on Login button
    Then I verify the home page displayed
    And I click on Logout
    Then I should Logout

    Examples: 
      | email id                   | password         |
      | lr.user.test2019@gmail.com | Loginradius@2019 |

  @test 
  @testCase:VerifySuccessfulLoginWithGoogleEmailIdAndPassword 
  @testCase:VerifyErrorMessageWhenGoogleEmailIdIsBlank 
  @testCase:VerifyErrorMessageWhenGooglePasswordIsBlank
  Scenario Outline: Verify successful login with Google Credentials
    Given I launch browser and open application
    When I click on Login with Google button
    And I Enter "" as email id and Click Next
    Then I verify the error message on popup
    And I Enter "<email id>" as email id and Click Next
    And I Enter "" as password and Click Next
    Then I verify the error message on popup
    And I Enter "<password>" as password and Click Next
    Then I verify the home page displayed
    And I click on Logout
    Then I should Logout

    Examples: 
      | email id                   | password         |
      | lr.user.test2019@gmail.com | Loginradius@2019 |
