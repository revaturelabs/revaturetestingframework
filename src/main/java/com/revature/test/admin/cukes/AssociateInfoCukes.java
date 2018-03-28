package com.revature.test.admin.cukes;

import org.openqa.selenium.WebDriver;

import com.revature.test.admin.pom.AssociateInfoTab;
import com.revature.test.utils.TestConfig;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssociateInfoCukes {
	

		  

	@Given("^I am in the associate List page$")
	public static boolean i_am_in_the_associate_List_page(WebDriver d){
		try {
			Thread.sleep(1500);
			AssociateInfoTab.getAssociateListTab(d).click();
			System.out.println("-------Associate info page-----");
			return true;
		} catch (Throwable e) {
			System.out.println("Failed to click Associate List tab");
			return false;
		}
		
		
		
		   
	}

	@Given("^I am in the batch list page$")
	public static boolean i_am_in_the_batch_list_page(WebDriver d){
		try {
			AssociateInfoTab.getAssociateInList(d).click();
			System.out.println("Click on associate Id");
			return true;
		    }catch (Throwable e){
		        System.out.println("Failed to click on associate Id");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^I click on the assocaite id$")
	public static boolean i_click_on_the_assocaite_id(WebDriver d) {
		try {
			AssociateInfoTab.getAssociateInList(d).click();
			System.out.println("Click on associate Id");
			return true;
		    }catch (Throwable e){
		        System.out.println("Failed to click on associate Id");    	
		        
		    	return false;
		    	
		    }
		}

	@Then("^I am in the associate info page$")
	public static boolean i_am_in_the_associate_info_page(WebDriver d) {
		try {
			
			System.out.println("The associate Info page is: " +d.getCurrentUrl() );
			return d.getCurrentUrl().equals(TestConfig.getBaseURL()+"#/TrackForce/form-comp/" + AssociateInfoTab.index);
			
		    }catch (Throwable e){
		        System.out.println("Failed to click on associate Id");    	
		        
		    	return false;
		    	
		    }
		
	}

	@Given("^Now I am in the associate info page$")
	public static boolean now_i_am_in_the_associate_info_page(WebDriver d) {
		return d.getCurrentUrl().contains(TestConfig.getBaseURL()+"#/TrackForce/form-comp/");   
	    
	}

	@When("^I check associate mapped$")
	public static boolean i_check_associate_mapped(WebDriver d){
       try {
			
			System.out.println("check associate mapped: ");
			AssociateInfoTab.associateMapped(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to click on associate mapped");    	
		        
		    	return false;
		    	
		    }	
       }

	@When("^check associate eligible for an interview$")
	public static boolean check_associate_eligible_for_an_interview(WebDriver d){
      try {
			
			System.out.println("check associate eligibility to an anterview: ");
			AssociateInfoTab.associateEligibleForInterview(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to click on eligibile for an anterview");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^check associate scheduled for an interview$")
	public static boolean check_associate_scheduled_for_an_interview(WebDriver d){
      try {
			
			System.out.println("check associate scheduled for an interview: ");
			AssociateInfoTab.associateScheduledForInterview(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to check scheduled for interview");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^select assigned client$")
	public static boolean select_assigned_client(WebDriver d) {
     try {
			
			System.out.println("check assigned a client: ");
			AssociateInfoTab.getAssociateClientName(d).sendKeys("Brillio");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to check on associate mapped");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^check associate cleared all interviews$")
	public static boolean check_associate_cleared_all_interviews(WebDriver d){
       try {
			
			System.out.println("check associate cleared an interview: ");
			AssociateInfoTab.associateClearedInterview(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to check on associate cleared an interview");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^check email been received from the client$")
	public static boolean check_email_been_received_from_the_client(WebDriver d){
        try {
			
			System.out.println("check associate received email: ");
			AssociateInfoTab.associateReceivedEmail(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to check on associate received an email");    	
		        
		    	return false;
		    	
		    }	
        }

	@When("^check associate passed a background check$")
	public static boolean check_associate_passed_a_background_check(WebDriver d){
       try {
			
			System.out.println("check associate passed background: ");
			AssociateInfoTab.associatePassedBackgroundCheck(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to check on associate passed background");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^check associate have a start date$")
	public static boolean check_associate_have_a_start_date(WebDriver d){
     try {
			
			System.out.println("check associate have start date: ");
			AssociateInfoTab.associateHaveStartingDate(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to click on associate mapped");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^Enter starting date$")
	public static boolean enter_starting_date(WebDriver d){
      try {
			
			System.out.println("enter date: ");
			AssociateInfoTab.associateStartingDate(d).sendKeys("03");
			AssociateInfoTab.associateStartingDate(d).sendKeys("29");
			AssociateInfoTab.associateStartingDate(d).sendKeys("2018");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to enter the date");    	
		        
		    	return false;
		    	
		    }
	}

	@Then("^Associate info succefully updated$")
	public static boolean associate_info_succefully_updated(WebDriver d) {
         try {
			
			System.out.println("Click update: ");
			AssociateInfoTab.updateButton(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to update");    	
		        
		    	return false;
		    	
		    }
	    
	}

	@When("^I select a status and$")
	public static boolean i_select_a_status_and(WebDriver d){
       try {
			
			System.out.println("select status ");
			AssociateInfoTab.selectStatus(d).sendKeys("UNMAPPED: OPEN");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to select the status");    	
		        
		    	return false;
		    	
		    }
	    
	}

	@When("^I assign a client$")
	public static boolean i_assign_a_client(WebDriver d){
         try {
			
			System.out.println("select client ");
			AssociateInfoTab.selectClient(d).sendKeys("Brillio");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to client");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^I apply starting date$")
	public static boolean i_apply_starting_date(WebDriver d){
         try {
			
			System.out.println("select starting date");
			AssociateInfoTab.applyStartDate(d).sendKeys("03");
			AssociateInfoTab.applyStartDate(d).sendKeys("29");
			AssociateInfoTab.applyStartDate(d).sendKeys("2018");
			AssociateInfoTab.updateStatusButton(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to select the date");    	
		        
		    	return false;
		    	
		    }
	}

	@Given("^I am in the associate info page$")
	public static boolean i_am_in_teh_associate_info_page(WebDriver d){
	    return d.getCurrentUrl().contains("http://52.70.53.136:8086/angular/#/TrackForce/form-comp/");
	    
	}

	@Given("^Click on Toggle create new Interview form$")
	public static boolean click_on_Toggle_create_new_Interview_form(WebDriver d) {
       try {
			
			System.out.println("Click add interview:");
			AssociateInfoTab.interviewAddbutton(d).click();
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to click on add interview");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^I select client interviewer$")
	public static boolean i_select_client_interviewer(WebDriver d) {
      try {
			
			System.out.println("select client in interview form");
			AssociateInfoTab.selectClientInterviewForm(d).sendKeys("Brillio");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to client in the interview form");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^I enter interview date$")
	public static boolean i_enter_interview_date(WebDriver d) {
     try {
            System.out.println("enter the date: ");
            
			AssociateInfoTab.InterviewSDate(d).sendKeys("01");
			AssociateInfoTab.InterviewSDate(d).sendKeys("12");
			AssociateInfoTab.InterviewSDate(d).sendKeys("2018");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to enter date");    	
		        
		    	return false;
		    	
		    }
	}

	@When("^I select interview type$")
	public static boolean i_select_interview_type(WebDriver d){
		
      try {
		    System.out.println("select interview type ");
		   //setting interview type
			AssociateInfoTab.InterviewType(d).sendKeys("Online");
			//setting interview feedback
			AssociateInfoTab.interviewFeedback(d).sendKeys("Good");
			return true;    
       }catch (Throwable e){
		        System.out.println("Failed to select the type of the interview");    	
		        
		    	return false;
		    	
		    }
	}

	@Then("^the interview is added$")
	public static boolean the_interview_is_added(WebDriver d){
        try {
			
			System.out.println("Click on the adding interview");
			AssociateInfoTab.submitInterviewButton(d).click();
			return true;    
           }catch (Throwable e){
		        System.out.println("Failed to click on adding an interview");    	
		        
		    	return false;
		    	
		    }
	}

	



}
