package com.revature.tester;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Skill;
import com.revature.pageObjectModel.BatchPage;
import com.revature.pageObjectModel.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BatchTester {
	WebDriver wd;
	Properties props = new Properties();
	String err = " not input correctly";
	private Batch batch = null;
	String curriculum;
	String focus;
	Set<Skill> skills;
	String batchName;
	String trainerName;
	String location;
	String building;
	String room;

	public BatchTester(WebDriver wd2, Properties props2, Batch batch) {
		this.wd = wd2;
		this.props = props2;
		this.batch = batch;
		this.focus = batch.getFocus().getFocusName();
		this.curriculum = batch.getCurriculum().getCurriculumName();
	}

	public BatchTester() {
		this.focus = batch.getFocus().getFocusName();
		this.curriculum = batch.getCurriculum().getCurriculumName();
	}

	@BeforeSuite
	public void initWebDriver() {
		wd = DriverFactory.getDriver("chrome");
	}

	@Given("^I log in as VP$")
	@BeforeClass
	public void doLogin() {
		MethodUtil.loadPropertiesFile(props);
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("VPUsername"), props.getProperty("VPPassword"));
		// go to batches tab
		MethodUtil.waitForLoad(wd, "//a[@ng-href=\"batches\"]",20).click();
	}
	@Then("^I log out$")
	@AfterClass
	public void doLogout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // wait 2 seconds
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "(//button)[1]"));
		MethodUtil.waitAndCloseDriver(wd, Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	@When("^I fill in the curriculum for the batch$")
	@Test(groups = { "VP" }, priority = 1)
	public void fillCurriculum() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCurriculumSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCurriculumOption(wd, curriculum));
		assertTrue(BatchPage.getBatchCurriculumSelect(wd).getText().contains(curriculum),"Curriculum"+err);
	}
	@When("^I fill in focus for the batch$")
	@Test(enabled=true,groups = { "VP" }, priority = 2)
	public void fillFocus() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchFocusSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchFocusOption(wd, focus));
		assertTrue(BatchPage.getBatchFocusSelect(wd).getText().contains(focus),"Focus"+err);
	}
	@When("^I fill in skills for the batch$")
	@Test(enabled=true,groups = { "VP" }, priority = 3)
	public void fillSkills() {
		for (Skill s : skills) {
			MethodUtil.executeJSClick(wd, BatchPage.getBatchSkillsSelect(wd));
			MethodUtil.executeJSClick(wd, BatchPage.getBatchSkillsOption(wd, s.getSkillName()));
			assertTrue(BatchPage.getBatchSkillsSelect(wd).getText().contains(s.getSkillName()),"Skills"+err);
		}
			MethodUtil.executeJSClick(wd, wd.findElement(By.id("batchInfoDiv")));
	}
	@When("^I fill in the start date of the batch$")
	@Test(enabled=true,groups = { "VP" }, priority = 4)
	public void fillStartDate() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchStartDateInput(wd));
		BatchPage.getBatchStartDateInput(wd).clear();
		BatchPage.getBatchStartDateInput(wd).sendKeys(localData.start);
		assertEquals(BatchPage.getBatchStartDateInput(wd).getAttribute("value"),localData.start,"Start date"+err);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("^I fill in the end date of the batch$")
	@Test(enabled=true,groups = { "VP" }, priority = 5)
	public void fillEndDate() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchEndDateInput(wd));
		BatchPage.getBatchEndDateInput(wd).clear();
		BatchPage.getBatchEndDateInput(wd).sendKeys(localData.end);
		assertEquals(BatchPage.getBatchEndDateInput(wd).getAttribute("value"),localData.end,"End date"+err);
	}
	@Then("^I should see the correct weekspan$")
	@Test(enabled=true,groups = { "VP" }, priority = 6)
	public void showAccurateWeekspan() {
		assertEquals(BatchPage.getBatchWeekSpanInput(wd).getAttribute("value"),"Spans "+localData.weekspan+" Weeks","Weekspan"+err);
	}
	@When("^I fill in the batch name$")
	@Test(enabled=true,groups = { "VP" }, priority = 7)
	public void fillBatchName() {
		BatchPage.getBatchNameInput(wd).clear();
		BatchPage.getBatchNameInput(wd).sendKeys(batchName);
		assertTrue(BatchPage.getBatchNameInput(wd).getAttribute("value").contains(batchName),"Batch Name"+err);
	}
	@When("^I fill in the trainer for the batch$")
	@Test(enabled=true,groups = { "VP" }, priority = 8)
	public void fillTrainer() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchTrainerSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchTrainerOption(wd, trainerName));
		assertTrue(BatchPage.getBatchTrainerSelect(wd).getText().contains(trainerName),"Trainer"+err);
	}
	@When("^I fill in the co-trainer for the batch$")
	@Test(enabled=true,groups = { "VP" }, priority = 9)
	public void fillCoTrainer() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCoTrainerSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCoTrainerOption(wd, localData.cotrainer));
		assertTrue(BatchPage.getBatchCoTrainerSelect(wd).getText().contains(localData.cotrainer),"Co-trainer"+err);
	}
	@When("^I fill in location of the building$")
	@Test(enabled=true,groups = { "VP" }, priority = 10)
	public void fillLocation() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchLocationSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchLocationOption(wd, location));
		assertTrue(BatchPage.getBatchLocationSelect(wd).getText().contains(location),"Location"+err);
	}
	@When("^I fill in the building itself$")
	@Test(enabled=true,groups = { "VP" }, priority = 11)
	public void fillBuilding() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchBuildingSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchBuildingOption(wd, building));
		assertTrue(BatchPage.getBatchBuildingSelect(wd).getText().contains(building),"Building"+err);
	}
	@When("^I fill in the room number in the building$")
	@Test(enabled=true,groups = { "VP" }, priority = 12)
	public void fillRoom() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchRoomSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchRoomOption(wd, room));
		assertTrue(BatchPage.getBatchRoomSelect(wd).getText().contains(room),"Room"+err);
	}

	@When("^I click create batch")
	@Test(enabled=true,groups = { "VP" }, priority = 13)
	public void testVPCreateBatch() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// submit button/create new batch
		MethodUtil.executeJSClick(wd, BatchPage.getBatchSubmitBtn(wd));
	}
	@Test(enabled=true,groups = { "VP" }, priority = 14)
	public void testVPCancelBatchCreation() {
		fillCurriculum();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// hit button to cancel new batch creation
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCancelBtn(wd));
		assertFalse(BatchPage.getBatchCurriculumSelect(wd).getText().contains(curriculum),"Curriculum was not cleared when cancel button was clicked");
	}
	@Then("^I should get a response confirming a new batch was created$")
	@Test(enabled=true,groups = { "VP" }, priority = 15)
	public void testRefresh() {
		wd.get(props.getProperty("BatchesURL"));
		assertTrue(MethodUtil.waitForLoad(wd, "//div[@id=\"batchInfoDiv\"]").getText().contains("Create New Batch"),"Create new batch panel does not exist on refresh");
	}

	@Test(enabled=true, groups="Trainer", priority=16)
	public void testTableSort() {
		try { Thread.sleep(2500); } catch (InterruptedException e) { e.printStackTrace(); }
		for (int i=2;i<=10;i++) {// for each column...
			// Sort ascending
			MethodUtil.executeJSClick(wd, BatchPage.getColumnSortBtn(wd, i));
			// Sort descending
			MethodUtil.executeJSClick(wd, BatchPage.getColumnSortBtn(wd, i));
		}
	}
}

class localData {
	public static String curriculum = ".NET";
	public static String focus = "No Focus";
	public static String skills = "JSP";
	public static String start = "02/05/2018";
	public static String end = "04/13/2018";
	public static String weekspan = "10";
	public static String name = "TestBatch";
	public static String trainer = "Test Trainer";
	public static String cotrainer = "Testing Testing";
	public static String location = "New York City";
	public static String building = "CUNY QUEENS";
	public static String room = "1";
}
