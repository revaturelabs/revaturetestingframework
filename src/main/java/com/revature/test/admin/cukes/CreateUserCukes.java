package com.revature.test.admin.cukes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.revature.test.admin.pom.CreateUserTab;
import com.revature.test.admin.pom.HomeTab;
import com.revature.test.admin.pom.Janus;
import com.revature.test.admin.pom.Logout;
import com.revature.test.admin.testclasses.AdminSuite;
import com.revature.test.utils.TestConfig;

public class CreateUserCukes extends AdminSuite {
	static WebElement e = null;

	//usernames for user creation are defined in ClientListTest
	private static String pass = "12345"; //all accounts are created with the same password
	
	@Given("^We click on Logout Tab$")
	public static boolean clickLogout(WebDriver d) {
		try {
			Thread.sleep(1500);
			Logout.logoutCU(d);
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click TrackForce Tab");
			return false;
		}
	}

	@Given("^Janus page is load$")
	public static boolean loadedJanusPage(WebDriver d) {
		try {
			Thread.sleep(500);
			if (CreateUserTab.getCurrentURL(d).equals(TestConfig.getBaseURL() + "/#/dashboard") || 
					CreateUserTab.getCurrentURL(d).equals(TestConfig.getBaseURL() + "/dashboard")) {
				return true;
			}
			System.out.println("Current URL does not end with /dashboard");
			return false;
		} catch (Throwable e) {
			System.out.println("Failed to get current URL");
			return false;
		}
	}
	
	@Given("^We click on TrackForce Tab$")
	public static boolean clickTrackForce(WebDriver d) {
		try {
			Thread.sleep(1500);
			Janus.getTrackForce(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click TrackForce Tab");
			return false;
		}
	}
	
	@Given("^Login page is load$")
	public static boolean loadedLoginPage(WebDriver d) {
		try {
			Thread.sleep(500);
			if (CreateUserTab.getCurrentURL(d).equals(TestConfig.getBaseURL() + "/#/TrackForce/login")) {
				return true;
			}
			System.out.println("Current URL does not end with /login");
			return false;
		} catch (Throwable e) {
			System.out.println("Failed to get current URL");
			return false;
		}
	}
	
	@Given("^We click on Create User Tab$")
	public static boolean clickCreateUserTab(WebDriver d) {
		try {
			Thread.sleep(1500);
			CreateUserTab.getCreateUserTab(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click Create User Tab");
			return false;
		}
	}

	@Given("^Create User Tab loads$")
	public static boolean loadedCreateUserTab(WebDriver d) {
		try {
			Thread.sleep(500);
			if (CreateUserTab.getCurrentURL(d).equals(TestConfig.getBaseURL() + "/#/TrackForce/create-user")) {
				return true;
			}
			System.out.println("Current URL does not end with /create-user");
			return false;
		} catch (Throwable e) {
			System.out.println("Failed to get current URL");
			return false;
		}
	}

	@When("^I type in a username$")
	public static boolean inputUsername(WebDriver d, String username) {
		try {
			Thread.sleep(250);
			CreateUserTab.getUsername(d).clear();
			CreateUserTab.getUsername(d).sendKeys(username);
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to input username");
			return false;
		}
	}

	@When("^I type in a password$")
	public static boolean inputPassword(WebDriver d, String password) {
		try {
			Thread.sleep(250);
			CreateUserTab.getPassword(d).clear();
			CreateUserTab.getPassword(d).sendKeys(password);
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to input password");
			return false;
		}
	}

	@When("^I confirm the password$")
	public static boolean inputPasswordConfirm(WebDriver d, String password) {
		try {
			Thread.sleep(250);
			CreateUserTab.getPasswordConfirm(d).clear();
			CreateUserTab.getPasswordConfirm(d).sendKeys(password);
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to confirm input password");
			return false;
		}
	}

	@When("^I check the Administrator role$")
	public static boolean clickAdminRadio(WebDriver d) {
		try {
			Thread.sleep(250);
			CreateUserTab.getAdminRadio(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click Admin radio button");
			return false;
		}
	}

	@When("^I check the Manager role$")
	public static boolean clickManagerRadio(WebDriver d) {
		try {
			Thread.sleep(250);
			CreateUserTab.getManagerRadio(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click Manager radio button");
			return false;
		}
	}

	@When("^I check the VP role$")
	public static boolean clickVPRadio(WebDriver d) {
		try {
			Thread.sleep(250);
			CreateUserTab.getVPRadio(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click VP radio button");
			return false;
		}
	}

	/*@When("^I check the VP role$")
	public static boolean clickAssociateRadio(WebDriver d) {
		try {
			Thread.sleep(250);
			CreateUserTab.getAssociateRadio(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click Associate radio button");
			return false;
		}
	}*/

	@Then("^I press submit$")
	public static boolean submitForm(WebDriver d) {
		try {
			Thread.sleep(250);
			CreateUserTab.getSubmit(d).click();
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click submit");
			return false;
		}
	}

	@Then("^Cancel the Error pop up if creating the user failed$")
	public static boolean cancelAlert(WebDriver d) {
		try {
			Thread.sleep(500);
			/*HomeTab.phone(d); //attempt to find the phone link to see if submit was successful and we are on home tab
			System.out.println("No alert detected; new user creation was successful");*/
			
			alert = d.switchTo().alert(); //initialize
			alert.dismiss();
			action.sendKeys(Keys.ESCAPE).perform();
			action.sendKeys(Keys.ESCAPE);

			return true; //element click successful; no alert popped up */		
		
					
		} catch (Throwable e) {
			
			return false;
			
		}
	}
}
