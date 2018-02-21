#Author: robin.pierre16@outlook.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Traversing the Location page

  Background: I want to get on the location page
    Given I open up a web browser and I login as VP

  @VP
  Scenario: Adding a new room
    #Given I want to write a step with precondition
    #And some other precondition
    When I add a location
    And I add a building to the location
    And I add a room to the building
    Then I can edit the building
    And I logout

  @VP
  Scenario: I no longer have a building available in a location
    When I deactivate a location
    Then I logout
