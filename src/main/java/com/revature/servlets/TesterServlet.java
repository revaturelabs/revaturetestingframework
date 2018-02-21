package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TesterServlet
 */
public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TesterServlet() {
        super();
    }
	
	public static XmlSuite createSuite(String which) {
		// create <suite name="AllTests">
		XmlSuite suite = new XmlSuite();
		suite.setName("SuiteOfAllTests");
		// create <test name="LoginTest">
		XmlTest test = new XmlTest(suite);
		test.setName("AllTests");
		// create <classes>
		List<XmlClass> classes = new ArrayList<XmlClass>();
		// create classes <class name="com.revature.tester.?">
		System.out.println("creating suite for: "+which);
		switch(which) {
		case "all":
			//doesnt work unless there's only 1 test in there
			System.out.println("adding all classes");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.AdminSuite"));
			//classes.add(new XmlClass("com.revature.test.admin.testclasses.HomeTest"));
			classes.add(new XmlClass("com.revature.test.admin.testclasses.ClientListTest"));
			classes.add(new XmlClass("com.revature.test.admin.testclasses.BatchListTest"));
			classes.add(new XmlClass("com.revature.test.admin.testclasses.AssociateListTest"));
			classes.add(new XmlClass("com.revature.test.admin.testclasses.CreateUserTest"));
			//classes.add(new XmlClass("com.revature.test.admin.testclasses.LoginTest"));
			break;
		case "1":
			System.out.println("Adding class 1");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.ClientListTest"));
			break;
		case "2":
			System.out.println("Adding class 2");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.BatchListTest"));
			break;
		case "3":
			System.out.println("Adding class 3");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.HomeTest"));
			break;
		case "4":
			System.out.println("Adding class 4");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.AssociateListTest"));
			break;
		case "5":
			System.out.println("Adding class 5");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.LoginTest"));
			break;
		case "6":
			System.out.println("Adding class 6");
			classes.add(new XmlClass("com.revature.test.admin.testclasses.CreateUserTest"));
			break;
		default:
			System.out.println("There is no test for this Switch Statement:" + which);
			break;
		}
		test.setXmlClasses(classes);
		return suite;
	}
	
	public static ResponseObject runTests(String whichToRun) {
		// testNG instance
	    TestNG testng = new TestNG();
	    // create list of suites to run
	    List<XmlSuite> suites = new ArrayList<XmlSuite>();
	    suites.add(createSuite(whichToRun));
	    // add suites to testNG
	    testng.setXmlSuites(suites);
	    // create and add test listener which will generate response object
	    ITestNGListener listener = new ListenerTest();
	    testng.addListener(listener);
	    testng.setUseDefaultListeners(false);
	    // programmatically run testNG!!
	    System.out.println("About to run TestNG");
	    testng.run();
	    // return the response object
	    return ((ListenerTest) listener).getResponseObject();
	}
	
	public ResponseObject getDummyData() {
		ResponseObject robj = new ResponseObject();
		robj.totalNumTests = 2;
		robj.numFailedTests = 1;
		robj.numSuccessfulTests = 1;
		List<TestObject> all = new ArrayList<TestObject>();
		List<TestObject> failures = new ArrayList<TestObject>();
		List<TestObject> successes = new ArrayList<TestObject>();
		TestObject fail = new TestObject(1,"first test","success","Class",null);
		TestObject pass = new TestObject(2,"second test","failure","Class",null);
		all.add(fail); all.add(pass);
		failures.add(fail);
		successes.add(pass);
		robj.allTests = all;
		robj.failedTests = failures;
		robj.successfulTests = successes;
		return robj;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// run the tests and get the object that will be returned as JSON
		String whichToRun = request.getParameter("group");
		System.out.println("Parameter: "+whichToRun);
		ResponseObject robj = runTests(whichToRun);
		//ResponseObject robj = getDummyData();
        // create Jackson mapper object
		ObjectMapper mapper = new ObjectMapper();
		// send json data back
		System.out.println("Returning test data...");
		response.setContentType("application/json");
		response.getWriter().write(mapper.writeValueAsString(robj));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
