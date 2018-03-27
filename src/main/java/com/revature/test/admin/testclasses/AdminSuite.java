package com.revature.test.admin.testclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.revature.test.admin.pom.Login;
import com.revature.test.admin.pom.Logout;
import com.revature.test.utils.JanusUtil;
import com.revature.test.utils.LoginUtil;
import com.revature.test.utils.TestConfig;
import com.revature.test.utils.WebDriverUtil;

//import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@CucumberOptions(features="src/test/resources/AdminFeatureFiles")
public class AdminSuite extends AbstractTestNGCucumberTests{
	
	public WebDriver wd = null;
	private String baseURL = TestConfig.getBaseURL(); //gets the website URL
	public static Alert alert = null; //creates object to interact with alerts in order to cancel pop ups
	public static Actions action = null;
	
	@BeforeSuite
	public void beforeSuite() {
		wd = new WebDriverUtil().getChromeDriver();
		System.out.println("================== TRACKFORCE TESTS ==================");
		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Logging In");
		try {
			Thread.sleep(500);
			wd.get(baseURL);
			JanusUtil.clickTrackForce(wd);
			Thread.sleep(5000);
			LoginUtil.loginAsAdmin(wd);
			alert = wd.switchTo().alert(); //initialize
			action = new Actions(wd);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Logging out");
		if (Logout.logout(wd) != null) {
		Logout.logout(wd).click();
		wd.quit();
		}
	}
}
