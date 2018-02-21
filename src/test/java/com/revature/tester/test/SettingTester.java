package com.revature.tester.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.SettingsPage;

public class SettingTester {											// TestNG Framework

	WebDriver wd = null;
	
	@BeforeSuite(groups = {"VP", "Trainer"})
	private void openBrowser() {									// don't need if we driver is already open
		System.out.println("BeforeSuite");
		wd = DriverFactory.getDriver("chrome");
	}

	@BeforeTest(groups = "VP")
	public void loginAsVP() {
		System.out.println("BeforeTest - VP");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
	}
	
	@BeforeTest(groups = "Trainer")
	public void loginAsTrainer() {
		System.out.println("BeforeTest - Trainer");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");
	}
	
	@BeforeMethod(enabled = true, groups = {"VP", "Trainer"})
	public void navigateToSettinsPage() {
		System.out.println("BeforeMethod");
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields
//		SettingsPage.navigateToSettingsPage(wd);
	}
	
	// -------- Group Test --------
	// EVERYTHING works perfect
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testSettingsPageAsVP() {
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields
		
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("20");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("20");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("20");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("20");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("20");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
//		SettingsPage.defaultBuilding(wd).sendKeys();		// Default Building field doesn't update until you save the default location AND refresh the page...
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("20");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("20");
		
		// ----- saving the changes -----
//		SettingsPage.findSaveButton(wd).click();			// only available as VP
	}
	
	@Test(enabled = true, groups = "Trainer", priority = 0)
	public void testSettingsPageAsTrainer() {
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields
		
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("30");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("30");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("30");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("30");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("30");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("30");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("30");
	}

	// -------- Individual Tests -------- 
	// 3 Tests Fail : timelineTrainersPerPageTest(), reportsOutgoingGradsTest(), reportsIncomingCandidatesTest()
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void timelineTrainersPerPageTest() {
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("10");
	}

	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void reportsOutgoingGradsTest() {
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("10");
	}

	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void reportsIncomingCandidatesTest() {
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("10");
	}
	
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void defaultBatchLengthTest() {
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("10");
	}
	
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void minBetweenTrainerBatchTest() {
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("10");
	}
	
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void defaultLocationTest() {
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
	}
	
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void minBatchSizeTest() {
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("10");
	}
	
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)
	public void maxBatchSizeTest() {
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("10");
	}
	
	@Test(enabled = false, groups = {"VP"}, priority = 1)								// have to enable
	public void saveButtonTest() {
		System.out.println("Save Button");
//		SettingsPage.findSaveButton(wd).click();
	}
	
	// FOUND BUG - Default Building field doesn't update until you save the default location AND refresh the page...
	@Test(enabled = false, groups = {"VP", "Trainer"}, priority = 1)					// have to enable
	public void defaultBuildingTest() {
		SettingsPage.defaultBuilding(wd).sendKeys();
	}
}
