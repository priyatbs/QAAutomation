/*
 * @ScriptName : RestAssured Api testing Integration 
 * @Description : API Testing using selenium
 * @author Priyadarshini
 * @Created On : 21/12/2022
 * @Version : 0.1
 */


package com.org.tbs.apitestingresassured;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.org.tbs.apitestingresutilities.SetUp;



public class baseClass extends SetUp {
	public static ExtentTest testcase;
	public static ExtentReports extentreport;
	public static ExtentSparkReporter report;

	@BeforeSuite
	public void reportSetup() {
	
		extentreport = new ExtentReports();
		report = new ExtentSparkReporter("reports.html");
		extentreport.attachReporter(report);
	}
	
	@AfterTest
	public void reportgeneration() {
		extentreport.flush();
	}

}
