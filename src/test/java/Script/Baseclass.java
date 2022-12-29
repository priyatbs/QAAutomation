package Script;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.BrowserOpen;

public class Baseclass extends BrowserOpen {
	public static ExtentTest testcase;
	public static ExtentReports extentreport;
	public static ExtentSparkReporter report;
	@BeforeSuite
	public void reportSetup() {
	
		extentreport = new ExtentReports();
		report = new ExtentSparkReporter("reports.html");
		extentreport.attachReporter(report);
	}
	//C:\\Users\\Admin\\Desktop\\POS\\
	
	@BeforeTest
	public static void setup() throws IOException {
		configfileread();
		BrowserOpen.StartBrowser();
		
		
		}
	
@AfterTest
public void reportgeneration() {
	extentreport.flush();
}}
