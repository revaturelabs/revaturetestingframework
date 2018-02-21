Feature: Reports Page/Tab

  @VP
  Scenario: Testing the Reports Page as the VP
  	Given I am logged in as the VP
  	When I test the Batch Projection Section
  	And add a new card
  	And delete the existing card
  	And test the Outgoing Graduates Section
  	And test the Incoming Candidates Section
  	Then I should log out of the Reports Page

  @Trainer
  Scenario: Testing the Reports Page as the Trainer
  	Given I am logged in as the Trainer
  	When I test the Batch Projection Section
  	And add a new card
  	And delete the existing card
  	And test the Outgoing Graduates Section
  	And test the Incoming Candidates Section
  	Then I should log out of the Reports Page