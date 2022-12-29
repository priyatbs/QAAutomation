package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Leave extends BaseClass {

	@Test(priority = 1)
	public void leavereq() throws InterruptedException {

		WebElement request = driver.findElement(By.xpath("//*[@id='Request']"));
		request.click();
		WebElement leave = driver.findElement(By.xpath("//*[@id=\"Leave \"]"));
		leave.click();
		Thread.sleep(2000);
		WebElement substitute = driver.findElement(By.xpath(
				"/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[1]/span/p-dropdown/div/div[2]"));

		substitute.click();
		 driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[1]/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[1]/li/span")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='Req_LR_Ddn_Type']/div/span")).click();
		 WebElement leavetype = driver.findElement(By.xpath("//*[@id='Req_LR_Ddn_Type']/div/div[3]/div[2]/ul/p-dropdownitem[1]/li"));
		 leavetype.click();
		 WebElement reentry = driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[4]/span/p-dropdown/div/span"));
		 reentry.click();
		 WebElement no = driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[4]/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[1]/li"));
		 no.click();
		 WebElement sdate = driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[10]/span/p-calendar/span/input"));
		 sdate.click();
		 WebElement ds = driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[10]/span/p-calendar/span/div/div/div/div[2]/table/tbody/tr[3]/td[3]/span"));
		 ds.click();
		 WebElement edate = driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[11]/span/p-calendar/span/input"));
		 edate.click();
		 WebElement de = driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-leave/div/form/span/div[2]/div/div/div/div[11]/span/p-calendar/span/div/div/div/div[2]/table/tbody/tr[5]/td[6]/span"));
		 de.click();
		 WebElement notes = driver.findElement(By.xpath("//*[@id='Req_LR_Txt_Notes']"));
		 notes.sendKeys("Sick");	
		 driver.findElement(By.xpath("//*[@id='Req_LR_Btn_Submit']/span")).click();
	}

}
