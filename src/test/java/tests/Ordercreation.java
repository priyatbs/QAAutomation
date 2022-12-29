package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Billingpage;

public class Ordercreation extends Baseclass{
	public static List<WebElement> tbxpath;
	public static int tablesize;
	@Test
	public void aconfigchange() {
		testcase=extentreport.createTest("Order Creation");
		PageFactory.initElements(driver, Billingpage.class);
		String userquery="select Config_Value from POS_STATION_CONFIG where Config_Name ='Change Qty for Same Item' and station_id =4";
		Integer configvalue=jdbcTemplate.queryForObject(userquery, Integer.class);
		/*
		 * if(configvalue ==1) { tbxpath = Billingpage.inserttabledata; tablesize =
		 * tbxpath.size(); testcase.log(Status.INFO,
		 * "Insert config and Table data size :"+tablesize); }
		 * 
		 */
		
		
	}
	@Test
	public void precreateorder() {
		PageFactory.initElements(driver, Billingpage.class);
		tbxpath = Billingpage.inserttabledata;
		tablesize = tbxpath.size();
		switch(prop.getProperty("ordertype")) {
		case "preorder": 
			if(tablesize > 0) {
				String a = Billingpage.orderno.getText();
				Billingpage.preorder.click();
				
				System.out.println("PreOrder is successfully created. Order number is "+a);
				/*
				 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				 * driver.switchTo().window(tabs.get(1));
				 */
				testcase.log(Status.PASS,"Preorder is clicked and KOT is printed successfully. Order number is "+Billingpage.orderno.getText());
			}
			else {
				testcase.log(Status.FAIL, "No data present in table and Preorder is disabled");
			}
			break;
		case "createorder": 	
			if(tablesize > 0) {
				Billingpage.orderno.getText();
				System.out.println("Order is successfully created. Order number is "+Billingpage.orderno.getText());
					Billingpage.createorder.click();
					
					
					/*
					 * ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
					 * driver.switchTo().window(tab.get(1));
					 */
					testcase.log(Status.PASS,"Create order is clicked and KOT is printed successfully. Order number is "+Billingpage.orderno.getText());
				}else {
					testcase.log(Status.FAIL, "No data present in table and create order is disabled");
				}
			break;
	}
		}
	
}
