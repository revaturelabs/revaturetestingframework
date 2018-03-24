package com.revature.test.utils;

import org.openqa.selenium.WebDriver;


import com.revature.test.admin.pom.Janus;

public class JanusUtil {
	
	public static void clickTrackForce(WebDriver wd){
		Janus.getTrackForce(wd).click();
	}
	
	public static void clickAssignForce(WebDriver wd){
		Janus.getAssignForce(wd).click();
	}
	
	public static void clickCaliber(WebDriver wd){
		Janus.getCaliber(wd).click();
	}
	
	

}
