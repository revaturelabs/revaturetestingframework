
package com.revature.tester;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Curriculum;
import com.revature.hibernate.model.Focus;
import com.revature.hibernate.model.Skill;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.CirriculaPage;
import com.revature.pageObjectModel.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CurriculumTester {

	private static final Logger logger = Logger.getLogger(CurriculumTester.class);
	private Batch batch = null;
	WebDriver driver;
	Curriculum curriculum;
	Focus focus;
	Properties props;

	public CurriculumTester(WebDriver wd, Properties props, Batch batch) {
		this.driver = wd;
		this.props = props;
		this.batch = batch;
		this.curriculum = batch.getCurriculum();
		this.focus = batch.getFocus();
	}

	public CurriculumTester() {
		this.batch = AssignForce.getAllBatches().get(0);
		this.driver = DriverFactory.getDriver("chrome");
		this.focus = batch.getFocus();
		this.curriculum = batch.getCurriculum();
	}
	
	@Given("^I login as VP in curriculum")
	@BeforeTest(groups = { "VP" })
	public void loginVP() {
		CirriculaPage.loginVPCredentials(driver);
	}

//	@BeforeTest(groups = { "VP", "Hib"})
//	public void loginVP() {
//		CirriculaPage.loginVPCredentials(driver);
//	}

	@BeforeTest(groups = "Trainer")
	public void loginTrainer() {
		CirriculaPage.loginTrainerCredentials(driver);
	}

	@AfterTest(groups = { "VP", "Trainer", "Hib"})
	@Then("^I logout from curriculum page$")
	public void afterTest() {
		//MethodUtil.executeJSClick(driver, CirriculaPage.logoutTab(driver));
		MethodUtil.executeJSClick(driver, LoginPage.getLogout(driver));
	}

	@Given("^I open up a web browser$")
	@BeforeSuite(groups = { "VP", "Trainer" })
	public void beforeSuite() {
		CirriculaPage.openSalesforceChrome(driver);
		CirriculaPage.loginVPCredentials(driver);
	}

	@Then("^I close the browser$")
	@AfterSuite(groups = { "VP", "Trainer" })
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

	@Given("^I navigate to the curriculum tab")
	@Test(priority = 1, enabled = true, groups = { "VP", "Trainer" })
	public void navigateToCurriculumTab() {
		MethodUtil.executeJSClick(driver, CirriculaPage.curriculaTab(driver));
	}

	@Test(priority = 17, enabled = true, groups = "Trainer")
	public void closeCirriculumPanel() {
		try {
			Thread.sleep(300);
			MethodUtil.executeJSClick(driver, CirriculaPage.trainerToggleCurriculumPanel(driver));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 18, enabled = true, groups = "Trainer")
	public void openCurriculumPanel() {
		if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
			return;
		} else {
			MethodUtil.executeJSClick(driver, CirriculaPage.trainerToggleCurriculumPanel(driver));
		}
	}

	@Test(priority = 19, enabled = true, groups = "Trainer")
	public void closeFocusPanel() {
		MethodUtil.executeJSClick(driver, CirriculaPage.trainerToggleFocusPanel(driver));
	}

	@Test(priority = 20, enabled = true, groups = "Trainer")
	public void openFocusPanel() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			return;
		} else {
			MethodUtil.executeJSClick(driver, CirriculaPage.trainerToggleFocusPanel(driver));
		}
	}

	/* Works for both cancel and confirm removing a curriculum */

	@Test(priority = 3, enabled = true, groups = "VP")
	public void removeNthCurriculaButton() {
		if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
			try {
				CirriculaPage.removeNthCurriculaButton(driver, 1).click();
				Thread.sleep(250);
				CirriculaPage.cancelRemoveCurriculumButton(driver).click();
				Thread.sleep(250);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(150);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
				Thread.sleep(250);
				CirriculaPage.removeNthCurriculaButton(driver, 1).click();
				Thread.sleep(250);
				CirriculaPage.cancelRemoveCurriculumButton(driver).click();
				Thread.sleep(250);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@When("^I edit the curriculum name$")
	@Test(priority = 4, enabled = true, groups = "VP")
	public void editCurriculaButtonAndUpdateName() {
		//Insert openCurriculaPanel instead then you just run your logic after 
//		openCurriculumPanel();
//		editCurriculumName("Definitely William");
//		clickConfirmCurriculumUpdate();
		if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
			try {
				Thread.sleep(400);
				CirriculaPage.editNthCurriculaPanelButton(driver, 1).click();
				Thread.sleep(400);
				CirriculaPage.editCurriculumNameInputField(driver).clear();
				Thread.sleep(400);
				CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Definitely Not William");
				Thread.sleep(400);
				CirriculaPage.confirmButtonEditCurriculumPopup(driver).click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(150);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
				Thread.sleep(400);
				CirriculaPage.editNthCurriculaPanelButton(driver, 1).click();
				Thread.sleep(400);
				CirriculaPage.editCurriculumNameInputField(driver).clear();
				Thread.sleep(400);
				CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Definitely William");
				Thread.sleep(400);
				CirriculaPage.confirmButtonEditCurriculumPopup(driver).click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
	
	public void editCurriculumName(String curriculumName) {
		CirriculaPage.editNthCurriculaPanelButton(driver, 1).click();
		try {
			Thread.sleep(400);
			CirriculaPage.editCurriculumNameInputField(driver).clear();
			Thread.sleep(400);
			CirriculaPage.editCurriculumNameInputField(driver).sendKeys(curriculumName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@When("^I edit a focus$")
	@Test(priority = 7, enabled = true, groups = "VP")
	public void editFocusButtonAndEditName() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			try {
				Thread.sleep(400);
				CirriculaPage.editFirstFocusPanelButton(driver).click();
				Thread.sleep(400);
				CirriculaPage.textInputEditFocusPopup(driver).clear();
				Thread.sleep(400);
				CirriculaPage.textInputEditFocusPopup(driver).sendKeys("Ruby on Rails");
				Thread.sleep(250);
				CirriculaPage.confirmButtonEditFocusPopup(driver).click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(150);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
				Thread.sleep(400);
				CirriculaPage.editFirstFocusPanelButton(driver).click();
				Thread.sleep(400);
				CirriculaPage.textInputEditFocusPopup(driver).clear();
				Thread.sleep(400);
				CirriculaPage.textInputEditFocusPopup(driver).sendKeys("Ruby on Rails");
				Thread.sleep(250);
				CirriculaPage.confirmButtonEditFocusPopup(driver).click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Test(priority = 8, enabled = true, groups = "VP")
	public void removeFocusButton() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			try {
				Thread.sleep(300);
				MethodUtil.executeJSClick(driver, CirriculaPage.removeNthButtonFocus(driver, 1));
				Thread.sleep(300);
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonRemoveFocus(driver));
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(150);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
				Thread.sleep(300);
				MethodUtil.executeJSClick(driver, CirriculaPage.removeNthButtonFocus(driver, 1));
				Thread.sleep(300);
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonRemoveFocus(driver));
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@When("^I add a skill$")
	@Test(priority = 11, enabled = true, groups = "VP")
	public void addSkill() {
		if (CirriculaPage.isSkillPanelOpen(driver)) {
			try {
				for (Skill s : curriculum.getCurriculumSkill()) {
					Thread.sleep(400);
					CirriculaPage.addSkillInputField(driver).sendKeys(s.getSkillName());
					Thread.sleep(1000);
					MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
					Thread.sleep(400);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				for (Skill s : curriculum.getCurriculumSkill()) {
					Thread.sleep(100);
					MethodUtil.executeJSClick(driver, CirriculaPage.toggleSkillPanel(driver));
					Thread.sleep(250);
					CirriculaPage.addSkillInputField(driver).sendKeys(s.getSkillName());
					Thread.sleep(450);
					MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
					Thread.sleep(800);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	@Test(priority=12, enabled=true, groups= {"VP", "Hib"})
	public void addSkillFocus() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			try {
				for (Skill s : focus.getFocusSkill()) {
					Thread.sleep(400);
					CirriculaPage.addSkillInputField(driver).sendKeys(s.getSkillName());
					Thread.sleep(1000);
					MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
					Thread.sleep(400);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				for (Skill s : focus.getFocusSkill()) {
					Thread.sleep(100);
					MethodUtil.executeJSClick(driver, CirriculaPage.toggleSkillPanel(driver));
					Thread.sleep(250);
					CirriculaPage.addSkillInputField(driver).sendKeys(s.getSkillName());
					Thread.sleep(450);
					MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
					Thread.sleep(800);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@When("^I add a skill to a curriculum$")
	@Test(priority = 12, enabled = true, groups = "VP")
	public void editCurriculumPopupAddSkills() {
		if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
			try {
				Thread.sleep(400);
				// Opens up Update Curricula Panel
				MethodUtil.executeJSClick(driver, CirriculaPage.editNthCurriculaPanelButton(driver, 1));
				Thread.sleep(400);
				// Activates the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(500);
				// Gets list of all skills
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(500);
				// Clicking all options in the dropdown
				for (int i = 0; i < skills.size(); i++) {
					skills.get(i).click();
				}
				Thread.sleep(500);
				// //Unclicking all options in dropdown
				// for (int i = 0; i < skills.size(); i++) {
				// skills.get(i).click();
				// }
				Thread.sleep(500);
				// Deactivates the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(200);
				// Cancels the changes
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {

			try {
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
				Thread.sleep(400);
				// Opens up Update Curricula Panel
				MethodUtil.executeJSClick(driver, CirriculaPage.editNthCurriculaPanelButton(driver, 1));
				Thread.sleep(400);
				// Activates the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(500);
				// Gets list of all skills
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(500);
				// Clicking all options in the dropdown
				for (int i = 0; i < skills.size(); i++) {
					skills.get(i).click();
				}
				Thread.sleep(500);
				// //Unclicking all options in dropdown
				// for (int i = 0; i < skills.size(); i++) {
				// skills.get(i).click();
				// }
				Thread.sleep(500);
				// Deactivates the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(200);
				// Cancels the changes
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickCancelCurriculumUpdate() {
		MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));
	}

	@When("^I add a skill to a focus$")
	@Test(priority = 13, enabled = true, groups = "VP")
	public void editFocusPopupAddSkills() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			try {
				Thread.sleep(400);
				// Opens the edit focus panel
				CirriculaPage.editFirstFocusPanelButton(driver).click();
				Thread.sleep(400);
				// Activates the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(500);
				// Gets all skills from dropdown
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(250);
				// Clicking all options in the dropdown
				for (int i = 0; i < skills.size(); i++) {
					skills.get(i).click();
				}
				// Thread.sleep(250);
				// //Unclicking all options in dropdown
				// for (int i = 0; i < skills.size(); i++) {
				// skills.get(i).click();
				// }
				Thread.sleep(500);
				// Deactivate the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(200);
				// Cancel Changes
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(300);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
				Thread.sleep(400);
				// Opens the edit focus panel
				CirriculaPage.editFirstFocusPanelButton(driver).click();
				Thread.sleep(400);
				// Activates the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(500);
				// Gets all skills from dropdown
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(250);
				// Clicking all options in the dropdown
				for (int i = 0; i < skills.size(); i++) {
					if (i % 6 == 0) {
						skills.get(i).click();
					}
				}
				// Thread.sleep(250);
				// //Unclicking all options in dropdown
				// for (int i = 0; i < skills.size(); i++) {
				// if (i % 6 == 0) {
				// skills.get(i).click();
				// }
				// }
				Thread.sleep(500);
				// Deactivate the dropdown
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(200);
				// Cancel Changes
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@When("^I add a curriculum$")
	@Test(priority = 14, enabled = true, groups = "VP")
	public void addNewCurriculum() {
//		openCurriculumPanel();
//		editCurriculumName("RobinScrippp");
//		clickEditSkillsDropdownForCurriculum();
//		List<WebElement> skills = getEditSkillsDropdownList();
//		
//		addEveryOtherSkill(skills);
//		clickCancelCurriculumUpdate();
		if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
			try {
				Thread.sleep(1000);
				// Opens add new curricula popup
				MethodUtil.executeJSClick(driver, CirriculaPage.addNewCurriculumButton(driver));
				Thread.sleep(600);
				// clears the text field and sends text to the Curriculum Name field
				CirriculaPage.editCurriculumNameInputField(driver).clear();
				CirriculaPage.editCurriculumNameInputField(driver).sendKeys(curriculum.getCurriculumName());
				Thread.sleep(600);
				// Opens dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(600);
				// Add skills to the curriculum
				for (Skill s : curriculum.getCurriculumSkill()) {
					for (int i = 0; i < skills.size(); i++) {
						if (skills.get(i).getText().equals(s.getSkillName())) {
							skills.get(i).click();
							Thread.sleep(500);
						}
					}
				}
				Thread.sleep(600);
				// Deactivates dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(600);
				// Save curriculum
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonEditFocusPopup(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e2) {
				logger.debug(e2);
			}

		} else {
			try {
				Thread.sleep(600);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
				Thread.sleep(600);
				// Opens add new curricula popup
				MethodUtil.executeJSClick(driver, CirriculaPage.addNewCurriculumButton(driver));
				Thread.sleep(600);
				// clears the text field and sends text to the Curriculum Name field
				CirriculaPage.editCurriculumNameInputField(driver).clear();
				CirriculaPage.editCurriculumNameInputField(driver).sendKeys(curriculum.getCurriculumName());
				Thread.sleep(600);
				// Opens dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(600);
				// Add skills to the curriculum
				for (Skill s : curriculum.getCurriculumSkill()) {
					for (int i = 0; i < skills.size(); i++) {
						if (skills.get(i).getText().equals(s.getSkillName())) {
							skills.get(i).click();
							Thread.sleep(500);
						}
					}
				}
				Thread.sleep(600);
				// Deactivates dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
				Thread.sleep(600);
				// Save curriculum
				MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonEditFocusPopup(driver));

			} catch (InterruptedException e) {
				logger.debug(e);
				e.printStackTrace();
			} catch (Exception e2) {
				logger.debug(e2);
			}
		}
	}

	public void clickEditSkillsDropdownForCurriculum() {
		MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
	}
	
	public void modifySkillList() {
		List<WebElement> skills = getEditSkillsDropdownList();
		addEveryOtherSkill(skills);
	}
	public List<WebElement> getEditSkillsDropdownList() {
		return driver.findElements(By.tagName("md-option"));
	}
	
	public void addEveryOtherSkill(List<WebElement> skills) {
		for (int i = 0; i < skills.size(); i++) {
			if (i % 2 == 0) {
				skills.get(i).click();
			}
		}
	}

	@When("^I add a focus$")
	@Test(priority = 15, enabled = true, groups = "VP")
	public void addNewFocus() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			try {
				Thread.sleep(1000);
				// Opens the add new focus popup
				MethodUtil.executeJSClick(driver, CirriculaPage.addNewFocusButton(driver));
				Thread.sleep(600);
				// Clears the Focus name input field and sends keys
				CirriculaPage.editFocusNameInputField(driver).clear();
				CirriculaPage.editFocusNameInputField(driver).sendKeys(focus.getFocusName());
				Thread.sleep(600);
				// Opens the dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforFocus(driver));
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(600);
				// Add skills to the curriculum
				for (Skill s : focus.getFocusSkill()) {
					for (int i = 0; i < skills.size(); i++) {
						if (skills.get(i).getText().equals(s.getSkillName())) {
							skills.get(i).click();
							Thread.sleep(500);
						}
					}
				}
				Thread.sleep(600);
				// Deactivates dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforFocus(driver));
				Thread.sleep(600);
				// Save curriculum
				MethodUtil.executeJSClick(driver, CirriculaPage.confirmButtonEditFocusPopup(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(1000);
				MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
				Thread.sleep(600);
				// Opens the add new focus popup
				MethodUtil.executeJSClick(driver, CirriculaPage.addNewFocusButton(driver));
				Thread.sleep(600);
				// Clears the Focus name input field and sends keys
				CirriculaPage.editFocusNameInputField(driver).clear();
				CirriculaPage.editFocusNameInputField(driver).sendKeys("Andrew's Sorcery");
				Thread.sleep(600);
				// Opens the dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforFocus(driver));
				List<WebElement> skills = driver.findElements(By.tagName("md-option"));
				Thread.sleep(600);
				// Add skills to the curriculum
				for (Skill s : focus.getFocusSkill()) {
					for (int i = 0; i < skills.size(); i++) {
						if (skills.get(i).getText().equals(s.getSkillName())) {
							skills.get(i).click();
							Thread.sleep(500);
						}
					}
				}
				Thread.sleep(600);
				// Deactivates dropdown list
				MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforFocus(driver));
				Thread.sleep(600);
				// Save curriculum
				MethodUtil.executeJSClick(driver, CirriculaPage.confirmButtonEditFocusPopup(driver));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
