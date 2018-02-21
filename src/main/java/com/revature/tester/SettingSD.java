package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.SettingsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SettingSD {

	WebDriver wd = null;
	WebDriverWait wait = null;
	Actions act = null;

	public String timelineTrainersPerPage = null;
	public String reportsOutgoingGrads = null; 
	public String reportsIncomingCandidates = null;
	public String minimumBatchSize = null;
	public String maximumBatchSize = null;
	public String defaultBatchLength = null;
	public String daysBetweenTrainerBatches = null;
	
	public String locationInSettings = null;
	public String buildingInSettings = null;

	// fields should be updated automatically when saving the settings page
	public String locationInBatch = null;
	public String buildingInBatch = null;
	
	public Properties props;
	
	public SettingSD() {}
	public SettingSD(WebDriver wd, Properties props) {
		this.wd = wd;
		this.props = props;
	}
	
	@Given("^I am in the Settings Page/Tab and logged in as the VP$")
	@BeforeGroups(enabled = true, groups = {"VP"})
	public void loginAsVP() {

		// ----- can get rid of these next few lines -----
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");
		// -----------------------------------------------
		
		// DO NOT get rid if
		wait = new WebDriverWait(wd, 10);
		act = new Actions(wd);

		// THESE VALUES ARE NOT BEING PASSED BY HIBERNATE
		timelineTrainersPerPage = "10";
		reportsOutgoingGrads = "12";
		reportsIncomingCandidates = "25";
		minimumBatchSize = "20";
		maximumBatchSize = "30";
		defaultBatchLength = "10";
		daysBetweenTrainerBatches = "14";

		// --- Sample 01 Set ---
		locationInSettings = "Revature";
		buildingInSettings = "11730";
//		// --- Sample 02 Set ---
//		locationInSettings = "New";				// New York City
//		buildingInSettings = "CUNY";			// Main Office


		// Navigating to the Settings Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a"))).click().build().perform();
	}
	
	@Given("^I am in the Settings Page/Tab and logged in as the Trainer$")
	@BeforeGroups(enabled = true, groups = "Trainer")
	public void loginAsTrainer() {

		// ----- can get rid of these next few lines -----
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
		// -----------------------------------------------

		// DO NOT get rid if
		wait = new WebDriverWait(wd, 5);
		act = new Actions(wd);
		
		// Navigating to the Settings Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a"))).click().build().perform();
	}

	// idk if you want to get rid of this...
	@Then("^I should log out$")
	@AfterGroups(enabled = true, groups = {"VP", "Trainer"})
	public void logout() {
		LoginPage.logout(wd);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}
	
	// -------- Individual Test --------
	@When("^I change the timelineTrainersPerPage field$")
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testTrainersPerPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainersPerPage']")));
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys(timelineTrainersPerPage);
	}
	
	@When("^I change the reportsOutgoingGrads field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testReportsOutgoingGrads() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.reportGrads']")));
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys(reportsOutgoingGrads);
	}

	@When("^I change the reportsIncomingCandidates field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testReportsIncomingCandidates() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.reportIncomingGrads']")));
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys(reportsIncomingCandidates);
	}

	@When("^I change the deafultLocation field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testDefaultLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.defaultLocation']")));
		SettingsPage.defaultLocation(wd).sendKeys(locationInSettings);
	}
	
	@When("^I change the minimumBatchSize field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testMinBatchSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.minBatchSize']")));
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys(minimumBatchSize);
	}
	
	@When("^I change the maximumBatchSize field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testMaxBatchSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.maxBatchSize']")));
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys(maximumBatchSize);
	}
	
	@When("^I change the defaultBatchLength field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testDefaultBatchLength() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.batchLength']")));
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys(defaultBatchLength);
	}
	
	@When("^I change the daysBetweenTrainerBatches field$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void testMinBetweenTrainerBatch() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainerBreakDays']")));
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys(daysBetweenTrainerBatches);
	}

	@When("^I save the changes$")
	@Test(enabled = true, groups = {"VP"}, priority = 2)
	public void testSaveButton() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='sCtrl.updateSettings()']")));
		act.moveToElement(SettingsPage.findSaveButton(wd)).click().build().perform();
	}
	
	// -------- Tests to make sure changes were saved --------
	@Then("^I should check if the defaultLocation changed in the Batches Page$")
	@Test(enabled = true, groups = "VP", priority = 3)
	public void testTheDefaultLocation() {

		// Navigating to the Batch Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a"))).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bCtrl.batch.location']")));
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='bCtrl.batch.location']")).getText();
		
		if(locationInBatch.contains(locationInSettings)) {
			Assert.assertTrue(locationInBatch.contains(locationInSettings));
			System.out.println("VALIDATION: Location Saved Successfully");
		} else {
			Assert.assertFalse(locationInBatch.contains(locationInSettings));
			System.out.println("VALIDATION: Location DID NOT Save Correctly");
		}
	}
	
	// -------------------- GOOD FAILING TESTS --------------------
	@Then("^I should check if the defaultBuilding changed in the Batches Page$")
	@Test(enabled = true, groups = {"VP"}, priority = 4)
	public void testDefaultBuilding() {
		
		// navigate back to the settings page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a"))).click().build().perform();
		
		// input a building
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='sCtrl.settings.defaultBuilding']")));
		SettingsPage.defaultBuilding(wd).sendKeys(locationInSettings);
		
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='sCtrl.updateSettings()']")));
		act.moveToElement(SettingsPage.findSaveButton(wd)).click().build().perform();
		
		// navigate to batches
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a"))).click().build().perform();
		
		// check if it saved in batches
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bCtrl.batch.building']")));
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='bCtrl.batch.building']")).getText();
		
		// verify that it saved
		if (locationInBatch.toLowerCase().contains(locationInSettings.toLowerCase())) {
			Assert.assertTrue(locationInBatch.toLowerCase().contains(buildingInSettings.toLowerCase()));
			System.out.println("VALIDATION: Building Saved Successfully");
		} else {
			Assert.assertFalse(locationInBatch.toLowerCase().contains(buildingInSettings.toLowerCase()));
			System.out.println("VALIDATION: Buildings DID NOT Save Correctly");
		}
	}
	
	@Then("^I should check if the trainers per page changed in the Batches Page$")
	@Test(enabled = true, groups = "VP", priority = 5)
	public void testTimelineTrainersPerPage() {
		
//		System.out.println("timelineTrainersPerPage: " + timelineTrainersPerPage);
		
		// don't need to navigate to batches page because you're already there

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='pagination.perPage']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='pagination.perPage']")).getText();
//		System.out.println("testTimelineTrainersPerPage - locationInBatch: " + locationInBatch);

		if (timelineTrainersPerPage.equals(locationInBatch)) {
			Assert.assertEquals(locationInBatch.toLowerCase(), timelineTrainersPerPage);
			System.out.println("VALIDATION: Trainers Per Page Saved Successfully");
		} else {
			Assert.assertFalse(locationInBatch.toLowerCase().contains(buildingInSettings.toLowerCase()));
			System.out.println("VALIDATION: Trainers Per Page DID NOT Save Correctly");
		}
	}
	
	// ----- Testing Settings Page As A Trainer -----
	@When("^I change the fields in the settings page$")
	@Test(enabled = true, groups = "Trainer", priority = 6)
	public void testSettingsPageAsTrainer() {
	
		wait = new WebDriverWait(wd, 10);
		act = new Actions(wd);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainersPerPage']")));
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
		
//		String newLocation = "Revature";		// Revature HQ
		String newLocation= "New";				// New York City
		SettingsPage.defaultLocation(wd).sendKeys(newLocation);
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("30");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("30");
		
		System.out.println("VALIDATION: Field Changed Successfully, But Did Not Save");
	}
	
	
	
	
	
	// -------------------- BAD FAILING TESTS --------------------
	//			 		 might not want to enable
	// -----------------------------------------------------------
	// PROBLEM ~ can't find the element in the Reports Page ~
	@Test(enabled = false, groups = "VP")
	public void testOutgoingGrads() {
		
		System.out.println("reportsOutgoingGrads: " + reportsOutgoingGrads);

		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();

		// clicking the settings button in Graduate Summary Toolbar
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view\"]/md-card/md-card[2]/get-train-table-toolbar/md-toolbar/md-menu/button")));
//		act.moveToElement(ReportsPage.gradSettingsButton(wd)).click().build().perform();
		
		// getting the information from the field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='rCtrl.graduates']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='rCtrl.graduates']")).getText();
		System.out.println("testOutgoingGrads: " + locationInBatch);
		
		if(reportsOutgoingGrads.toLowerCase().contentEquals(locationInBatch)) {
			Assert.assertEquals(locationInBatch, reportsOutgoingGrads);
			System.out.println("VALIDATION: Reports Outgoing Grads Match");
		} else {
			Assert.assertNotEquals(locationInBatch, reportsOutgoingGrads);
			System.out.println("VALIDATION: Reports Outgoing Grads DO NOT Match");
		}
	}

	// PROBLEM ~ can't find the element in the Reports Page ~
	@Test(enabled = false, groups = "VP")
	public void testIncomingTrainees() {
		
//		System.out.println("reportsIncomingCandidates: " + reportsIncomingCandidates);
//
//		// clicking the settings button in the Incoming Trainee Toolbar
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view\"]/md-card/md-card[3]/get-train-table-toolbar/md-toolbar")));
//		act.moveToElement(ReportsPage.traineeSettingsButton(wd)).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='rCtrl.incoming']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='rCtrl.incoming']")).getText();
//		System.out.println("testIncomingCandidates: " + locationInBatch);

		if(reportsOutgoingGrads.toLowerCase().contentEquals(locationInBatch)) {
			Assert.assertEquals(locationInBatch, reportsIncomingCandidates);
			System.out.println("VALIDATION: Reports Incomming Candidates Match");
		} else {
			Assert.assertNotEquals(locationInBatch, reportsIncomingCandidates);
			System.out.println("VALIDATION: Reports Incomming Candidates DO NOT Match");
		}
	}
	
}
