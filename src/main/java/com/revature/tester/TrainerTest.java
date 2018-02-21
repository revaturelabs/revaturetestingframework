package com.revature.tester;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Trainer;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.TrainerPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TrainerTest {
	public WebDriver wd;
	Properties props;
	com.revature.hibernate.model.Batch batch;
	Trainer t;
	
	public TrainerTest() {
		this.wd =  DriverFactory.getDriver("chrome");
		batch = AssignForce.getAllBatches().get(0);
		t = batch.getTrainer();
	}
	
	public TrainerTest(WebDriver wd, Properties props) {
		this.wd = wd;
		this.props = props;
	}
	
	public TrainerTest(WebDriver wd, Properties props, com.revature.hibernate.model.Batch b) {
		this.wd = wd;
		this.props = props;
		this.batch = b;
		t = batch.getTrainer();
	}

	/*
	 * Clicks on the trainer's download resume button based on the name.
	 */
	public void clickDownloadResumeByName(String firstname, String lastname) {
		TrainerPage.selectTrainerDownloadResumeButton(wd, firstname, lastname).click();
	}

	/*
	 * Clicks on the trainer's name to view his/her profile
	 */
	public void clickProfileByName(String firstname, String lastname) {
		TrainerPage.selectTrainerProfileButton(wd, firstname, lastname).click();
	}

	/*
	 * Clicks on the Calander's cancel button
	 */
	@When("^I click cancel on the Calendar$")
	public void clickCancelPTOCalendar() {
		MethodUtil.executeJSClick(wd, TrainerPage.selectCancelCalendar(wd));
	}

	/*
	 * Clicks save on the add trainer dialog
	 */
	@When("^I select save$")
	public void clickAcceptTrainerInput() {
//		TrainerPage.selectSaveNewTrainer(wd).click();
		MethodUtil.executeJSClick(wd, TrainerPage.selectSaveNewTrainer(wd));
	}

	/*
	 * Clicks cancel on the add trainer dialog
	 */
	@When("^I select cancel$")
	public void clickCancelTrainerInput() {
		MethodUtil.executeJSClick(wd, TrainerPage.selectCancelAddTrainer(wd));
		// TrainerPage.selectCancelAddTrainer(wd).click();
	}

	/*
	 * Clicks the View PTO Calendar button
	 */
	@Given("^I click on the View PTO Calendar button$")
	public void clickPTOCalendar() {
		TrainerPage.selectViewPTOCalendar(wd).click();
	}

	/*
	 * Clicks New PTO Request on the PTO Calendar
	 */
	@Given("^I click new PTO Request$")
	public void clickNewPTORequest() {
		MethodUtil.executeJSClick(wd, TrainerPage.selectAddPTORequest(wd));
	}

	/*
	 * Clicks cancel on the PTO Request dialog
	 */
	@When("^I click cancel PTO Request$")
	public void clickCancelPTORequest() {
		MethodUtil.executeJSClick(wd, TrainerPage.selectCancelPTORequest(wd));
	}

	/*
	 * Writes the trainer's full name into their respective inputs when adding a new trainer
	 */
	@When("^I insert <firstname> and <lastname> onto the firstname and lastname inputs$")
	public void writeTrainerFullName(String firstname, String lastname) {
		TrainerPage.insertTrainerFirstname(wd).sendKeys(firstname);
		holdOn(500);
		TrainerPage.insertTrainerLastname(wd).sendKeys(lastname);
	}

	/*
	 * Enters a start date and an end date on the PTO request dialog
	 */
	public void enterPTODate(String startDate, String endDate) {
		// TrainerPage.selectStartDateCalendarPopup(wd).click();
		// TrainerPage.insertPTOStartDate(wd).click();
		// TrainerPage.insertPTOStartDate(wd).click();
		// TrainerPage.insertPTOStartDate(wd).click();
		TrainerPage.insertPTOStartDate(wd).click();
		holdOn(500);
		MethodUtil.executeJSClick(wd, TrainerPage.insertPTOStartDate(wd));
		TrainerPage.insertPTOStartDate(wd).sendKeys(startDate);
		// TrainerPage.selectEndDateCalendarPopup(wd).click();
		holdOn(500);
		TrainerPage.insertPTOEndDate(wd).click();
		MethodUtil.executeJSClick(wd, TrainerPage.insertPTOEndDate(wd));
		TrainerPage.insertPTOEndDate(wd).sendKeys(endDate);
	}

	/*
	 * Clicks on the calendar week view tab
	 */
	public void clickCalendarWeekView() {
		TrainerPage.selectCalendarWeekView(wd).click();
	}

	/*
	 * Clicks on the calendar month view tab
	 */
	public void clickCalendarMonthView() {
		TrainerPage.selectCalendarMonthView(wd).click();
	}

	/*
	 * Clicks on the calendar agenda view tab
	 */
	public void clickCalendarAgendaView() {
		TrainerPage.selectCalendarAgendaView(wd).click();
	}

	/*
	 * Clicks on the calendar week view tab
	 */
	public void clickCalendarBack() {
		TrainerPage.selectMoveBackInCalendar(wd).click();
	}

	/*
	 * Clicks forward on the calendar
	 */
	public void clickCalendarForward() {
		TrainerPage.selectMoveForwardInCalendar(wd).click();
	}

	/*
	 * Clicks today on the calendar
	 */
	public void clickCalendarToday() {
		TrainerPage.selectTodayOnCalendar(wd);
	}

	/*
	 * Clicks the add trainer button
	 */
	@Given("^I click add trainer$")
	public void clickAddTrainer() {
//		TrainerPage.selectAddTrainer(wd).click();
		MethodUtil.executeJSClick(wd, TrainerPage.selectAddTrainer(wd));
	}

	/*
	 * Clicks on the trainer tab to navigate to the trainer page
	 */
	@Given("^I click on the trainers tab$")
	@Test(groups = { "VP", "Trainer" })
	public void clickTrainersTab() {
		TrainerPage.selectTrainersTab(wd);
	}

	/*
	 * Clicks save trainer on the add trainer dialog
	 */
	@Test(groups = { "VP" }, priority = 1, enabled = true)
	public void addTrainerSave() {
		clickAddTrainer();
		writeTrainerFullName("Damon", "Salvatore");
		clickAcceptTrainerInput();
	}

	/*
	 * Clicks cancel on the add trainer dialog
	 */
	@Test(groups = { "VP" }, priority = 2, enabled = false)
	public void addTrainerCancel() {
		clickAddTrainer();
		writeTrainerFullName("Testing1r", "Testing2p");
		holdOn(500);
		clickCancelTrainerInput();
	}

	/*
	 * Tests the PTO calendar functionality
	 */
	@Test(groups = { "VP", "Trainer" }, priority = 4, enabled = true)
	public void checkPTOCalendar() {
		holdOn(3000);
		clickPTOCalendar();
		holdOn(1000);
		clickNewPTORequest();
		holdOn(1000);
//		enterPTODate("1/1/2018", "1/2/2017");
		holdOn(1000);
		clickCancelPTORequest();
		holdOn(1000);
		clickCancelPTOCalendar();
	}

	/*
	 * Tests clicking a profile based on the specific name
	 */
	@Test(groups = { "VP", "Trainer" }, priority = 3, enabled = true)
	public void clickProfile() {
		clickProfileByName("Test7", "Test8");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.navigate().back();
	}

	/*
	 * 
	 */
	@Test(groups = { "VP" }, priority = 5, enabled = true)
	public void clickDeactivateTrainerByName() {
		MethodUtil.executeJSClick(wd, TrainerPage.selectTrainerDeactivateButton(wd, "Damon", "Salvatore"));
	}

	@Test(groups = { "VP" }, priority = 6, enabled = true)
	public void clickReactivateTrainerByName() {
		TrainerPage.selectTrainerReactivateButton(wd, "Damon", "Salvatore").click();
	}

	@Test(groups = { "VP" }, priority = 5, enabled = false)
	public void clickDeactivateTrainer() {
		List<WebElement> deactivatedtrainers = TrainerPage.selectDeactivatedTrainersList(wd);
		for (WebElement de : deactivatedtrainers)
			System.out.println(de.getText());
		for (int i = 0; i < 5; i++)
			TrainerPage.selectDeactivateTrainer(wd).click();
	}

	@Test(groups = { "VP" }, priority = 6, enabled = false)
	public void clickReactivateTrainer() {
		for (int i = 0; i < 5; i++)
			TrainerPage.selectReactivateTrainer(wd).click();
	}

	@When("^I click on the Download Resume button$")
	@Test(groups = { "VP", "Trainer" }, priority = 7)
	public void clickDownloadResume() {
		// TrainerPage.selectDownloadResume(wd).click();
		MethodUtil.executeJSClick(wd, TrainerPage.selectDownloadResume(wd));
	}

	@BeforeMethod(groups = { "VP", "trainer" })
	public void holdOn() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void holdOn(int number) {
		try {
			Thread.sleep(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("^I am on the trainers page$")
	@AfterMethod
	public void afterMethod() {
		TrainerPage.selectTrainersTab(wd);
	}

	@Given("^I login as VP$")
	@BeforeClass(groups = { "VP" })
	public void signInAsVP() {
		LoginPage.getUsernameInput(wd).sendKeys("test.vpoftech@revature.com.int1");
		LoginPage.getPasswordInput(wd).sendKeys("yuvi1712");
		LoginPage.getLoginBtn(wd).submit();
		TrainerPage.selectTrainersTab(wd).click();
	}

	@BeforeClass(groups = { "Trainer" })
	public void signInAsTrainer() {
		LoginPage.getUsernameInput(wd).sendKeys("test.trainer@revature.com.int1");
		LoginPage.getPasswordInput(wd).sendKeys("trainer123");
		LoginPage.getLoginBtn(wd).submit();
		TrainerPage.selectTrainersTab(wd).click();
	}

	@AfterClass(groups = { "VP", "Trainer" })
	public void afterClass() {
		MethodUtil.executeJSClick(wd, LoginPage.getLogout(wd));
		MethodUtil.waitAndCloseDriver(wd, 1000);
		wd.quit();
	}

	@BeforeTest(groups = { "VP", "Trainer" })
	public void beforeTest() {
		LoginPage.goToAssignForce(wd);
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
