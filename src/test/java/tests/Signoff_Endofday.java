package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.SignoffPage;

public class Signoff_Endofday extends Baseclass {

	@Test
	public void logoff() {
		Login obj=new Login();
		testcase = extentreport.createTest("Signoff_Endofday Testcases");
		PageFactory.initElements(driver, SignoffPage.class);
		if(SignoffPage.signoffintopbar.isDisplayed()) {
			System.out.println("Signoff menu is present in top bar of the application");
			testcase.log(Status.INFO, "Signoff menu is present in top bar of the application");
			SignoffPage.signoffintopbar.click();
			SignoffPage.signoffclick.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(SignoffPage.signoffpopup.isDisplayed()) {
				System.out.println("Signoff pop up is present");
				testcase.log(Status.INFO, "Signoff pop up is present");
				SignoffPage.signoffyes.click();
				obj.endoftheday();
				testcase.log(Status.PASS, "Signoff_Endofday passed");
				
			}
			
		}
		
	}

	
	
}
