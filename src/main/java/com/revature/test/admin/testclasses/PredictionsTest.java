package com.revature.test.admin.testclasses;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.test.admin.cukes.PredictionsCukes;

public class PredictionsTest extends AdminSuite {
	
	@BeforeTest
	public void NavigateToPredictionsTab() {
		System.out.println("============ Initializing Predictions Tests ===============");
		System.out.println("");
		
		try {
			assertTrue(PredictionsCukes.i_am_on_the_Predictions_page(wd));
			assertTrue(PredictionsCukes.predictions_tab_loads(wd));
		} catch (Throwable e) {
			fail("Error: Failed to navigate to Predictions Page");
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void startDate() {
		try {

			assertTrue(PredictionsCukes.i_input_a_start_date(wd));
			assertTrue(PredictionsCukes.i_input_a_end_date(wd));
			assertTrue(PredictionsCukes.i_enter_the_number_of_associates_needed(wd));
			assertTrue(PredictionsCukes.i_select_a_select_a_technology_from_a_drop_down(wd));
			assertTrue(PredictionsCukes.i_click_on_the_Prediction_button(wd));

		} catch (Throwable e) {
			fail("Error: Failed to fill and submit form");
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void EndDate() {
		try {

			

		} catch (Throwable e) {
			fail("Error: Failed to input a end date");
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void inputAssociates() {
		try {

			

		} catch (Throwable e) {
			fail("Error: Failed to input the associates");
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void filterbyTechnologies() {
		try {

			

		} catch (Throwable e) {
			fail("Error: Failed to filter the technologies");
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5)
	public void clickPredictionButton() {
		try {

			
			

		} catch (Throwable e) {
			fail("Error: Failed to click on the Predictions Button");
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("============ Predictions Tests finished ===============");
	}
}
