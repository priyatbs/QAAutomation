package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Goals extends BaseClass {
	@Test(priority =1)
	public void goalscript() throws InterruptedException {
		testcase =extentreport.createTest("Goals");
		driver.findElement(By.xpath("/html/body/app-root/app-main/div/app-menu/div/p-scrollpanel/div/div[1]/div/div/ul/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-goals/form/div/span/div[3]/div/div/div/div[1]/span/p-dropdown/div/span")).click();
	    driver.findElement(By.xpath("//*[@id='Gol_Ddn_GoalCategory']/div/div[3]/div/ul/p-dropdownitem/li/span")).click();
	    driver.findElement(By.xpath("//*[@id='Gol_Cal_StartDate']/span/input")).click();
	    driver.findElement(By.xpath("//*[@id='Gol_Cal_StartDate']/span/div/div/div/div[2]/table/tbody/tr[3]/td[4]/span")).click();
	    driver.findElement(By.xpath("//*[@id='Gol_Cal_DueDate']/span/input")).click();
	    driver.findElement(By.xpath("//*[@id='Gol_Cal_DueDate']/span/div/div/div/div[2]/table/tbody/tr[5]/td[3]/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/app-root/app-main/div/div[1]/div/app-goals/form/div/span/div[3]/div/div/div/div[5]/span/p-dropdown/div/span")).click();
	    driver.findElement(By.xpath("//*[@id='Gol_Ddn_GoalCode']/div/div[3]/div/ul/p-dropdownitem/li")).click();
	    driver.findElement(By.id("Gol_Txt_purpose")).sendKeys("test");
	    Thread.sleep(100);
	    driver.findElement(By.id("Gol_Btn_Submit")).click();
        testcase.log(Status.PASS, "Goals Registered Successfully");
}
}