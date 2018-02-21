package com.revature.tester;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/resources/trainerVP.feature")
public class TrainerTester extends AbstractTestNGCucumberTests {

//	//WebDriver wd = DriverFactory.getDriver("chrome");
//	TrainerTest trainerTest = new TrainerTest();
//
//	// This is cucumber code from test. Should be here and not
//	@Given("^I want to go to the \"([^\"]*)\"$")
//	public void i_want_to_go_to_the(String arg1) {
//		trainerTest.beforeTest();
//	}
//
//	@Given("^I login as \"([^\"]*)\" with a valid \"([^\"]*)\"$")
//	public void i_login_as_with_a_valid(String arg1, String arg2) {
//
//		trainerTest.signInAsVP();
//	}
//
//	@When("^I login, I click on the trainers tab$")
//	public void i_login_I_click_on_the_trainers_tab() {
//		trainerTest.clickTrainersTab();
//	}
//
//	@Then("^I click on the add trainer button$")
//	public void i_click_on_the_add_trainer_button() {
//		// TrainerPage.selectAddTrainer(trainerTest.wd).click();
//		trainerTest.clickAddTrainer();
//	}
//
//	@Then("^I input \"([^\"]*)\" and \"([^\"]*)\" of the trainer$")
//	public void i_input_and_of_the_trainer(String arg1, String arg2) {
//		trainerTest.writeTrainerFullName(arg1, arg2);
//	}
//
//	@Then("^I click save$")
//	public void i_click_save() {
//		trainerTest.clickAcceptTrainerInput();
//	}
//
//	@Given("^I am on the trainers page$")
//	public void i_am_on_the_trainers_page() throws Throwable {
//		trainerTest.clickAddTrainer();
//	}
//
//	@When("^I click on the View PTO Calendar button$")
//	public void i_click_on_the_View_PTO_Calendar_button() throws Throwable {
//		trainerTest.clickPTOCalendar();
//	}
//
//	@Then("^I click new PTO Request$")
//	public void i_click_new_PTO_Request() throws Throwable {
//		trainerTest.clickNewPTORequest();
//	}
//
//	@Then("^I click cancel PTO Request$")
//	public void i_click_cancel() throws Throwable {
//		trainerTest.clickCancelPTORequest();
//	}
//
//	@Then("^I click cancel on the Calendar$")
//	public void i_click_cancel_on_the_Calendar() throws Throwable {
//		trainerTest.clickCancelPTOCalendar();
//	}
//
//	@When("^I click on the Download Resume button$")
//	public void i_click_on_the_Download_Resume_button() throws Throwable {
//		trainerTest.clickDownloadResume();
//	}
//
//	@Then("^I should get the downloaded resume$")
//	public void i_should_get_the_downloaded_resume() throws Throwable {
//		//DO NOTHINGS
//	}

}
