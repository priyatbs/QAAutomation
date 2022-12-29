package tests;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Hamburgersidepage;
import utilities.Browsersetup;
import utilities.SetUp;

public class SideMenu extends Baseclass {
	public static final String expectedHeader = "Shamil Pos";
	public static final String ExpectedReprintHeader ="Reprint";
	public static final String ExpectedFavoriteHeader = "Favorite Items";
	public static final String ExpectedAvailableHeader = "Available Items";
	public static final String ExpectedFloatinHeader = "Float In";
	public static final String ExpectedFloatoutHeader = "Float Out";
	@Test
	public void Headerverify() throws IOException {
		testcase=extentreport.createTest("Verify Side menu");
		PageFactory.initElements(driver, Hamburgersidepage.class);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String header = Hamburgersidepage.Headername.getText();
		if (expectedHeader.equalsIgnoreCase(header))
			//System.out.println("The expected heading is same as actual heading --- " + header);
			testcase.log(Status.PASS,"The expected heading is same as actual heading --- " + header);
		else
			//System.out.println("The expected heading doesn't match the actual heading --- " + header);
			testcase.log(Status.FAIL," The expected heading doesn't match the actual heading ---" + header);

	}

	@Test
	public void Sidemenuaction() throws IOException {
		PageFactory.initElements(driver, Hamburgersidepage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("arguments[0].style.background='yellow'", Hamburgersidepage.Sidemenubar);
		if(Hamburgersidepage.Sidemenubar.isEnabled()) {
			Hamburgersidepage.Sidemenubar.click();
			for (WebElement element : Hamburgersidepage.listelements) {
				//System.out.println(element.getText());
				testcase.log(Status.PASS," Side menu options are "+element.getText());
			}
		}else
			//System.out.println("No such Hamburgerside icon is not present");
			testcase.log(Status.FAIL,"No such Hamburgerside icon is not present");
		
		takeScreenShot("HomePage");
	}

	@Test
	public void Favorite() throws IOException {
		for (WebElement element : Hamburgersidepage.listelements) {

			if (element.getText().equals("Favorite")) {
				element.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Hamburgersidepage.Tableview.isDisplayed();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				Assert.assertEquals(ExpectedFavoriteHeader, Hamburgersidepage.Tableheadername.getText());
				testcase.log(Status.PASS,"Header "+Hamburgersidepage.Tableheadername.getText());
				Hamburgersidepage.Closebutton.click();
				break;
			}
			testcase.log(Status.FAIL,"Header "+Hamburgersidepage.Tableheadername.getText());
		}
	}

	@Test
	public void Available() throws IOException {
		for (WebElement element : Hamburgersidepage.listelements) {
			if (element.getText().equals("Available")) {
				element.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Hamburgersidepage.Tableview.isDisplayed();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				Assert.assertEquals(ExpectedAvailableHeader, Hamburgersidepage.Tableheadername.getText());
				testcase.log(Status.PASS,"Header "+Hamburgersidepage.Tableheadername.getText());
				Hamburgersidepage.Closebutton.click();
				break;
			}
			testcase.log(Status.FAIL,"Header "+Hamburgersidepage.Tableheadername.getText());
		}
	}

	@Test
	public void FloatIn() throws IOException {
		for (WebElement element : Hamburgersidepage.listelements) {
			if (element.getText().equals("Float In")) {
				element.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Hamburgersidepage.Tableview.isDisplayed();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				Assert.assertEquals(ExpectedFloatinHeader, Hamburgersidepage.Tableheadername.getText());
				testcase.log(Status.PASS,"Header "+Hamburgersidepage.Tableheadername.getText());
				Hamburgersidepage.Closebutton.click();
				break;
			}
				testcase.log(Status.FAIL,"Header "+Hamburgersidepage.Tableheadername.getText());
		}
	}

	@Test
	public void FloatOut() throws IOException {
		for (WebElement element : Hamburgersidepage.listelements) {
			if (element.getText().equals("Float Out")) {
				element.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Hamburgersidepage.Tableview.isDisplayed();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				Assert.assertEquals(ExpectedFloatoutHeader, Hamburgersidepage.Tableheadername.getText());
				testcase.log(Status.PASS,"Header "+Hamburgersidepage.Tableheadername.getText());
				Hamburgersidepage.Closebutton.click();
				break;
			}
			testcase.log(Status.FAIL,"Header "+Hamburgersidepage.Tableheadername.getText());
		}
	}

	@Test
	public void Reprint() throws IOException {	
	for(WebElement element : Hamburgersidepage.listelements){
	   if (element.getText().equals("Reprint")){
	    	element.click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	Hamburgersidepage.Tableview.isDisplayed();
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      	
	    	Assert.assertEquals(ExpectedReprintHeader, Hamburgersidepage.Tableheadername.getText());
	    	testcase.log(Status.PASS,"Header "+Hamburgersidepage.Tableheadername.getText());
	    	Hamburgersidepage.Closebutton.click();
	    	break;
		}	
	   		testcase.log(Status.FAIL,"Header "+Hamburgersidepage.Tableheadername.getText());
		}
		
	}
}