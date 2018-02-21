package com.revature.tester;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/resources/profile.feature")
public class ProfileTester extends AbstractTestNGCucumberTests {

}
