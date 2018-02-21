#Author: robin.pierre16@outlook.com
#Keywords Summary : feature file for the trainer page on assignforce
Feature: I want to navigate throughout the trainer page

  #Background: I want to look up information on AssignForce trainer page
    #Given I open a browser to go to AssignForce
    #And I login as VP
    #And I click on the trainers tab
#
  #@VP
  Scenario: As a VP, I want to add a trainer
    #Given I click add trainer
    When I insert <firstname> and <lastname> onto the firstname and lastname inputs
    #And I select save
    Then I should see <firstname> <lastname> on the list of trainers in the deactivated list
    

  #@VP
  #Scenario: As a VP, I want to cancel adding a trainer
    #Given I click add trainer
    #When I insert <firstname> and<lastname> onto the firstname and lastname inputs
    #And I select cancel
    #Then I should not see <firstname> <lastname> on the list of trainers in the deactivated list
#
  #@VP
  #Scenario: As a VP, I want to give paid time off
    #Given I click on the View PTO Calendar button
    #And I click new PTO Request
    #When I insert <startdate> into startdate and <enddate> into enddate
    #But I click cancel PTO Request
    #And I click cancel on the Calendar
#
  #@VP
  #Scenario: As A VP, I want to download a resume
    #Given I am on the trainers page
    #When I click on the Download Resume button
    #Then I should get the downloaded resume
