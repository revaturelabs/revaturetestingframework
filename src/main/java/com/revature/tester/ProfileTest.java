package com.revature.tester;

import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Skill;
import com.revature.hibernate.model.Trainer;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ProfilePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ProfileTest {
	private Batch batch = null;
	Properties props = new Properties();
	WebDriver wd;
	Trainer t;

	public ProfileTest(WebDriver wd, Properties props, Batch batch) {
		this.wd = wd;
		this.props = props;
		this.batch = batch;
		this.t = batch.getTrainer();
	}

	public ProfileTest() {

		this.batch = AssignForce.getAllBatches().get(0);
		this.t = batch.getTrainer();
	}


	public void clickFirstCurrentSkill() {
		ProfilePage.selectCurrentSkill(wd).click();
	}

	public List<WebElement> getCurrentSkillList() {
		return ProfilePage.getCurrentSkillList(wd);
	}

	@When("^I save the skills$")
	public void clickSaveSkill() {
		ProfilePage.selectSaveSkill(wd).click();
	}

	@When("^I click on \"([^\"]*)\" to remove from current skills$")
	public void clickCurrentSkillByName(String skillName) {
		getCurrentSkillByName(skillName).click();
	}


	@When("^I click on \"([^\"]*)\" from choose skills$")
	public void clickChooseSkillByName(String skillName) {
		getChooseSkillByName(skillName).click();
	}

	public WebElement getCurrentSkillByName(String skillName) {
		for (WebElement we : ProfilePage.getCurrentSkillList(wd)) {
			if (we.getText().contains(skillName.toUpperCase())) {
				return we;
			}
		}
		throw new NoSuchElementException(skillName + " was not found in \"Current Skills\"");
	}

	public WebElement getChooseSkillByName(String skillName) {
		for (WebElement we : ProfilePage.getChooseSkillList(wd)) {
			if (we.getText().contains(skillName)) {
				return we;
			}
		}
		throw new NoSuchElementException(skillName + " was not found in \"Choose Skills\"");
	}

	@Then("^I should see \"([^\"]*)\" on the list of skills to choose from$")
	public void checkForSkillInChooseList(String skillName) {
		assertNotNull(getChooseSkillByName(skillName));
	}

	public List<WebElement> getChooseSkillList() {
		return ProfilePage.getChooseSkillList(wd);
	}

	@Then("^I should see \"([^\"]*)\" on my list of skills$")
	public void checkForSkillInCurrentList(String skillName) {
		assertNotNull(getCurrentSkillByName(skillName));
	}


	@Given("^I do not have \"([^\"]*)\" as a skill$")
	public void removeSkillFromCurrentList(String skillName) {
		try {
			clickCurrentSkillByName(skillName);
		} catch (NoSuchElementException e) {
			System.out.println(skillName + " is not in the current skills list");
		}
		System.out.println(skillName + " has been removed from the current skills list");
	}

	@Given("^I have \"([^\"]*)\" as a skill$")
	public void addSkillToCurrentList(String skillName) {
		try {
			clickChooseSkillByName(skillName);
		} catch (NoSuchElementException e) {
			System.out.println(skillName + " is not in the list of skills to choose from");
		}
		System.out.println(skillName + " has been added to the list of skills");
	}


	@Given("^I click on the profile tab$")
	@Test(groups = "Trainer")
	public void clickProfileTab() {
		ProfilePage.selectProfileTab(wd).click();
	}

	@Test(groups = "Trainer", priority = 5, dependsOnMethods = "clickProfileTab")
	public void changeName() {
		try {
			Thread.sleep(100);
			ProfilePage.insertFirstname(wd).clear();
			Thread.sleep(100);
			ProfilePage.insertFirstname(wd).sendKeys(t.getTrainerFirstName());
			Thread.sleep(2000);
			ProfilePage.insertLastname(wd).clear();
			Thread.sleep(100);
			ProfilePage.insertLastname(wd).sendKeys(t.getTrainerLastName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "Trainer", priority = 7, dependsOnMethods = "clickProfileTab")
	public void addResume() {
		ProfilePage.selectAddResume(wd).click();
	}

//	@Test(groups = "Trainer", priority = 3, dependsOnMethods = "clickProfileTab")
//	public void saveSkills() {
//		boolean done = false;
//			try {
//				clickCurrentSkillByName("Not William WebDriver");
//				done = true;
//				Thread.sleep(800);
//				clickChooseSkillByName( "Not William WebDriver");
//			} catch (NoSuchElementException e) {
//				try {
//					if(!done) {
//						clickChooseSkillByName("Not William WebDriver");
//						Thread.sleep(800);
//						clickCurrentSkillByName("Not William WebDriver");
//					}
//					else throw new NoSuchElementException("",e);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
////			clickSaveSkill();
////			int chooseSkillList = ProfilePage.getChooseSkillList(wd).size()/2;
////			for(int i = 0; i < chooseSkillList; i++)
////				clickFirstChooseSkill();
//			int currentSkillList = ProfilePage.getCurrentSkillList(wd).size();
//			for(int i = 0; i < currentSkillList; i++)
//				clickFirstCurrentSkill();
//			Set<String> skillStrings = new HashSet<String>();
//			for (Skill s : t.getTrainerSkill()) {
//				skillStrings.add(s.getSkillName());
//			}
//
//			for (String s : skillStrings) {
//						clickChooseSkillByName(s);
//			}
//			clickSaveSkill();
//	}
	@Test(groups = "Trainer", priority = 3, dependsOnMethods = "clickProfileTab")
	public void saveSkills() {
		int currentSkillList = ProfilePage.getCurrentSkillList(wd).size();
		for(int i = 0; i < currentSkillList; i++)
			clickFirstCurrentSkill();
		Set<Skill> skillStrings = t.getTrainerSkill();
		System.out.println("Amount of skills: " + skillStrings.size());
		for (Skill s : skillStrings)
			clickChooseSkillByName(s.getSkillName());
		clickSaveSkill();
	}

	@Given("^log in as a trainer$")
	@BeforeClass(groups = "Trainer")
	public void loginAsTrainer() {
		LoginPage.getUsernameInput(wd).sendKeys("test.trainer@revature.com.int1");
		LoginPage.getPasswordInput(wd).sendKeys("trainer123");
		LoginPage.getLoginBtn(wd).submit();
	}

	@Then("^I Log out$")
	@AfterClass(groups = "Trainer")
	public void logout() {
		MethodUtil.executeJSClick(wd, LoginPage.getLogout(wd));
	}

	@Given("^I open a browser to go to AssignForce$")
	@BeforeTest(groups = "Trainer")
	public void openWebDriverToAssignForce() {
		LoginPage.goToAssignForce(wd);
	}

	@Then("^close the window$")
	@AfterTest(groups = "Trainer")
	public void closeDriver() {
		wd.quit();
	}

	@BeforeMethod(groups = "Trainer")
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
