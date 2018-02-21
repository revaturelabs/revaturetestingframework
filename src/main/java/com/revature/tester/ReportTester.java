package com.revature.tester;

import org.openqa.selenium.By;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ReportsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportTester {

	WebDriver wd = null;
	Properties props;

	public ReportTester(WebDriver wd2, Properties props2) {
		this.wd = wd2;
		this.props = props2;
	}

	public ReportTester() {}

	WebDriverWait wait = null;
	Actions act = null;

	@Given("^I am logged in as the VP$")
	@BeforeGroups(enabled = true, groups = "VP")
	public void loginAsVP() throws Throwable {

		// Logging In The VP
		System.out.println("Login As VP");
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

		// need these for explicit waits won't work
		WebDriverWait wait = new WebDriverWait(wd, 5);
		Actions act = new Actions(wd);

		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();
	}

	@Given("^I am logged in as the Trainer$")
	@BeforeGroups(enabled = true, groups = "Trainer")
	public void loginAsTrainer() throws Throwable {

		// Logging In The Trainer
		System.out.println("Login As Trainer");
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");

		// need these for explicit waits won't work
		wait = new WebDriverWait(wd, 5);
		act = new Actions(wd);

		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();
	}

	@Then("^I should log out of the Reports Page$")
	@AfterGroups(enabled = true, groups = {"VP", "Trainer"})
	public void logout() throws Throwable {
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.logout(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}

	@When("^test the Outgoing Graduates Section$")
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void reportsTestGraduateSummary() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gradArrow")));
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.gradArrowButton(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.exportToCSV1(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.gradToolbar(wd).click();
	}

	@When("^test the Incoming Candidates Section$")
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void reportsTestIncomingTraineeSummary() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"view\"]/md-card/md-card[3]/get-train-table-toolbar/md-toolbar")));
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.incomingTraineeToolbar(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.exportToCSV2(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.incArrowButton(wd).click();
	}

	@When("^I test the Batch Projection Section$")
	@Test(enabled = true, groups = {"VP"}, priority = 1)
	public void reportsTestTheCardInBatchProjection() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view\"]/md-card/md-card[1]/get-batch-gen-table-toolbar/md-toolbar")));
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.batchProjectionToolbar(wd).click();
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.cardTrainersNeeded(wd).sendKeys("5");
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.cardHireDate(wd).sendKeys("3/1");
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.cardCurriculum(wd).sendKeys("TEST");
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		act.moveToElement(ReportsPage.cardCreateButton(wd)).click().build().perform();
	}

	@When("^add a new card$")
	@Test(enabled = true, groups = {"VP"}, priority = 2)
	public void reportsAddNewCard() throws Throwable {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.addNewCardButton(wd).click();
	}

	@When("^delete the existing card$")
	@Test(enabled = true, groups = {"VP"}, priority = 3)
	public void reportsDeleteCard() throws Throwable {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.cardDeleteButton(wd).click();
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.batchArrowButton(wd).click();
	}
}
