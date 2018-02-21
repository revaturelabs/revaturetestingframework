
package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Room;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.LocationsPage;
import com.revature.pageObjectModel.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationTester {
	private Batch batch = null;

	WebDriver wd = null;
	WebDriverWait wait;
	Actions act;
	Room room;

	String locationName;
	String locationCity;
	String locationState;

	String buildingName;
	String newBuildingName;

	String roomName;

	Properties props;

	public LocationTester(WebDriver wd2, Properties props, Batch batch) {
		this.wd = wd2;
		this.props = props;
		this.batch = batch;
	}

	public LocationTester() {
		Batch batch = AssignForce.getAllBatches().get(0);
		this.room = batch.getRoom();
	}

	@Given("^I open up a web browser and I login as VP")
	@BeforeGroups(enabled = true, groups = {"VP", "VP1", "VP2"})
	public void loginAsVP() {

		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

		// Use Dummy Values When You Run Tests
		locationName = room.getLocationName();			//"Test_1.38";
		locationCity = room.getLocationCity();			//"Austin";
		locationState = room.getLocationState();		//"TX";
		buildingName = room.getBuildingName();			//"Random_1.38";
		newBuildingName = "Reston 11730";
		roomName = room.getRoomNumber();				//"Test_Room_1.38";

		MethodUtil.waitForLoad(wd, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a", 50).click();
//		LocationsPage.navigateToLocationsPage(wd).click();
	}
	@Then("^I logout$")
	@AfterGroups(enabled = true, groups = {"VP", "VP1", "VP2"})
	public void logout() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		LoginPage.logout(wd);
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}

	@When("^I add a location$")
	@Test(enabled = true, groups = "VP", priority = 0)
	public void addLocation() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click*='lCtrl.addLocation()']")));
		LocationsPage.newLocationButton(wd).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='ldCtrl.location.name']")));
		LocationsPage.newLocationName(wd).sendKeys(locationName);
		LocationsPage.newLocationCity(wd).sendKeys(locationCity);
		LocationsPage.newLocationState(wd).sendKeys(locationState);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	@When("^I add a building to the location$")
	@Test(enabled = true, groups = "VP", priority = 1)
	public void addBuilding() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label*='Toggle  "+ locationCity + ", " + locationState +"']")));
		LocationsPage.locationCheckBox(wd, locationCity, locationState).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bldgAdd")));
		LocationsPage.newBuildingButton(wd).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bldgCtrl.building.name']")));
		LocationsPage.newBuildingName(wd).sendKeys(buildingName);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	@When("^I add a room to the building$")
	@Test(enabled = true, groups = "VP", priority = 2)
	public void addRoom() {

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loc1\"]/md-list-item[2]/div/div[1]/md-checkbox")));
		act.moveToElement(LocationsPage.buildingCheckBox(wd)).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roomAdd")));
		act.moveToElement(LocationsPage.newRoomButton(wd)).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='rdCtrl.room.roomName']")));
		LocationsPage.newRoomName(wd).sendKeys(roomName);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	@Then("^I can edit the building$")
	@Test(enabled = true, groups = "VP", priority = 3)
	public void editBuilding() {

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loc1\"]/md-list-item[2]/div/div[1]/md-checkbox")));
		act.moveToElement(LocationsPage.buildingCheckBox(wd)).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locEdit")));
		act.moveToElement(LocationsPage.editButton(wd)).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bldgCtrl.building.name']")));
		LocationsPage.newBuildingName(wd).clear();
		LocationsPage.newBuildingName(wd).sendKeys(newBuildingName);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	@When("^I deactivate a location$")
	@Test(enabled = true, groups = "VP", priority = 4)
	public void deactivateLocation() {

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label*='Toggle  "+ locationCity + ", " + locationState +"']")));
		LocationsPage.locationCheckBox(wd, locationCity, locationState).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='lCtrl.deleteSelected()']")));
		LocationsPage.deactivateButton(wd).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='dCtrl.delete()']")));
		LocationsPage.confirmDeactivate(wd).click();
	}
}
