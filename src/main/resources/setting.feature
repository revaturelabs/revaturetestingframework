Feature: Testing the Settings Page

@VP
Scenario: Testing the Settings Page as the VP
  Given I am in the Settings Page/Tab and logged in as the VP
	When I change the timelineTrainersPerPage field
	And I change the reportsOutgoingGrads field
	And I change the reportsIncomingCandidates field
	And I change the deafultLocation field
	And I change the minimumBatchSize field
	And I change the maximumBatchSize field
	And I change the defaultBatchLength field
	And I change the daysBetweenTrainerBatches field
	And I save the changes
	Then I should check if the defaultLocation changed in the Batches Page
	And I should check if the defaultBuilding changed in the Batches Page
	And I should check if the trainers per page changed in the Batches Page
	And I should log out

@Trainer
Scenario: Testing the Settings Page as the Trainer
	Given I am in the Settings Page/Tab and logged in as the Trainer
	When I change the fields in the settings page
	Then I should log out
