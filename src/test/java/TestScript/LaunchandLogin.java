package TestScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageFactory.CommonObjects;
import PageFactory.LoginCommonObjects;

public class LaunchandLogin extends BaseClass {
	public static String parentwindow;
@Test
public void browseropen() {
	testcase = extentreport.createTest("Verify Shamil Self Service Title");
	String title = driver.getTitle();
	parentwindow = driver.getWindowHandle();
	if (title.equals("Shamil Self Service")) {
		System.out.println("Shamil Self Service login page present");
		testcase.log(Status.PASS, "Shamil Self Service Login Page Successfully Open");
	} else {
		System.out.println("Shamil Self Service login page not present");
		testcase.log(Status.FAIL, " Shamil Self Service Login Page Not Open");

	}
}
@Test
public void validlogin() throws IOException {

	testcase = extentreport.createTest("Valid Login TestCase");
	PageFactory.initElements(driver, LoginCommonObjects.class);
	PageFactory.initElements(driver, CommonObjects.class);
	LoginCommonObjects.compdd.click();
	testcase = extentreport.createTest("ESS Login");
	// testcase.log(Status.PASS, "Added successfully");
	if (LoginCommonObjects.etypeheader.getText().equalsIgnoreCase("Employee")) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		System.out.println(LoginCommonObjects.avc.size());
		for (int i = 0; i <= LoginCommonObjects.avc.size() - 1; i++) {
			if (LoginCommonObjects.avc.get(i).getText().contains("New Era Technology # 440099")) {
				LoginCommonObjects.avc.get(i).click();
				break;

			}

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginCommonObjects.Login();
		testcase.log(Status.PASS, "Logged in successfully");
	} else {
		System.out.println("Field not present or header name is changed");
	}

}}