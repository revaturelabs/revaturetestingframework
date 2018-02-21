package com.revature.test.admin.cukes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.revature.test.admin.pom.AssociateListTab;
import com.revature.test.admin.pom.HomeTab;
import com.revature.test.admin.pom.Predictions;
import com.revature.test.admin.testclasses.AdminSuite;
import com.revature.test.utils.TestConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PredictionsCukes extends AdminSuite {
	
	
	@Given("^I am on the Predictions page$")
	public static boolean i_am_on_the_Predictions_page(WebDriver d) throws Throwable {
		
		try {
			Thread.sleep(1500);
			// Click on the Predictions Tab
			Predictions.clickPredictionsTab(wd).click();
			return true;

		} catch (Throwable e) {
			System.out.println(("Failed click on the Predictions Tab"));
			return false;
		}
	    
	}

	@Given("^Predictions Tab loads$")
	public static boolean predictions_tab_loads(WebDriver d) {
		try {
			Thread.sleep(500);
			if (Predictions.getCurrentURL(d).equals(TestConfig.getBaseURL() + "/predictions")) {
				return true;
			}
			System.out.println("Current URL does not end with /predictions");
			return false;
		} catch (Throwable e) {
			System.out.println("Failed to get current URL");
			return false;
		}
	}
	
	@When("^I input a start date$")
	public static boolean i_input_a_start_date(WebDriver d) throws Throwable {
		
		try {
			Thread.sleep(500);
			Predictions.startDate(wd).sendKeys("02/26/2018");
			return true;

		} catch (Throwable e) {
			System.out.println(("Failed to input a start date"));
			return false;
		}
	    
	}

	@When("^I input a end date$")
	public static boolean i_input_a_end_date(WebDriver d) throws Throwable {
		
		try {
			Thread.sleep(500);
			Predictions.endDate(wd).sendKeys("09/13/2018");
			return true;

		} catch (Throwable e) {
			System.out.println(("Failed to input a end date"));
			return false;
		}
	    
	}

	@When("^I enter the number of associates needed$")
	public static boolean i_enter_the_number_of_associates_needed(WebDriver d) throws Throwable {
		
		try {
			Thread.sleep(500);
			Predictions.numberofAssociates(wd).sendKeys("15");
			return true;

		} catch (Throwable e) {
			System.out.println(("Failed to input the number of associates"));
			return false;
		}
	    
	}

	@When("^I select a select a technology from a drop down$")
	public static boolean i_select_a_select_a_technology_from_a_drop_down(WebDriver d) throws Throwable {
		
		try {
			Thread.sleep(500);
			Predictions.filterbyTechnologies(wd).click();
			Thread.sleep(500);
			//Select technology = new Select(wd.findElement(By.xpath("//*[@id=\\\"checkboxes\\\"]/div[3]/label")));
			//technology.selectByVisibleText("Java");
			//Predictions.technologyOption(wd).click();
			Predictions.technologyOption(wd).click();
			Thread.sleep(500);
			Predictions.filterbyTechnologies(wd).click();
			return true;

		} catch (Throwable e) {
			System.out.println(("Failed to select a technology"));
			return false;
		}
	   
	}
	
	@When("^I click on the Prediction button$")
	public static boolean i_click_on_the_Prediction_button(WebDriver d) throws Throwable {
		
		try {
			Thread.sleep(500);
			Predictions.buttonPrediction(wd).click();
			Thread.sleep(9000);
			return true;

		} catch (Throwable e) {
			System.out.println(("Failed to click on the Get Prediction button"));
			return false;
		}
	    
	}

	@Then("^I should see a table displaying the results$")
	public void i_should_see_a_table_displaying_the_results() throws Throwable {
		
		
	    
	}


}
