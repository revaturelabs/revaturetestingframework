package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.CirriculaPage;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ProfilePage;

public class TrainerGroupTester {

	com.revature.hibernate.model.Batch batch = AssignForce.getAllBatches().get(0);
	WebDriver driver = DriverFactory.getDriver("chrome");
	Properties props = new Properties();
	
	
	//Runs before the Suite
	@BeforeSuite
	public void loadProps() {
		MethodUtil.loadPropertiesFile(props);
	}
	
	//Before classes
	
	//Instantiating Test Classes
	OverviewTester ot = new OverviewTester(driver, props);
	BatchTester bt = new BatchTester(driver,props, batch);
	LocationTester lt = new LocationTester(driver,props, batch);
	CurriculumTester ct = new CurriculumTester(driver,props, batch);
	TrainerTest tt = new TrainerTest(driver,props, batch);
	ProfileTest pt = new ProfileTest(driver, props, batch);
	ReportTester rt = new ReportTester(driver,props);
	SettingSD st = new SettingSD(driver,props);
	
//	Login in as Trainer
	@BeforeClass()
	public void loginAsTrainer() {
		driver.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(driver, props.getProperty("TrainerUsername"), props.getProperty("TrainerPassword"));
		
	}
	
	
	//Overview Page Tests
	@Test(priority=1)
	public void overviewTestCSVDownload() {
		ot.testCSVDownload();
	}
	
	
	@Test(priority=2)
	public void overviewTestFilter() {
		ot.testFilter();
	}
	
	
	@Test(priority=3)
	public void overviewTestTableSort() {
		try { Thread.sleep(2500);} catch (InterruptedException e) { e.printStackTrace();}
		ot.testTableSort();
	}
	
	//Batches Page Tests
	@Test(priority=4) 
	public void navigateToBatchesPage() {
		MethodUtil.executeJSClick(driver, CirriculaPage.batchesTab(driver));
	}
	
	
	@Test(priority=5)
	public void batchesTestTableSort() {
		bt.testTableSort();
	}
	
	
	//Locations Page Tests
	@Test(priority = 6)
	public void navigateToLocationsPage() {
		MethodUtil.executeJSClick(driver, CirriculaPage.locationsTab(driver));
	}
	
	
	@Test(priority = 7)
	public void locationsTestTable() {
		//TODO: 
	}
	
	
	
	//Curricula Page Tests
	//Jump in priority to allow space for Locations page
	@Test(priority=13)
	public void navigateToCurriculaPage() {
		MethodUtil.executeJSClick(driver, CirriculaPage.curriculaTab(driver));
	}
	
	
	@Test(priority=14)
	public void curriculumCloseCurriculaPanel() {
		ct.closeCirriculumPanel();
	}
	
	
	@Test(priority=15)
	public void curriculumOpenCurriculaPanel() {
		ct.openCurriculumPanel();
	}
	
	
	@Test(priority=16)
	public void curriculumCloseFocusPanel() {
		ct.closeFocusPanel();
	}
	
	@Test(priority=17)
	public void curriculumOpenFocusPanel() {
		ct.openFocusPanel();
	}
	
	
	//Trainers Page Tests
	@Test(priority=18)
	public void navigateToTrainersPage() {
		MethodUtil.executeJSClick(driver, CirriculaPage.trainersTab(driver));
	}
	
	
//	@Test(priority=19)
//	public void trainersAddTrainerSave() {
//		tt.addTrainerSave();
//	}
	
	
	@Test(priority=20)
	public void trainersClickProfile() {
		tt.clickProfile();
	}
	
	
	@Test(priority=21)
	public void trainersCheckPTOCalendar() {
		tt.checkPTOCalendar();
	}
	
	
//	@Test(priority=22)
//	public void trainersDeactivateTrainerByName() {
//		tt.clickDeactivateTrainerByName();
//	}
	
	
//	@Test(priority=23)
//	public void trainersActivateTrainerByName() {
//		tt.clickReactivateTrainerByName();
//	}
	
	
	@Test(priority=24)
	public void trainersClickDownloadResume() {
		tt.clickDownloadResume();
	}
	
	
	//Profile Page Tests
	@Test(priority=25)
	public void navigateToProfilePage() {
		MethodUtil.executeJSClick(driver, ProfilePage.selectProfileTab(driver));
	}
	
	@Test(priority=26)
	public void profileSaveSkills() {
		try { Thread.sleep(1500);} catch (InterruptedException e) { e.printStackTrace();}
		pt.saveSkills();
	}
	
	
	
	
	
	@Test(priority=28)
	public void profileChangeName() {
		pt.changeName();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//Reports page Tests
	@Test(priority=28)
	public void navigateToReportsPage() {
		MethodUtil.executeJSClick(driver, CirriculaPage.reportsTab(driver));
	}
	
	//TODO: Trainer group Reports tests
	
	
	
	
	
	
	
	//Settings Page Tests
	//Gap in priorities to account for unfinished reports test
	@Test(priority=40)
	public void navigateToSettingsPage() {
		CirriculaPage.settingsTab(driver).click();
	}
	
	@Test(priority=41)
	public void settingsTestPage() {
		st.testSettingsPageAsTrainer();
	}
	
	//Runs after class
	@AfterClass
	public void doLogout() {
		MethodUtil.executeJSClick(driver, MethodUtil.waitForLoad(driver, "(//button)[1]"));
		MethodUtil.waitAndCloseDriver(driver, Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
}
