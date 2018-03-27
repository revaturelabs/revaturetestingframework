package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.test.utils.WaitToLoad;

public class CreateUserTab {
	static WebElement e = null;

	public static WebElement getCreateUserTab(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("#createUserNav"), 10);
	}
	
	public static WebElement getCreateNewUserHeader(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-create-user/div/div/div[2]/h3"), 10);
	}

	public static String getCurrentURL(WebDriver d) {
		return d.getCurrentUrl();
	}

	public static WebElement getTabHeader(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-create-user/div/div/div[1]/h3"), 10);
	}
	
	public static WebElement getUsername(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.name("username"), 10);
	}
	
	public static WebElement getPassword(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.name("password"), 10);
	}

	public static WebElement getPasswordConfirm(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.name("password2"), 10);
	}

	public static WebElement getAdminRadio(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-create-user/div/div/div[2]/form/div/input[1]"), 10);
	}
	
	public static WebElement getManagerRadio(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-create-user/div/div/div[2]/form/div/input[2]"), 10);
	}
	
	public static WebElement getVPRadio(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-create-user/div/div/div[2]/form/div/input[3]"), 10);
	}

	/*public static WebElement getAssociateRadio(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("[value='4']"), 10);
	}*/
	
	public static WebElement getSubmit(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-create-user/div/div/div[2]/form/input[4]"), 10);
	}

}