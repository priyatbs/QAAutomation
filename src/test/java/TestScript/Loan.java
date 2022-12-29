package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Loan extends BaseClass {
	@Test
	public void loanscript() {
		testcase = extentreport.createTest("Leave Apply");

		WebElement requestclk = driver.findElement(By.xpath("//div[@class='menu-scroll-content']/ul/li[3]"));
		requestclk.click();
		WebElement loanoptnselect = driver
				.findElement(By.xpath("//div[@class='menu-scroll-content']/ul/li[3]/ul/li[5]"));
		loanoptnselect.click();
		WebElement amnt = driver.findElement(By.xpath("//div[@class='card']/div[1]/div[2]/input"));
		amnt.sendKeys("100");
		WebElement installment = driver.findElement(By.xpath("//div[@class='card']/div[1]/div[3]/input"));
		installment.sendKeys("2");
		WebElement purpose = driver.findElement(By.xpath("//div[@class='card']/div[2]/div/textarea"));
		purpose.sendKeys("testdata");
		WebElement submitbtn = driver.findElement(By.xpath("//div[@class='header']/div[2]/button[2]/span"));
		submitbtn.click();
		  testcase.log(Status.PASS,"Leave applied Successfully");
		
	}

}
