package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.test.utils.Associate;
import com.revature.test.utils.WaitToLoad;

public class AssociateInfoTab {
	private static WebElement e=null; 
	public static Associate associate=new Associate();//an associate object 
	public static int index=770;	//Specify the associateId num to select from the associate list 
	//Navigate to the associate info page
	/**
	 * find the associate id from associate list page
	 * @param d 
	 * @return associate id web element
	 */
public static WebElement getAssociateListTab(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div/app-root/app-janus/app-nav/nav/div[2]/div/app-track-force-nav/ul/li[4]/a"), 10);
	}
	public static WebElement getAssociateInList(WebDriver d) {
		//Element must be sorted in the ascending order(Which is by default enabled) 
	    //find the associateId in the list by typing in the research by id
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"name\"]"), 10);
		e.sendKeys(""+index);
		//Since the list is ordered by default the id should be at the top.
		//Populate the assocaite object with the fields from the table associate table list.
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[3]"), 10);
		associate.setFirstName(e.getText());
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[4]"), 10);
		associate.setLastName(e.getText());
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[5]"), 10);
		associate.setMarketStatus(e.getText());
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[6]"), 10);
		associate.setClientName(e.getText());
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[7]"), 10);
		associate.setBatchName(e.getText());
		e=WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[2]"), 10);
		associate.setAssociateId(Integer.parseInt(e.getText()));
		System.out.println("Load the associate info: "+associate.toString() );
		return WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"info\"]/table/tbody/tr[1]/td[2]/a"), 10);
		
		
	}
	
	public static WebElement getIdinBatchList(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[1]/td[2]"), 10);
	}

	// finding elements in associate info
	
	public static WebElement getAssociateFirstName(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[2]/td[2]"), 10);
	}
	public static WebElement getAssociateLastName(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[3]/td[2]"), 10);
	}
	public static WebElement getAssociateMarketingStatus(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[4]/td[2]"), 10);
	}
	public static WebElement getAssociatebatchName(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[5]/td[2]"), 10);
	}
	public static WebElement getAssociateClientName(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[6]/td[2]"), 10);
	}
	public static WebElement getAssociateStartingDate(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[1]/div/table/tbody/tr[7]/td[2]"), 10);
	}
	
	//Find elements in associate form
	public static WebElement associateMapped(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(1) > input[type='checkbox']"), 10);
	}
	public static WebElement associateEligibleForInterview(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(2) > input[type='checkbox']"), 10);
	}
	public static WebElement associateScheduledForInterview(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(3) > input[type='checkbox']"), 10);
	} 
	public static WebElement selectAssignedClient(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(4) > select > option:nth-child(4)"), 10);
	}
	
	public static WebElement associateClearedInterview(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(5) > input[type='checkbox']"), 10);
	}
	public static WebElement associateReceivedEmail(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(6) > input[type='checkbox']"), 10);
	}
	public static WebElement associatePassedBackgroundCheck(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(7) > input[type='checkbox']"), 10);
	}
	public static WebElement associateHaveStartingDate(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(8) > input[type='checkbox']"), 10);
	}
	public static WebElement associateStartingDate(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > div:nth-child(8) > input[name='startdate']"), 10);
	}
	public static WebElement updateButton(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.cssSelector("form > button"), 10);
	}
	// element from update manually form
	public static WebElement selectStatus(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[3]/div/div/select[1]"), 10);
	}
	public static WebElement selectClient(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[3]/div/div/select[2]"), 10);
	}
	public static WebElement applyStartDate(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[3]/div/div/input"), 10);
	}
	public static WebElement updateStatusButton(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[3]/div/div/button"), 10);
	}
    
	//element for adding an interview
	public static WebElement interviewAddbutton(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[2]/button"), 10);
	}
	public static WebElement selectClientInterviewForm(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[2]/div/div/form/div[1]/div/select"), 10);
	}
	public static WebElement InterviewType(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[2]/div/div/form/div[3]/div/select"), 10);
	}
	public static WebElement InterviewSDate(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[2]/div/div/form/div[2]/div/input"), 10);
	}
	public static WebElement interviewFeedback(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[2]/div/div/form/div[4]/div/textarea"), 10);
	}
	
	public static WebElement submitInterviewButton(WebDriver d) {
		return WaitToLoad.findDynamicElement(d, By.xpath("/html/body/div[1]/app-root/app-janus/form-comp/div/div[1]/div[2]/div/div/form/button"), 10);
	}
	
}
