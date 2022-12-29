package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Assets extends BaseClass {
	@Test(priority = 1)
	public void Assetscript() throws InterruptedException {
		testcase = extentreport.createTest("Assets");
		driver.findElement(
				By.xpath("/html/body/app-root/app-main/div/app-menu/div/p-scrollpanel/div/div[1]/div/div/ul/li[8]/a"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html/body/app-root/app-main/div/div[1]/div/app-assets/div/form/span/div[2]/div/div/div/div[1]/span/p-dropdown/div/span"))
				.click();
		driver.findElement(By.xpath("//*[@id='Ast_Ddn_TypeofAsset']/div/div[3]/div/ul/p-dropdownitem/li")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html/body/app-root/app-main/div/div[1]/div/app-assets/div/form/span/div[2]/div/div/div/div[2]/span/p-dropdown/div/span"))
				.click();
		driver.findElement(By.xpath("//*[@id='Ast_Ddn_Assets']/div/div[3]/div/ul/p-dropdownitem[1]/li/span")).click();
		driver.findElement(By.xpath("//*[@id='Ast_Cal_Expectedreceiveddate']/span/input")).click();
		driver.findElement(By
				.xpath("//*[@id='Ast_Cal_Expectedreceiveddate']/span/div/div/div/div[2]/table/tbody/tr[3]/td[3]/span"))
				.click();
		driver.findElement(By.xpath("//*[@id='Ast_Cal_Expectedreturndate']/span/input")).click();
		driver.findElement(
				By.xpath("//*[@id='Ast_Cal_Expectedreturndate']/span/div/div/div/div[2]/table/tbody/tr[5]/td[3]/span"))
				.click();
		driver.findElement(By.id("Ast_Txt_Purpose")).sendKeys("test");
		driver.findElement(By.id("Ast_Btn_Submit")).click();
		testcase.log(Status.PASS, "Assets Registered Successfully");

	}

}
