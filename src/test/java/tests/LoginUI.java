package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Hamburgersidepage;
import pagefactory.Loginpage;

public class LoginUI extends Baseclass{
	
	@Test
	public void logocheck() {
		testcase =extentreport.createTest("Image and Language verify in Logine page");
		WebElement imageverify = driver
				.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[1]/form/div[1]/img"));
		Boolean img = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0",
				imageverify);
		if (img) {
			//System.out.println("Al-Shamil logo present in login screen");
			testcase.log(Status.PASS," Al-Shamil logo present in login screen");
		} else {
			//System.out.println("Al-Shamil logo is not present in login screen");
			testcase.log(Status.FAIL,"Al-Shamil logo is not present/not match in login screen");
		}
	}

	@Test
	public void languagecheck() {
		testcase = extentreport.createTest("Verify Language Change Option in POS Login Page");

		WebElement globalsymbol = driver.findElement(By.xpath("//div[@class='content-center']/a/img"));
		Boolean img = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0",
				globalsymbol);

		if (img) {
			System.out.println("Language change option is present in login screen");
			testcase.log(Status.PASS, " Language change option is present in login screen");
			globalsymbol.click();
			WebElement englishswitchsymbol=driver.findElement(By.xpath("//div[@class='content-center']/a/img[@src='assets/images/en.png']"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(englishswitchsymbol.isDisplayed()) {
				System.out.println("Login screen changed to Arabic language");
				testcase.log(Status.PASS, "Login screen changed to Arabic language");
				englishswitchsymbol.click();
		
				if(globalsymbol.isDisplayed()) {
					System.out.println("Login screen changed to English language");
					testcase.log(Status.PASS, "Login screen changed to English language");
				}
			}
			
			
			
		} else {
			System.out.println("Language change option is not present in login screen");
			testcase.log(Status.FAIL, " Language change option is not present in login screen");
		}

		
		
	}

	
}
