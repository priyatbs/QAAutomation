package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Logo extends Baseclass {
	
	@Test(priority =1)
	public void log() throws InterruptedException {
		testcase = extentreport.createTest("Logo");
		Thread.sleep(1500);
		WebElement elhdr =driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div[1]/img"));
		System.out.println(elhdr.getText());
		testcase.log(Status.INFO, "Home Page is displayed");
		testcase.log(Status.INFO, "Checking logo");
		if(elhdr.isDisplayed()) {
			System.out.println("script passed");
			driver.quit();
			testcase.log(Status.PASS, "Logo is Present");
		}
		else {System.out.println("Script failed");
		testcase.log(Status.FAIL, "Logo is not Present");
		
		
	}

}}
