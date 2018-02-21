package com.revature.servlets;

import java.util.ArrayList;
import java.util.List;

public class ResponseObject {
	public int totalNumTests = 0;
	public int numSuccessfulTests = 0;
	public int numFailedTests = 0;
	public int numSkippedTests = 0;
	
	public List<TestObject> allTests = new ArrayList<TestObject>();
	public List<TestObject> successfulTests = new ArrayList<TestObject>();
	public List<TestObject> failedTests = new ArrayList<TestObject>();
	public List<TestObject> skippedTests = new ArrayList<TestObject>();
	
	@Override
	public String toString() {
		return "ResponseObject [totalNumTests=" + totalNumTests + ", numSuccessfulTests=" + numSuccessfulTests
				+ ", numFailedTests=" + numFailedTests + ", numSkippedTests=" + numSkippedTests + ", allTests="
				+ allTests + ", successfulTests=" + successfulTests + ", failedTests=" + failedTests + ", skippedTests="
				+ skippedTests + "]";
	}
	
	
}
