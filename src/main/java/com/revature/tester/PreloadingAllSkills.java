package com.revature.tester;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Skill;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.CirriculaPage;
import com.revature.tester.MethodUtil;

public class PreloadingAllSkills {

	Set<Skill> necessarySkills = AssignForce.getAllBatches().get(0).getAllRequiredSkills();
	WebDriver driver = DriverFactory.getDriver("chrome");

	@BeforeTest(groups = { "VP", "Hib"})
	public void loginVP() {
		CirriculaPage.loginVPCredentials(driver);
	}

	@BeforeTest(groups = "Trainer")
	public void loginTrainer() {
		CirriculaPage.loginTrainerCredentials(driver);
	}

	@AfterTest(groups = { "VP", "Trainer", "Hib"})
	public void afterTest() {
		MethodUtil.executeJSClick(driver, CirriculaPage.logoutTab(driver));
	}

	@BeforeSuite(groups = { "VP", "Trainer", "Hib" })
	public void beforeSuite() {
		CirriculaPage.openSalesforceChrome(driver);
	}

	@AfterSuite(groups = { "VP", "Trainer", "Hib" })
	public void afterSuite() {
		driver.close();
		driver.quit();
	}
	
	@Test(priority =1, enabled = true, groups = { "VP", "Trainer", "Hib" })
	public void navigateToCurriculumTab() {
		MethodUtil.executeJSClick(driver, CirriculaPage.curriculaTab(driver));
	}

	@Test(priority=2, enabled=true, groups= {"VP", "Hib"})
	public void addSkillFocus() {
		if (CirriculaPage.isFocusPanelOpen(driver)) {
			try {
				for (Skill s : necessarySkills) {
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
				for (Skill s : necessarySkills) {
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
}
