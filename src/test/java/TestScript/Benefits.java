package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Benefits extends BaseClass {
	@Test(priority = 1)
	public void benscript() {
		testcase = extentreport.createTest("Benefits");
		driver.findElement(By.xpath("//*[@id='Benefits']/a/span")).click();
	driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-benefits/div/span/div[2]/div/div")).getText();
		/* System.out.println(hdr.getText()); */
		//driver.quit();
		testcase.log(Status.PASS, "Benefits Shown Successfully");

	}

}
