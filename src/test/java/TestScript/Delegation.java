package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Delegation extends BaseClass {
	@Test(priority = 1)
	public void delescript() throws InterruptedException {
		testcase =extentreport.createTest("Delegation");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-main/div/app-menu/div/p-scrollpanel/div/div[1]/div/div/ul/li[6]/a")).click();
		//*[@id="Delegation"]/a
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-deligation/form/div/span/div[2]/div/div/div/div[1]/span/p-dropdown/div/span")).click();
		driver.findElement(By.xpath("//*[@id='Del_Ddn_delegatee']/div/div[3]/div/ul/p-dropdownitem[1]/li")).click();
		driver.findElement(By.xpath("//*[@id='Del_cal_FromDate']/span/input")).click();
		driver.findElement(By.xpath("//*[@id='Del_cal_FromDate']/span/div/div/div/div[2]/table/tbody/tr[3]/td[4]/span")).click();
		driver.findElement(By.xpath("//*[@id='Del_cal_ToDate']/span/input")).click();
		driver.findElement(By.xpath("//*[@id='Del_cal_ToDate']/span/div/div/div/div[2]/table/tbody/tr[5]/td[3]/span")).click();
		driver.findElement(By.id("Del_Txt_Notes")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.id("Del_Btn_Submit")).click();
		testcase.log(Status.PASS,"Delegation Applied Successfully");
		//testcase.log(Status.PASS, "Delegation Applied Successfully");
	}

}
