package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.test.utils.WaitToLoad;

public class Predictions {
	
	static WebElement e = null;
	
	public static WebElement clickPredictionsTab(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("[href='/predictions']"), 10);
		//e= WaitToLoad.findDynamicElement(d,By.xpath("/html/body/app/app-predictions/app-navbar/nav/div/ul[1]/li[6]"), 10);
		//return e;										
	}
	
	public static String getCurrentURL(WebDriver d) {
		return d.getCurrentUrl();
	}
	
	public static WebElement startDate(WebDriver d) {
		e= WaitToLoad.findDynamicElement(d,By.xpath("//*[@id=\"startDate\"]"), 10);
		return e;
	}
	
	public static WebElement endDate(WebDriver d) {
		e= WaitToLoad.findDynamicElement(d,By.xpath("//*[@id=\"endDate\"]"), 10);
		
		return e;
	}
	
	public static WebElement numberofAssociates(WebDriver d) {
		e= WaitToLoad.findDynamicElement(d,By.xpath("/html/body/app/app-predictions/div/div/div[1]/form/div[3]/input"), 10);
		return e;
	}
	
	public static WebElement filterbyTechnologies(WebDriver d) {
		e= WaitToLoad.findDynamicElement(d,By.xpath("/html/body/app/app-predictions/div/div/div[1]/form/div[4]/div/div/div"), 10);
		return e;
		//*[@id="checkboxes"]/div[2]/label/input
	}
	
	public static WebElement technologyOption(WebDriver d) {
		e= WaitToLoad.findDynamicElement(d,By.xpath("//*[@id=\"checkboxes\"]/div[3]/label/input"), 10);
		return e;
	}
	
	public static WebElement buttonPrediction(WebDriver d) {
		e= WaitToLoad.findDynamicElement(d,By.xpath("/html/body/app/app-predictions/div/div/div[1]/form/button"), 10);
		return e;
	}
	
	

}
