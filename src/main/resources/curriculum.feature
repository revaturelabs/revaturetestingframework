#Author: robin.pierre16@outlook.com
#Keywords Summary : Traversing the curriculum page
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

Feature: Traversing the curriculum page

  Background: I want to get to the curriculum page
    Given I open up a web browser
    And I login as VP in curriculum
    And I navigate to the curriculum tab



  Scenario: Edit a curriculum
    When I edit the curriculum name
    Then I logout from curriculum page
    And I close the browser

  #Scenario: Add a curriculum
    #When I add a curriculum
    #Then I logout
    #And I close the browser

  Scenario: Add a focus
    When I add a focus
    Then I logout from curriculum page
    And I close the browser

  Scenario: Edit a focus
    When I edit a focus
    Then I logout from curriculum page
    And I close the browser

  Scenario: Add a skill
    When I add a skill
    Then I logout from curriculum page
    And I close the browser

  Scenario: Add a skill to a curriculum
    When I add a skill to a curriculum
    Then I logout from curriculum page
    And I close the browser

  Scenario: Add a skill to a focus
    When I add a skill to a focus
    Then I logout from curriculum page
    And I close the browser
