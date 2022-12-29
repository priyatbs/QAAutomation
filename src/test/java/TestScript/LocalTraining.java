package TestScript;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LocalTraining extends BaseClass {

	@Test(priority =1)
	public void LTrequest() {
		testcase = extentreport.createTest("Local Training Apply");
		WebElement requestclk = driver.findElement(By.xpath("//div[@class='menu-scroll-content']/ul/li[3]"));
		requestclk.click();
		WebElement ltr = driver.findElement(By.xpath("//*[@id=\"Local Training \"]"));
		ltr.click();
		WebElement traintitle = driver.findElement(By.xpath("//*[@id='Req_LTR_Txt_Title']"));
		traintitle.sendKeys("Test");
		WebElement startdate = driver.findElement(By.xpath("//*[@id='Req_LTR_Cal_StartDate']/span/input"));
		startdate.sendKeys("28/10/2022");
		WebElement enddate = driver.findElement(By.xpath("//*[@id='Req_LTR_Cal_EndDate']/span/input"));
		enddate.sendKeys("30/10/2022");
		WebElement Trainingplace = driver.findElement(By.xpath("//*[@id='Req_LTR_Cal_EndDate']/span/input"));
		Trainingplace.sendKeys("Coimbatore");
		WebElement Trainingcost = driver.findElement(By.xpath("//*[@id='Req_LTR_Cal_EndDate']/span/input"));
		Trainingcost.sendKeys("100");
		WebElement notes = driver.findElement(By.xpath("//*[@id='Req_LTR_Cal_EndDate']/span/input"));
		notes.sendKeys("Testing");
		WebElement submit = driver.findElement(By.xpath("//*[@id='Req_LTR_Btn_Submit']"));
		submit.click();	
		testcase.log(Status.PASS,"Local Training Applied Successfully");
	}
}
