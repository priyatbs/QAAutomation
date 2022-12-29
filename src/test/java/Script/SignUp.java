package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SignUp extends Baseclass {

	@Test(priority = 0)
	public void signscript() throws InterruptedException {

		testcase = extentreport.createTest("Signup");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div[3]/form/div[7]/label/a"))
				.click();
		WebElement radio2 = driver.findElement(By.xpath(
				"/html/body/app-root/app-registration/div/div/div/div[2]/div[3]/div[2]/p-radiobutton/div/div[2]"));
		WebElement radio1 = driver.findElement(By.xpath(
				"/html/body/app-root/app-registration/div/div/div/div[2]/div[3]/div[1]/p-radiobutton/div/div[2]"));
		WebElement nid = driver.findElement(By.xpath("//*[@id='NationalId']")); // *[@id="NationalId"]
		WebElement ped = driver.findElement(By.xpath("//*[@id='Password']")); //*[@id="password"]
		WebElement cpwd = driver.findElement(By.xpath("//*[@id='confirmPassword']"));
		WebElement mobno = driver.findElement(By.xpath("//*[@id='mobile']"));
		WebElement mail = driver.findElement(By.xpath("//*[@id='email']"));
		WebElement regbtn = driver.findElement(By.xpath("//*[@id='submit']"));

		Thread.sleep(1000);
		WebElement signhdr = driver
				.findElement(By.xpath("/html/body/app-root/app-registration/div/div/div/div[2]/div[2]"));

		System.out.println(signhdr.getText());
		if (signhdr.getText().equalsIgnoreCase("Sign Up")) {
			System.out.println("Sign Up page is present");
			
			  radio1.click(); nid.sendKeys("1735323196"); ped.sendKeys("123456");
			  cpwd.sendKeys("123456"); mobno.sendKeys("8597413358");
			  mail.sendKeys("test@gmail.com"); regbtn.click(); testcase.log(Status.PASS,
			  "Signup for Existing Patient Completed Successfully");
			  driver.findElement(By.xpath(
			  "/html/body/app-root/p-dialog/div/div/div[1]/div/button/span[1]")).click();
			  //Thread.sleep(2000);
			  testcase.log(Status.PASS,"Signup for New Patient Completed Successfully");
			 
				/*
				 * radio2.click(); Thread.sleep(5000); WebElement fname =
				 * driver.findElement(By.xpath("//*[@id='First']")); WebElement famname =
				 * driver.findElement(By.xpath("//*[@id='family']")); WebElement gmale =
				 * driver.findElement( By.xpath(
				 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[4]/form/div[4]/div/div[2]"
				 * )); WebElement dob = driver.findElement(By.xpath(
				 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[4]/form/div[5]/div/div[2]/p-radiobutton/div/div[2]"
				 * )); WebElement datedd =
				 * driver.findElement(By.xpath("//*[@id='gregorianDate']/div/span")); WebElement
				 * mondd = driver.findElement(By.xpath("//*[@id='gregorianMonth']/div/span"));
				 * WebElement yrdd =
				 * driver.findElement(By.xpath("//*[@id='gregorianYear']/div/span")); WebElement
				 * day = driver .findElement(By.xpath(
				 * "//*[@id='gregorianDate']/div/div[3]/div[2]/ul/p-dropdownitem[2]/li"));
				 * WebElement month = driver .findElement(By.xpath(
				 * "//*[@id='gregorianMonth']/div/div[3]/div[2]/ul/p-dropdownitem[2]/li"));
				 * WebElement year = driver .findElement(By.xpath(
				 * "//*[@id='gregorianYear']/div/div[3]/div[2]/ul/p-dropdownitem[4]/li"));
				 * 
				 * Thread.sleep(5000); driver.findElement( By.xpath(
				 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[4]/form/div[1]/span/input"
				 * )) .sendKeys("1735323196"); fname.sendKeys("Ismail");
				 * famname.sendKeys("Basha"); gmale.click(); dob.click(); datedd.click();
				 * day.click(); mondd.click(); month.click(); yrdd.click(); year.click();
				 * ped.sendKeys("123456"); cpwd.sendKeys("123456");
				 * mobno.sendKeys("8597413358"); mail.sendKeys("test@gmail.com");
				 * regbtn.click(); testcase.log(Status.PASS,
				 * "Signup for New Patient Completed Successfully");
				 */

		}
	}
}

/*
 * @Test(priority =1) public void npatnt() { WebElement radio2 =
 * driver.findElement(By.xpath(
 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[3]/div[2]/p-radiobutton/div/div[2]"
 * )); WebElement radio1 = driver.findElement(By.xpath(
 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[3]/div[1]/p-radiobutton/div/div[2]"
 * )); WebElement nid = driver.findElement(By.xpath("//*[@id='NationalId']"));
 * WebElement ped = driver.findElement(By.xpath("//*[@id='Password']"));
 * WebElement cpwd = driver.findElement(By.xpath("//*[@id='confirmPassword']"));
 * WebElement mobno = driver.findElement(By.xpath("//*[@id='mobile']"));
 * WebElement mail = driver.findElement(By.xpath("//*[@id='email']"));
 * WebElement regbtn = driver.findElement(By.xpath("//*[@id='submit']"));
 * 
 * 
 * WebElement fname = driver.findElement(By.xpath("//*[@id='First']"));
 * WebElement famname = driver.findElement(By.xpath("//*[@id='family']"));
 * WebElement gmale = driver.findElement(By.xpath(
 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[4]/form/div[4]/div/div[2]"
 * )); WebElement dob = driver.findElement(By.xpath(
 * "/html/body/app-root/app-registration/div/div/div/div[2]/div[4]/form/div[5]/div/div[2]/p-radiobutton/div/div[2]"
 * )); WebElement datedd =
 * driver.findElement(By.xpath("//*[@id='gregorianDate']/div/span")); WebElement
 * mondd = driver.findElement(By.xpath("//*[@id='gregorianMonth']/div/span"));
 * WebElement yrdd =
 * driver.findElement(By.xpath("//*[@id='gregorianYear']/div/span")); WebElement
 * day = driver.findElement(By.xpath(
 * "//*[@id='gregorianDate']/div/div[3]/div[2]/ul/p-dropdownitem[2]/li"));
 * WebElement month = driver.findElement(By.xpath(
 * "//*[@id='gregorianMonth']/div/div[3]/div[2]/ul/p-dropdownitem[2]/li"));
 * WebElement year = driver.findElement(By.xpath(
 * "//*[@id='gregorianYear']/div/div[3]/div[2]/ul/p-dropdownitem[4]/li"));
 * 
 * driver.findElement(By.xpath(
 * "/html/body/app-root/app-login/div/div/div/div[2]/div[3]/form/div[7]/label/a"
 * )).click(); radio2.click(); nid.sendKeys("1735323196");
 * fname.sendKeys("Ismail"); famname.sendKeys("Basha"); gmale.click();
 * dob.click(); datedd.click(); day.click(); mondd.click(); month.click();
 * yrdd.click(); year.click(); ped.sendKeys("123456"); cpwd.sendKeys("123456");
 * mobno.sendKeys("8597413358"); mail.sendKeys("test@gmail.com");
 * regbtn.click(); testcase.log(Status.PASS,
 * "Signup for New Patient Completed Successfully");
 * 
 * 
 * }
 * 
 * }
 * 
 * 
 */