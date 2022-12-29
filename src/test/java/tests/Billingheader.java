package tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Billingpage;



public class Billingheader extends Baseclass {

	@Test
	public void billingheadercheck() {
		testcase=extentreport.createTest("Billing Header Testcases");
		PageFactory.initElements(driver, Billingpage.class);
	if(Billingpage.billingheader.isEnabled()) {
		System.out.println("Billing headers are present");
		List<WebElement> headers=driver.findElements(By.xpath("//div[@class='billingSection']/app-billing-header/div/div/span"));
		
		
		for(WebElement Headeroption : headers)
			
		System.out.println("Billing header option is " + Headeroption.getText());
		testcase.log(Status.PASS," Billing headers are present");
	}
	else {
		System.out.println("Billing header is not Present");
		testcase.log(Status.FAIL," Billing header is not Present");
	}
}
	
	@Test(dependsOnMethods="billingheadercheck")	
	public static void invoicenocheck() {
		Integer invoicenum = jdbcTemplate.queryForObject("select Invoice_id from POS_INVOICES where USER_ID='25' and SOLD_SUB_TOTAL=0;", Integer.class);
				System.out.println("The user(DB) Invoice number is: " + invoicenum);
				PageFactory.initElements(driver, Billingpage.class);
				System.out.println("Invoice number present in screen " + Billingpage.invoice.getText());
				Integer invoicescreen=Integer.parseInt(Billingpage.invoice.getText());
				if(invoicescreen.equals(invoicenum.intValue())) {
					
					System.out.println("Invoice number present in screen is same as in DB");
					testcase.log(Status.PASS," Invoice number present in screen is same as in DB");
				}
				
				else {
					System.out.println("Invoice number present in screen is not same as in DB");
					testcase.log(Status.FAIL," Invoice number present in screen is not same as in DB");
				}
		
				
	}
	
}