package com.revature.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static WebDriver getDriver(String driverType) {
		IDriver driver = null;
		switch(driverType) {
		default:
		case "chrome":
			driver = new Chrome();
			return driver.selectDriver();
		case "firefox":
			driver = new Firefox();
			return driver.selectDriver();
		}
	}
}
