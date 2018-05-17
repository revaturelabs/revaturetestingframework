package com.revature.test.admin.testclasses;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.test.admin.cukes.AssociateInfoCukes;
import com.revature.test.admin.pom.AssociateInfoTab;

public class AssociateInfoTest extends AdminSuite{
    
	@BeforeTest
	public void NavigateToAssociateListTab() {
		System.out.println("============ Initializing Associate Info Tests ===============");
		try {
			
			assertTrue(AssociateInfoCukes.i_am_in_the_associate_List_page(wd));
			assertTrue(AssociateInfoCukes.i_click_on_the_assocaite_id(wd));
		} catch (Throwable e) {
			fail("Error: Failed to navigate to Associate List tab");
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void insertAssociateInfoPage() {
		System.out.println("Associate info page test");
		try {
		assertTrue(AssociateInfoCukes.i_am_in_the_associate_info_page(wd));
		
		
		
		}catch(Throwable e) {
			fail("Error: Failed to get Associate info");
			e.printStackTrace();
		}
	}
	/**
	 * assert the fields of the associate in the associate list page with associate info page
	 */
	@Test(priority=2)
	public void assertAssociateInfo() {
		assertEquals(AssociateInfoTab.associate.getFirstName(), AssociateInfoTab.getAssociateFirstName(wd).getText());
		assertEquals(AssociateInfoTab.associate.getLastName(), AssociateInfoTab.getAssociateLastName(wd).getText());
		assertEquals(AssociateInfoTab.associate.getBatchName(), AssociateInfoTab.getAssociatebatchName(wd).getText());
		assertEquals(AssociateInfoTab.associate.getMarketStatus(), AssociateInfoTab.getAssociateMarketingStatus(wd).getText());
	}
	@Test(priority=3)
	public void updateAssociateInfo() {
		assertTrue(AssociateInfoCukes.i_check_associate_mapped(wd));
		assertTrue(AssociateInfoCukes.check_associate_eligible_for_an_interview(wd));
		assertTrue(AssociateInfoCukes.check_associate_scheduled_for_an_interview(wd));
		assertTrue(AssociateInfoCukes.check_associate_cleared_all_interviews(wd));
		assertTrue(AssociateInfoCukes.check_email_been_received_from_the_client(wd));
		assertTrue(AssociateInfoCukes.check_associate_passed_a_background_check(wd));
		assertTrue(AssociateInfoCukes.check_associate_have_a_start_date(wd));
		assertTrue(AssociateInfoCukes.associate_info_succefully_updated(wd));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test(priority=4)
	public void statusUpdateAssociateInfo() {
		assertTrue(AssociateInfoCukes.i_select_a_status_and(wd));
		assertTrue(AssociateInfoCukes.i_assign_a_client(wd));
		assertTrue(AssociateInfoCukes.i_apply_starting_date(wd));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test(priority=5)
	public void addInterviewInfo() {
		assertTrue(AssociateInfoCukes.click_on_Toggle_create_new_Interview_form(wd));
		assertTrue(AssociateInfoCukes.i_select_client_interviewer(wd));
		assertTrue(AssociateInfoCukes.i_enter_interview_date(wd));
		assertTrue(AssociateInfoCukes.i_select_interview_type(wd));
		
	}
	
}
