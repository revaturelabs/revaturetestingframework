package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.LoginPage;
import com.revature.tester.TrainerTest;

public class VPGroupTester {
	WebDriver wd = DriverFactory.getDriver("chrome");
	Properties props = new Properties();
	com.revature.hibernate.model.Batch batch = AssignForce.getAllBatches().get(0);
	
	public VPGroupTester(){}
	
//	RUN BEFORE THE SUITE
	@BeforeSuite
	public void loadProps() {
		MethodUtil.loadPropertiesFile(props);
	}
	
//  RUN BEFORE THE CLASS
//  INSTANTIATE TEST CLASSES
	OverviewTester ot = new OverviewTester(wd,props);
	BatchTester bt = new BatchTester(wd,props, batch);
	LocationTester lt = new LocationTester(wd,props, batch);
	CurriculumTester ct = new CurriculumTester(wd,props, batch);
	TrainerTest tt = new TrainerTest(wd,props, batch);
	ReportTester rt = new ReportTester(wd,props);
	SettingSD st = new SettingSD(wd,props);

//	START LOGIN PAGE TESTING
	@Test(priority=0)
	public void loginAsVP() {
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("VPUsername"), props.getProperty("VPPassword"));
	}
	
//	START OVERVIEW PAGE TESTING
	@Test(priority=1)
	public void overviewTestDownload() {
		ot.testCSVDownload();
	}
	
	@Test(priority=2)
	public void overviewTestFilter() {
		ot.testFilter();
	}
	
	@Test(priority=3)
	public void overviewTestTableSort() {
		ot.testTableSort();
	}

// START BATCH PAGE TESTING
	@Test(priority=4)
	public void batchTestFillCurriculum() {
		// navigate to batch page
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "//a[@ng-href=\"batches\"]",20));
		bt.fillCurriculum();
	}
	
	@Test(priority=5)
	public void batchTestFillFocus() {
		bt.fillFocus();
	}
	
	@Test(priority=5)
	public void batchTestFillSkills() {
		bt.fillSkills();
	}
	
	@Test(priority=6)
	public void batchTestFillStartDate() {
		bt.fillStartDate();
	}
	
	@Test(priority=7)
	public void batchTestFillEndDate() {
		bt.fillEndDate();
	}
	
	@Test(priority=8)
	public void batchTestWeekSpan() {
		bt.showAccurateWeekspan();
	}
	
	@Test(priority=9)
	public void batchFillName() {
		bt.fillBatchName();
	}
	
	@Test(priority=10)
	public void batchFillTrainer() {
		bt.fillTrainer();
	}
	
	@Test(priority=11)
	public void batchFillCoTrainer() {
		bt.fillCoTrainer();
	}

	@Test(priority=12)
	public void batchFillLocation() {
		bt.fillLocation();
	}
	
	@Test(priority=13)
	public void batchFillBuilding() {
		bt.fillBuilding();
	}
	
	@Test(priority=14)
	public void batchFillRoom() {
		bt.fillRoom();
	}
	
	@Test(priority=15)
	public void createBatch() {
		bt.testVPCreateBatch();
	}
	
	@Test(priority=16)
	public void cancelBatch() {
		bt.testVPCancelBatchCreation();
	}
	
	@Test(priority=17)
	public void batchTestRefresh() {
		bt.testRefresh();
	}
	
//  START LOCATION PAGE TESTING
	@Test(priority=18)
	public void locationAddLocation() {
		// navigate to batch page
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "//a[@ng-href=\"locations\"]",20));
		lt.addLocation();
	}
	
	@Test(priority=19)
	public void locationAddBuilding() {
		lt.addBuilding();
	}
	
	@Test(priority=20)
	public void locationAddRoom() {
		lt.addRoom();
	}
	
	@Test(priority=21)
	public void locationEditBuilding() {
		lt.editBuilding();
	}
	
	@Test(priority=22)
	public void locationDeactivateLocation() {
		lt.deactivateLocation();
	}

//	START CURRICULUM PAGE TESTING
	@Test(priority=23)
	public void navigateToCurriculumPage() {
		ct.navigateToCurriculumTab();
	}
	
	@Test(priority=24)
	public void currRemoveNthCurriculaButton() {
		ct.removeNthCurriculaButton();
	}
	
	@Test(priority=25)
	public void currEditCurriculaButtonAndUpdateName() {
		ct.editCurriculaButtonAndUpdateName();
	}
	
	@Test(priority=26)
	public void currEditFocusButtonAndEditName() {
		ct.editFocusButtonAndEditName();
	}
	
	@Test(priority=27)
	public void currRemoveFocusButton() {
		ct.removeFocusButton();
	}
	
	@Test(priority=28)
	public void currAddSkillCurriculum() {
		//ct.addSkillCurriculum();
	}
	
	@Test(priority=29)
	public void currAddSkillFocus() {
		ct.addSkillFocus();
	}
	
	@Test(priority=30)
	public void currEditCurriculumPopupAddSkills() {
		ct.editCurriculumPopupAddSkills();
	}
	
	@Test(priority=31)
	public void currEditFocusPopupAddSkills() {
		ct.editFocusPopupAddSkills();
	}
	
	@Test(priority=32)
	public void currAddNewCurriculum() {
		ct.addNewCurriculum();
	}
	
	@Test(priority=33)
	public void currAddNewFocus() {
		ct.addNewFocus();
	}
	
