package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Document extends BaseClass {
	@Test(priority =1)
	public void docscript() throws InterruptedException {
		testcase = extentreport.createTest("Document Upload");
		driver.findElement(By.xpath("//*[@id='Document']/a")).click();
		driver.findElement(By.id("Doc_Txt_FileName")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id='Doc_Ddn_categorycode']/div/span")).click();
		driver.findElement(By.xpath("//*[@id='Doc_Ddn_categorycode']/div/div[3]/div/ul/p-dropdownitem[2]/li")).click();
	    driver.findElement(By.id("Doc_Txt_Description")).sendKeys("testdata");
	    Thread.sleep(2000);
	    driver.findElement(By.id("Doc_Btn_Submit")).click();
	    testcase.log(Status.PASS,"Document Uploaded Successfully");
	}}
