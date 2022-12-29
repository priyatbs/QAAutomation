package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Location extends Baseclass{
	@Test(priority =1)
	public void locsrcipt() {
		testcase = extentreport.createTest("Location");
		WebElement lopn = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[5]/a"));
		lopn.click();
		WebElement lhdr = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-location/div/div/div"));
	    System.out.println(lhdr.getText());
	    if(lhdr.getText().equalsIgnoreCase("Location")) {
	    	System.out.println("Page is present");
	    	testcase.log(Status.PASS, "Location services are accessible");
	    }
	}

}
