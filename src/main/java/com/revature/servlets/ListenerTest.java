package com.revature.servlets;

import java.util.Collection;
import java.util.Iterator;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
 
public class ListenerTest implements ITestListener {
	private ResponseObject robj = new ResponseObject();
	
	public ResponseObject getResponseObject() {
		return robj;
	}
	
	private TestObject getTestObject(ITestResult result) {
		// utility method to generate a test object from the test results
		TestObject test = new TestObject();
		// set the ID of the test to the current total number of tests
		test.setId(robj.totalNumTests);
		test.setName(result.getName());
		test.setBelongsToClass(result.getTestClass().getName());
		test.setExceptionThrown(result.getThrowable());
		switch (result.getStatus()) {
		case ITestResult.CREATED:
			test.setStatus("created"); break;
		case ITestResult.SUCCESS:
			test.setStatus("success"); break;
		case ITestResult.FAILURE:
			test.setStatus("failure"); break;
		case ITestResult.SKIP:
			test.setStatus("skipped"); break;
		case ITestResult.STARTED:
			test.setStatus("started"); break;
			default: test.setStatus("unknown"); break;
		}
		return test;
	}
 
    @Override
    public void onTestStart(ITestResult result) {
    	robj.totalNumTests++;
    }
 
    @Override
    public void onTestSuccess(ITestResult result) {
    	robj.numSuccessfulTests++;
    	robj.successfulTests.add(getTestObject(result));
    	robj.allTests.add(getTestObject(result));
    }
 
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + ":" + result.getThrowable());
        robj.numFailedTests++;
        robj.failedTests.add(getTestObject(result));
        robj.allTests.add(getTestObject(result));
    }
 
    @Override
    public void onTestSkipped(ITestResult result) {
    	robj.totalNumTests++;
    	robj.numSkippedTests++;
    	robj.skippedTests.add(getTestObject(result));
    	robj.allTests.add(getTestObject(result));
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
 
    }
 
    @Override
    public void onStart(ITestContext context) {
    	System.out.println("starting...");
    }
 
    @Override
    public void onFinish(ITestContext context) {
    	IResultMap map = context.getFailedConfigurations();
    	Collection<ITestNGMethod> l = map.getAllMethods();
    	Iterator<ITestNGMethod> i = l.iterator();
    	while(i.hasNext()) {
    		ITestNGMethod itngm = i.next();
    		System.out.println("Configuration failed: "+itngm.getMethodName());
    	}
    }
}