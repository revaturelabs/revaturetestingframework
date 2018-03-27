#Author: your.email@your.domain.com
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
@tag
Feature: associate Info
  I want to use this template for my feature file
  
 Background: Getting to the associate info
 Given I am in the associate List page 
 But I am in the in the batch list page
 When I click on the assocaite id
 Then I am in the associate info page
 
  @tag1
  Scenario: update associate form
    Given Now I am in the associate info page
    When I check associate mapped
    And check associate eligible for an interview
    And check associate scheduled for an interview
    And select assigned client
    And check associate cleared all interviews
    And check email been received from the client
    And check associate passed a background check
    And check associate have a start date
    And Enter starting date
    Then Associate info succefully updated
   

  @tag2
  Scenario: Manually Update form
    Given Now I am in the associate info page
    When I select a status and 
    And I assign a client
    And I apply starting date 
    Then Associate info succefully updated
    
@tag3
  Scenario: Create new interview form
  Given Now I am in teh associate info page 
  And Click on Toggle create new Interview form
  When I select client interviewing
  And I enter interview date
  And I select interview type
  Then the interview is added 
  