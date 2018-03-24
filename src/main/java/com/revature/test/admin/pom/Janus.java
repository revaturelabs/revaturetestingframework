package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Janus {

	public static WebDriver wd = null;

	public static WebElement getAssignForce(WebDriver d) {
		return d.findElement(By.xpath("/html/body/div/app-root/app-janus/app-dashboard/div[2]/div[1]/div[2]"));
	}

	public static WebElement getCaliber(WebDriver d) {
		return d.findElement(By.xpath("/html/body/div/app-root/app-janus/app-dashboard/div[2]/div[2]/div[2]"));
	}	

	public static WebElement getTrackForce(WebDriver d) {
		return d.findElement(By.xpath("/html/body/div/app-root/app-janus/app-dashboard/div[2]/div[3]/div[2]"));
				//("/html/body/div/app-root/app-janus/app-dashboard/div[2]/div[3]/div[2]/img"));
	}
	
	public static String getTitle(WebDriver d) {
		return d.findElement(By.xpath("//title")).getText();
	}
}
