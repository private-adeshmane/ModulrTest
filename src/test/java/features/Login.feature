Feature: Login feature for Modulr Customer Portal
As a Modulr customer user
I want to be able to login successfully to the Modulr Customer Portal
So that I can manage my Modulr accounts

   @automation
  Scenario Outline: AC01_To validate that username and password fields are required to login
    Given User launched Modulr Customer Portal
    When User provides "<username>" and "<password>"
    Then The error "<errorMsg>" displayed to the user
    Examples:
    |username       |password             |errorMsg                        |
    |               |                     |  This field is required   |
    |  dummyusername|                     |  This field is required   |
    |               |  dummypassword      |  This field is required   |
   
    
   @automation
  Scenario Outline: AC02_To validate that the adequate error message and warning displayed to the user for in-correct credentials
    Given User launched Modulr Customer Portal
    When User provides "<username>" and "<password>"
    Then The error "<errorMsg>" displayed to the user
    And Adequate warning for multiple attempts is displayed to the user
    Examples:
    |username       |password             |errorMsg                                |
    |  dummyusername|  dummypassword      |  The username or password is incorrect.|
    
  @automation
  Scenario Outline: AC03_To validate that user navigates to account overview page after successful login
    Given User launched Modulr Customer Portal
    When User provides "<username>" and "<password>"
    Then User navigates to account overview page

    Examples:
    |username         |password               |
    |  Adesh.Mane42   |  !Dummypassword1      |  
    
    @manual
  Scenario Outline: AC04_To validate that sign in button is disabled when user trying to login
    Given User launched Modulr Customer Portal
    When User provides "<username>" and "<password>" and clicks on Sign in
    Then Sign in button is disabled before navigating to account overview page

    Examples:
    |username         |password               |
    |  Adesh.Mane42   |  !Dummypassword1      |  
    
   @manual
  Scenario: AC05_To validate that user is able to reset the password
    Given User launched Modulr Customer Portal
    When User clicks on Forgotten password
    Then User navigates to Reset access screen
    And User enter username and clicks on Request a reset
    And User recieves the email to reset the password