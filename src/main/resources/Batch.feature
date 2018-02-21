
@tag
Feature: Traversing the batch page

Background: I login as VP
Given I log in as VP

  @VP
  Scenario: Create a batch
    #Given I have a list of batches I want to create
    When I fill in the curriculum for the batch
    And I fill in focus for the batch
    And I fill in skills for the batch
    And I fill in the start date of the batch
    And I fill in the end date of the batch
    And I fill in the batch name
    And I fill in the trainer for the batch
    And I fill in the co-trainer for the batch
    And I fill in location of the building
    And I fill in the building itself
    And I fill in the room number in the building
    And I click create batch
    Then I should get a response confirming a new batch was created
    And I should see the correct weekspan
    And I log out

  #@VP
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
