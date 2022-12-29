package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class WhatsNew extends Baseclass{
	@Test(priority =1)
	public void newscript() throws InterruptedException {
		//Thread.sleep(5000);
		testcase = extentreport.createTest("What's New");
		WebElement newopn = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[6]/a/span[1]/img"));
		newopn.click();
		WebElement newhdr = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-whats-new/div/div[1]"));
		System.out.println(newhdr.getText());
		if(newhdr.getText().equalsIgnoreCase("What's New")) {
			System.out.println("Page is present");
		}testcase.log(Status.PASS, "What's New page is displayed successfully");
	}


}
