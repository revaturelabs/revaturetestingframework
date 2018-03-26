package com.revature.test.admin.testclasses;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.test.admin.pom.HomeTab;
import com.revature.test.admin.pom.Login;
import com.revature.test.utils.TestConfig;

public class LoginTest extends AdminSuite {

	@BeforeTest
	public void beforeTest() {
		System.out.println("============ Initializing Login Tests ===============");
		System.out.println("");
	}

	@Test(priority = 1)
	public void IndexPage() {
		try {
			assertNotEquals(Login.getCurrentURL(wd), TestConfig.getBaseURL() + "/#/TrackForce/login" );
			
		} catch (Throwable e) {
			fail("Failed to Login.");
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("============ Login Tests finished ===============");
	}

}