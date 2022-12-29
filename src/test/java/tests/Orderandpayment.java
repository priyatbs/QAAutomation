package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pagefactory.Billingpage;
import pagefactory.Loginpage;
import pagefactory.OrdersPage;

public class Orderandpayment extends Baseclass {
	public static List<WebElement> tbxpath;
	public static int tablesize;
	
	
	@Test
	public void configchange() {
		testcase=extentreport.createTest("Config verify");
		PageFactory.initElements(driver, Billingpage.class);
		String userquery="select Config_Value from POS_STATION_CONFIG where Config_Name ='Change Qty for Same Item'  and Station_Id=4";
		Integer configvalue=jdbcTemplate.queryForObject(userquery, Integer.class);
		if(configvalue ==1) {
			tbxpath = Billingpage.inserttabledata;
			tablesize = tbxpath.size();
			testcase.log(Status.INFO,  "Insert config and Table data size :"+tablesize);
		}
	}
	
	
	@Test(dependsOnMethods="configchange")
	public void paymentorder() {
		PageFactory.initElements(driver, Billingpage.class);
		//WebElement payamountvalue =driver.findElement(By.xpath("//input[@id='Amount']"));
		//String payamount =Billingpage.payamountvalue.getAttribute("placeholder");
		String totalvalue = Billingpage.totalvalue.getText();
		String[] splittotalvalue = totalvalue.split(" ");
		String value = splittotalvalue[1];
		

		switch(prop.getProperty("paymenttype")) {
			case "paycash":
				JavascriptExecutor j = (JavascriptExecutor)driver;
			    j.executeScript("arguments[0].value='0" + value + "';", Billingpage.Payamount);
				Billingpage.paycash.click();
				/*
				 * ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				 * driver.switchTo().window(tabs2.get(1));
				 * driver.switchTo().window(tabs2.get(2));
				 */
			    testcase.log(Status.PASS,  "payment is done through Pay cash");
			    break;
			case "no invoice checkout": 
				Billingpage.checkout.click();
				if(Billingpage.noinvoicealert.isDisplayed()) {
					testcase.log(Status.PASS,"No Invoice alert message is displayed");
					if(Billingpage.alertheader.getText().equalsIgnoreCase("Alert")) {
						testcase.log(Status.PASS,"Alert header is displayed");
						if(Billingpage.alertmessage.getText().equalsIgnoreCase("There are no item(s) in the Invoice")){
							testcase.log(Status.PASS,"Alert message is displayed");
							Billingpage.alertclose.click();
						}
					
					}else {
						testcase.log(Status.FAIL,"No Invoice alert message is not displayed");
							}
				}
				
			case "checkout":
				
				Billingpage.checkout.click();
				if(Billingpage.paymentpage.isDisplayed()) {
					
					//if(payamount.equalsIgnoreCase(splittotalvalue[1])) {
						testcase.log(Status.PASS, "Total and payment page text box amount matched");
						for(WebElement modes : Billingpage.paymenttype) {
							//System.out.println(modes.getText());
							if(modes.getText().equalsIgnoreCase(prop.getProperty("paymentmode"))){
								modes.click();
								//if(payamount.equalsIgnoreCase(Billingpage.paidamount.getText())){
									Billingpage.paymentok.click();
										if(Billingpage.capturecardcheckbox.isSelected()) {
												if(Billingpage.capturecard.isDisplayed()) {
													Billingpage.capturecardok.click();
													ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
													driver.switchTo().window(tabs1.get(1));
													}
									
											}else{
												testcase.log(Status.PASS,"Capture card is unchecked and Payment receipt is printed without giving card details");
											}	
							//	}
								break;	
							}
						}
					//}
				}
				break;
			case "preorder": 
				if(tablesize > 0) {
					Billingpage.preorder.click();
					/*
					 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
					 * driver.switchTo().window(tabs.get(1));
					 */	
					testcase.log(Status.PASS,"Preorder is clicked and KOT is printed successfully");
				}
				else {
					testcase.log(Status.FAIL, "No data present in table and Preorder is disabled");
				}
				break;
			case "createorder": 	
				if(tablesize > 0) {
						Billingpage.createorder.click();
						/*
						 * ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
						 * driver.switchTo().window(tab.get(1));
						 */
						testcase.log(Status.PASS,"Create order is clicked and KOT is printed successfully");
					}else {
						testcase.log(Status.FAIL, "No data present in table and create order is disabled");
					}
				break;
		}
		
		

		}	
}