#Author: robin.pierre16@outlook.com
#Keywords Summary : Overview Page Traversal
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
Feature: Traverse the Overview Page
 
 Background: I log in
 And I am on the home page
 
 Scenario: I want to download a CSV file
 When I click on Download CSV
 Then I should see the download and logout

  