package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Floatin_Floatout extends Baseclass {
	
	public static String floatinval;
	public static String floatoutval;

	@Test
	public void floatintestcase() {
		WebElement sidemenu=driver.findElement(By.xpath("//div/img[@id='topMenu']"));
		sidemenu.click();
		WebElement floatin=driver.findElement(By.xpath("//div[contains(@class, 'ng-trigger ng-trigger-overlayAnimation')]/ul/li/a[@title='Float In']"));
		floatin.click();
		WebElement floatinpopupcheck=driver.findElement(By.xpath("//div[contains(@class, 'floatIn p-dialog p-dynamic-dialog ')]"));
		if(floatinpopupcheck.isDisplayed()) {
			WebElement floatinamnt=driver.findElement(By.xpath("//div[contains(@class, 'amount')]/span[@class='a']/input[@id='amount']"));
			floatinamnt.sendKeys(floatinval);
			WebElement	floatinokbtn= driver.findElement(By.xpath("//div[contains(@class, 'footerContainer flot_inout ltr')]/div/button"));
			floatinokbtn.click();
			WebElement	floatinsavepopup= driver.findElement(By.xpath("//div[contains(@class, 'floatIn p-dialog p-dynamic-dialog')]"));
			if(floatinsavepopup.isDisplayed()) {
			System.out.println("Float In saved successfully");
			WebElement	floatinsaveclose= driver.findElement(By.xpath("//div[contains(@class, 'p-dialog-header-icons ng-tns')]/button"));
			floatinsaveclose.click();
			}
			
		}
		
	}
	
	@Test
	public void floatouttestcase() {
		WebElement sidemenu=driver.findElement(By.xpath("//div/img[@id='topMenu']"));
		sidemenu.click();
		WebElement floatout=driver.findElement(By.xpath("//div[contains(@class, 'ng-trigger ng-trigger-overlayAnimation')]/ul/li/a[@title='Float Out']"));
		floatout.click();
		WebElement floatoutpopupcheck=driver.findElement(By.xpath("//div[contains(@class, 'floatOut p-dialog p-dynamic-dialog ')]"));
		if(floatoutpopupcheck.isDisplayed()) {
			WebElement floatoutamnt=driver.findElement(By.xpath("//div[contains(@class, 'amount')]/span[@class='a']/input[@id='amount']"));
			floatoutamnt.sendKeys(floatoutval);
			WebElement	floatoutokbtn= driver.findElement(By.xpath("//div[contains(@class, 'footerContainer flot_inout ltr')]/div/button"));
			floatoutokbtn.click();
			WebElement	floatoutsavepopup= driver.findElement(By.xpath("//div[contains(@class, 'floatOut p-dialog p-dynamic-dialog')]"));
			if(floatoutsavepopup.isDisplayed()) {
			System.out.println("Float Out saved successfully");
			WebElement	floatoutsaveclose= driver.findElement(By.xpath("//div[contains(@class, 'p-dialog-header-icons ng-tns')]/button"));
			floatoutsaveclose.click();
			}
			
		}
		
	}
	

}
