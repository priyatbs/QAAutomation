package TestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class BuisnessTravel extends BaseClass {

	@Test(priority = 1)
	public void BTrequest() throws InterruptedException {
		testcase = extentreport.createTest("Training Travel Apply");
		WebElement reqdropdwn = driver.findElement(By.xpath("//*[@id='Request']"));
		reqdropdwn.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id='Request']/ul/li/a"));
		System.out.println(allOptions.size());
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains("Business Travel")) {
				allOptions.get(i).click();
				testcase.log(Status.PASS, "Training Travel Applied Successfully");
				break;
			} else {
				System.out.println("No Transfer request is present");
			}
		}
		Thread.sleep(1000);
		WebElement begindate = driver.findElement(By.xpath("//*[@id='Req_BT_Cal_BeginningDate']/span/input"));
		begindate.click();
		driver.findElement(
				By.xpath("//*[@id=\"Req_BT_Cal_BeginningDate\"]/span/div/div/div/div[2]/table/tbody/tr[5]/td[2]"))
				.click();
		WebElement enddate = driver.findElement(By.xpath("//*[@id='Req_BT_Cal_EndDate']/span/input"));
		enddate.click();
		driver.findElement(By.xpath("//*[@id=\"Req_BT_Cal_EndDate\"]/span/div/div/div/div[2]/table/tbody/tr[5]/td[2]"))
				.click();
		WebElement vistpurp = driver.findElement(By.xpath("//*[@id='Req_BT_Ddn_PurposeOfVisit']/div/span"));
		vistpurp.click();

		List<WebElement> listpurp = driver.findElements(
				By.xpath("//*[@id='Req_BT_Ddn_PurposeOfVisit']/div/div[3]/div[2]" + "/ul/p-dropdownitem/li"));
		Thread.sleep(1000);
		for (int i = 0; i <= listpurp.size() - 1; i++) {
			if (listpurp.get(i).getText().contains("Trainee")) {

				listpurp.get(i).click();
				break;
			} else {
				System.out.println("No visit purpose is present");
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement billablecustomer = driver.findElement(By.xpath("//*[@id='Req_BT_Ddn_BillableCustomer']/div/span"));
		billablecustomer.click();
		List<WebElement> customertype = driver.findElements(
				By.xpath("//*[@id=\"Req_BT_Ddn_BillableCustomer\"]/div/div[3]" + "/div[2]/ul/p-dropdownitem/li"));

		for (int i = 0; i <= customertype.size() - 1; i++) {
			if (customertype.get(i).getText().contains("Yes")) {
				customertype.get(i).click();
				WebElement customername = driver.findElement(By.xpath("//*[@id='Req_BT_Txt_CustomerName']"));
				customername.sendKeys("Sathiya");
				WebElement submit = driver.findElement(By.xpath("//*[@id='Req_BT_Btn_Submit']"));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				submit.click();
				testcase.log(Status.PASS, "Training Travel Applied Successfully");
				break;

			} else {
				customertype.get(i).click();
				WebElement submit = driver.findElement(By.xpath("//*[@id='Req_BT_Btn_Submit']"));
				submit.click();
				testcase.log(Status.PASS, "Training Travel Applied Successfully");
			}
		}
	}

}
