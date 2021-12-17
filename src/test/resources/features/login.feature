
Feature: Login validation
  As a user of the demo website
  I want to verify the Login in
  To guarantee the correct system access

  @Stable
  Scenario: Success login
    Given User wants to access the demo website
    When user enter the credentials
    Then user verify access to system