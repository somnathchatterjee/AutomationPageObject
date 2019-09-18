Feature: Check the login flow

  Scenario: Verify the login with valid credential
    Given User should navigate to finance junction URL
    And User should enter valid username and password
    When User click on Login button
    Then User should login successfully and able to view the Home page