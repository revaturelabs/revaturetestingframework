package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.test.utils.WaitToLoad;

public class Logout {
	static WebElement e = null;

	public static WebElement logout(WebDriver d) {
		WebElement logout = null;
		try {
			Thread.sleep(1000);
			logout = WaitToLoad.findDynamicElement(d, By.cssSelector("li.nav-item:nth-child(6) > a:nth-child(1)"), 10);
			return logout;
			//d.quit();
		} catch (Throwable e) {
			System.out.println("Failed to log out");
			e.printStackTrace();
		}
		return logout;
	}
	
	public static void logoutCU(WebDriver d) {
		try {
			Thread.sleep(1000);
			WebElement logout = WaitToLoad.findDynamicElement(d, By.cssSelector("li.nav-item:nth-child(6) > a:nth-child(1)"), 10);
			logout.click();
		} catch (Throwable e) {
			System.out.println("Failed to log out");
			e.printStackTrace();
		}
	}

}

