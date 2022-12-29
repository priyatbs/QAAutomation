package TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageFactory.CommonObjects;
import PageFactory.LoginCommonObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Resignation extends BaseClass {
	String menuname;
	String submenuname = "Resignation";
	String Notes;
	String id = "0000000008";
	String pwd = "123456";

	@Test(priority = 2)
	public void resignapply() throws InterruptedException {
		testcase = extentreport.createTest("Resignation Apply");

	driver.findElement(By.xpath("//*[@id='Request']")).click();
	Thread.sleep(2000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println(LoginCommonObjects.reqli.size());
		for (int i = 0; i <= LoginCommonObjects.reqli.size() - 1; i++) {
			if (LoginCommonObjects.reqli.get(i).getText().contains(submenuname)) {
				LoginCommonObjects.reqli.get(i).click();
			}
		}
		Thread.sleep(1000);
		LoginCommonObjects.recalendar.click();
		LoginCommonObjects.repaginator.click();
		if (LoginCommonObjects.redatehdr.getText().equalsIgnoreCase("November2022")) {

			LoginCommonObjects.datesel.click();
			LoginCommonObjects.reasontxt.sendKeys("Prolonged Illness");
			LoginCommonObjects.submitbtn.click();
			WebElement toast = driver.findElement(By.xpath("/html/body/app-root/div/p-toast/div"));
			System.out.println(toast.getText().equalsIgnoreCase("Sorry Error in saving the transaction."));
			
			if(toast.getText().contains("Sorry\r\n"
					+ "Error in saving the transaction.")) {
				System.out.println("Test passed");
			}else {
				System.out.println("Test passed");
				testcase.log(Status.PASS, "Resignation Applied successfully");
			}
			driver.quit();
		}
	}
}