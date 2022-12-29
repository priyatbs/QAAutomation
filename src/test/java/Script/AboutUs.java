package Script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class AboutUs extends Baseclass{
@Test(priority =1)	
	public void abscript(){
	
	testcase = extentreport.createTest("About Us");

	WebElement aboptn = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div[1]/div/div[2]/p-menu/div/ul/li[3]/a"));
	aboptn.click();
	WebElement abhdr = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-about-us/div/div[1]/div"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println(abhdr.getText());
	if(abhdr.getText().equalsIgnoreCase("About Us")) {
		System.out.println("About Us page is present");
		testcase.log(Status.PASS, "About Us Page is displayed Successfully");
	}
		
	}
	

}
