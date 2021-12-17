
Feature: Create a new meeting
  As an admin user of the demo website
  I want to create a meeting with a business unit

  @Stable
  Scenario: Create a new meeting
    Given a User log in to the website
    When create a business unit
    And create a new meeting
    Then verify that the operation was successful