package TestScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class Transfer extends BaseClass
{
	
	 // @Test
		/*
		 * public void Transfer() { WebElement reqdropdwn =
		 * driver.findElement(By.xpath("//*[@id='Request']")); reqdropdwn.click();
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,500)"); List<WebElement> allOptions =
		 * driver.findElements(By.xpath("//*[@id='Request']/ul/li/a"));
		 * System.out.println(allOptions.size()); for (int i = 0; i <= allOptions.size()
		 * - 1; i++) { if (allOptions.get(i).getText().contains("Transfer")) {
		 * allOptions.get(i).click(); break; } else {
		 * System.out.println("No Transfer request is present"); } } }
		 */

	@Test(priority = 1)
	public void Transferreq() throws InterruptedException {
		testcase = extentreport.createTest("Transfer Apply");
		
		
		  WebElement requestclk =
		  driver.findElement(By.xpath("//div[@class='menu-scroll-content']/ul/li[3]"));
		  requestclk.click();
		  driver.findElement(By.xpath("//*[@id='Transfer ']")).click();
		  Thread.sleep(1000);
		 
		WebElement type = driver.findElement(By.xpath("//*[@id='Req_TR_Ddn_Type']/div/span"));
		  Thread.sleep(1000);
		type.click();
		List<WebElement> typesel = driver
				.findElements(By.xpath("//*[@id='Req_TR_Ddn_Type']/div/div[3]/div[2]/ul/p-dropdownitem"));
		System.out.println(typesel.size());
		for (int i = 0; i <= typesel.size() - 1; i++) {
			if (typesel.get(i).getText().contains("Within Branch")) {
				typesel.get(i).click();
				break;
			} else {
				System.out.println("No type is present");
			}

		}
		WebElement dept = driver.findElement(By.xpath("//*[@id='Req_TR_Ddn_Department']/span/input"));
		dept.sendKeys("test");
		WebElement org = driver.findElement(By.xpath("//*[@id='Req_TR_Ddn_Organization']/span/input"));
		org.sendKeys("swidy");
		WebElement costcenter = driver.findElement(By.xpath("//*[@id='Req_TR_Ddn_CostCenter']/span/input"));
		costcenter.sendKeys("CC 222");
		WebElement date = driver.findElement(By.xpath("//*[@id='Req_TR_Cal_Date']/span/input"));
		date.sendKeys("28/10/2022");
		WebElement desc = driver.findElement(By.xpath("//*[@id='Req_TR_Txt_HedaerDesc']"));
		desc.sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='Req_TR_Btn_Submit']")).click();
		testcase.log(Status.PASS,"Transfer Applied Successfully");

	}
}



