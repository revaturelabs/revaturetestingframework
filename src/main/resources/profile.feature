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

  @Trainer
Feature: Traversing the profile page
  I want to traverse the profile page
  
  Background: I am logged in as a trainer and I am on the profile page
  	Given I open a browser to go to AssignForce
  	And log in as a trainer
  	And I click on the profile tab
  	

#Scenario: I want to add a skill
    #Given I do not have "Not William WebDriver" as a skill
    #When I click on "Not William WebDriver" from choose skills
    #And I save the skills
    #Then 	I should see "Not William WebDriver" on my list of skills
    #Then I Log out
    #And close the window
    #
    #
#Scenario: I want to remove a skill
   #	Given I have "Not William WebDriver" as a skill
   #	When I click on "Not William WebDriver" to remove from current skills
   #	And I save the skills
   #	Then I should see "Not William WebDriver" on the list of skills to choose from
   #	Then I Log out
    #And close the window

Scenario Outline: I want to add a skill
    Given I do not have <skill> as a skill
    When I click on <skill> from choose skills
    And I save the skills
    Then 	I should see <skill> on my list of skills
    Then I Log out
    And close the window
    
    Examples:
    |skill|
    |"Not William WebDriver"|
    |"Robin Script" |
    |"Manual Testing" |
    |"TestNG"|
    
    
Scenario Outline: I want to remove a skill
   	Given I have <skill> as a skill
   	When I click on <skill> to remove from current skills
   	And I save the skills
   	Then I should see <skill> on the list of skills to choose from
   	Then I Log out
    And close the window

    Examples:
    |skill|
    |"Not William WebDriver"|
    |"Robin Script" |
    |"Manual Testing" |
    |"TestNG"|
	
  #Scenario Outline: I want to add a skill
    #Given I am logged on as a trainer
    #And I am on the profile page
    #When I click on <skill> to add to current skills
    #And I save the skills
    #Then 	I should see <skill> on my list of skills
    
    #Examples:
    #|skill|
    #|"Not William WebDriver"|
    #|"Robin Script" |
    #|"Manual Testing" |
    #|"TestNG"|
   
   #Scenario Outline: I want to remove a skill
   #	Given I am on the profile page
   #	When I click on <skill> to remove from current skills
   #	And I save the skills
   #	Then I should see <skill> on the list of skills to choose from
   	
   #	Examples:
    #|skill|
    #|"Not William WebDriver"|
    #|"Robin Script" |
    #|"Manual Testing" |
    #|"TestNG"|
   

      
