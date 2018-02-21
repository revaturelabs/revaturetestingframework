package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.OverviewPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverviewTester {
	WebDriver wd = null;
	Properties props = new Properties();

	public OverviewTester(WebDriver wd2, Properties props2) {
		this.wd = wd2;
		this.props = props2;
	}

	public OverviewTester() {}

	@BeforeSuite
	public void initWebDriver() {
		wd = DriverFactory.getDriver("chrome");
	}

	@Given("^I am on the home page$")
	@BeforeClass
	public void doLogin() {
		MethodUtil.loadPropertiesFile(props);
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("TrainerUsername"), props.getProperty("TrainerPassword"));
	}

	@Then("^I should see the download and logout$")
	@AfterClass
	public void doLogout() {
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "(//button)[1]"));
	}

	@AfterSuite
	public void closeDriver() {
		MethodUtil.waitAndCloseDriver(wd,Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}

	@When("^I click on Download CSV$")
	@Test(groups= {"VP","Trainer"},priority=1)
	public void testCSVDownload() {
		// navigate to correct page
		wd.get("https://dev.assignforce.revaturelabs.com/home");
		// download csv file
		OverviewPage.getExportToCSVBtn(wd).click();
	}

	@Test(groups= {"VP","Trainer"},priority=2)
	public void testFilter() {
		for (int i=1;i<=3;i++) {
			// click filter button
			MethodUtil.executeJSClick(wd, OverviewPage.getFilterBtn(wd));
			// click each filter option button
			MethodUtil.executeJSClick(wd, OverviewPage.getFilterDropdownBtn(wd, 1));
		}
	}

	@Test(groups= {"VP","Trainer"},priority=3)
	public void testTableSort() {
		for (int i=1;i<=8;i++) {// for each column...
			// Sort ascending
			MethodUtil.executeJSClick(wd, OverviewPage.getColumnSortBtn(wd, i));
			// Sort descending
			MethodUtil.executeJSClick(wd, OverviewPage.getColumnSortBtn(wd, i));
		}
	}
}
