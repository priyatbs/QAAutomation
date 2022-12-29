package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class ForgotPassword extends Baseclass{
	@Test(priority = 0)
	public void forget() throws InterruptedException {
		testcase = extentreport.createTest("Forgot Password");
	
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div[3]/form/div[5]/a")).click();
		WebElement fphdr = driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div/div/div[2]/div[2]/label"));
		WebElement nid = driver.findElement(By.xpath("//*[@id='NationalId']"));
		WebElement mobno = driver.findElement(By.xpath("//*[@id='mobile']"));
		WebElement ped = driver.findElement(By.id("password"));
		WebElement cpwd = driver.findElement(By.id("confirmPassword"));
		WebElement regbtn = driver.findElement(By.xpath("//*[@id='submit']"));
		System.out.println(fphdr.getText());
		if(fphdr.getText().equalsIgnoreCase("Forgot Password")) {
			nid.sendKeys("1735323196"); 
			ped.sendKeys("123456");
			  cpwd.sendKeys("123456"); 
			  mobno.sendKeys("8597413358");
			  regbtn.click(); 
			  testcase.log(Status.PASS,"Password has been Reset Successfully");
		}
		
	}}

//}