//	START TRAINERS PAGE TESTING
	@Test(priority=34)
	public void trainerAddNewFocus() {
		// navigate to batch page
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "//a[@ng-href=\"trainers\"]",20));
		tt.clickTrainersTab();
		tt.addTrainerSave();
	}
	
	@Test(priority=35)
	public void trainerAddTrainerCancel() {
		tt.addTrainerCancel();
	}
	
	@Test(priority=36)
	public void trainerClickProfile() {
		tt.clickProfile();
	}
	
	@Test(priority=37)
	public void trainerCheckPTOCalendar() {
		tt.checkPTOCalendar();
	}
	
	@Test(priority=38)
	public void trainerClickDeactivateTrainerByName() {
		tt.clickDeactivateTrainerByName();
	}
	
	@Test(priority=39)
	public void trainerClickReactivateTrainerByName() {
		tt.clickReactivateTrainerByName();
	}
	
	@Test(priority=40)
	public void trainerClickDownloadResume() {
		tt.clickDownloadResume();
	}
	
//	START REPORTS PAGE TESTING
	@Test(priority=41)
	public void reportsTestBatchProjection() {
		// navigate to batch page
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "//a[@ng-href=\"reports\"]",20));
		//rt.testBatchProjection();
		try {
			rt.reportsTestTheCardInBatchProjection();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=41)
	public void reportsTestGraduateSummary() {
		try {
			rt.reportsTestGraduateSummary();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=41)
	public void reportsTestIncomingTraineeSummary() {
		tt.clickDownloadResume();
	}
	
//	START SETTINGS PAGE TESTING
	@Test(priority=42)
	public void settingsTestTrainersPerPage() {
		// navigate to batch page
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "//a[@ng-href=\"settings\"]",20));
		st.testTrainersPerPage();
	}
	
	@Test(priority=42)
	public void settingsTestReportsOutgoingGrads() {
		st.testReportsOutgoingGrads();
	}
	
	@Test(priority=42)
	public void settingsTestReportsIncomingCandidates() {
		st.testReportsIncomingCandidates();
	}
	
	@Test(priority=42)
	public void settingsTestDefaultLocation() {
		st.testReportsIncomingCandidates();
	}
	
	@Test(priority=42)
	public void settingsTestDefaultBuilding() {
		st.testDefaultBuilding();
	}
	
	@Test(priority=42)
	public void settingsTestMinBatchSize() {
		st.testMinBatchSize();
	}
	
	@Test(priority=42)
	public void settingsTestMaxBatchSize() {
		st.testMaxBatchSize();
	}
	
	@Test(priority=42)
	public void settingsTestDefaultBatchLength() {
		st.testDefaultBatchLength();
	}
	
	@Test(priority=42)
	public void settingsTestMinBetweenTrainerBatch() {
		st.testMinBetweenTrainerBatch();
	}
	
	@Test(priority=42)
	public void settingsTrainerTestSaveButton() {
		st.testSaveButton();
	}
	
	@Test(priority=42)
	public void settingsTrainerTestSettingsPageAsVP() {
		st.testSettingsPageAsTrainer();
	}
	
	@Test(priority=43)
	public void settingsTrainerTestTheDefaultLocation() {
		st.testTheDefaultLocation();
	}
	
	@Test(priority=44)
	public void settingsTestTimelineTrainersPerPage() {
		st.testTimelineTrainersPerPage();
	}
	
	@Test(priority=45)
	public void settingsTestOutgoingGrads() {
		st.testOutgoingGrads();
	}
	
	@Test(priority=46)
	public void settingsTestIncomingTrainees() {
		st.testIncomingTrainees();
	}
	
	@Test(priority=47)
	public void settingsTestSettingsPageAsTrainer() {
		st.testSettingsPageAsTrainer();
	}
	
//  RUN AFTER THE CLASS
	@AfterClass
	public void doLogout() {
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "(//button)[1]"));
		MethodUtil.waitAndCloseDriver(wd, Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
//  RUN AFTER THE SUITE
}
