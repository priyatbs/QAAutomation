package com.org.tbs.apitestingresutilities;

import java.io.File;
import java.io.IOException; 
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SetUp {
	public static WebDriver driver;
	public static Properties prop;
	public static JdbcTemplate jdbcTemplate;
	public static TakesScreenshot webdriver;
	public static String fileWithPath;
	

	public static void setProperties() {
		prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("config.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void extendReport(String testName,String testDesc) {
		 ExtentSparkReporter htmlReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/POS.html"));
		//create ExtentReports and attach reporter(s)
		  ExtentReports extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  ExtentTest test = extent.createTest(testName,testDesc);
		//creates a toggle for the given test, add all log events under it
		 
	}	
}