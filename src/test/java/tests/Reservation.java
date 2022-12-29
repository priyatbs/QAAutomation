package tests;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

	public class Reservation extends Baseclass {
		public static String tab;
		public static String Roption;
		public static String resetsave;
		
		@SuppressWarnings("deprecation")
		@Test
		public static void ReservationHome() {
			testcase=extentreport.createTest("Verify the Reservation Page");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[2]/img")));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
			WebElement rpage=driver.findElement(By.xpath("/html/body/app-root/app-reservation/div/div[1]/span[1]"));
			if(rpage.isEnabled()) {
				System.out.println("Reservation Home page is present");
				testcase.log(Status.PASS," Reservation Home page is present");
			}
			else {
				System.out.println("Reservation Home page is not  present");
				testcase.log(Status.FAIL," Reservation Home page is not present");
			}
		}
		
		
		 @Test(dependsOnMethods="ReservationHome") 
		  public static void tablevalue() {
			 testcase=extentreport.createTest("Verify the tablevalue");
			 
		  @SuppressWarnings("deprecation") WebDriverWait wait = new
		  WebDriverWait(driver, 10); WebElement
		  table=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		  "/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[1]/div/div[1]/div[7]/div"
		  ))); 
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		  table);
		  
		  List<WebElement> listvalues= driver.findElements(By.xpath(
		  "/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[1]/div/div[1]/div[7]/div/div/p-tieredmenu/div/p-tieredmenusub/ul/li"
		  ));
		  
		  for (WebElement option : listvalues) {
		  
		  System.out.println("Text :" + option.getText());
		  
		  if(option.getText().equals("Not Allow")) { option.click();
		  System.out.println("Not Allow Option is selected in dropdown");
		  testcase.log(Status.PASS," Table Drop down option is selected successfully");
		  break; 
		  }
		  else
		  {
			  testcase.log(Status.INFO," Table Drop down option is not selected");  
		  }
		  }
		  }
		 

		@Test(dependsOnMethods="tablevalue")
		public static void wholetablevalue2() {
	    List<WebElement> rtab=driver.findElements(By.xpath("/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[1]/div/ul/li"));
	    for (WebElement tabvalue : rtab) {
	  	 
			System.out.println("Text :" + tabvalue.getText());
		    
			  if(tabvalue.getText().equals(prop.getProperty("tableAreaname"))) {
				  tabvalue.click();
			  System.out.println(prop.getProperty("tableAreaname")+" Tab is selected in dropdown");
			  testcase.log(Status.PASS,prop.getProperty("tableAreaname")+"Tab is selected in dropdown");
			  break; 
			  }
			 }
	    if(prop.getProperty("tableAreaname").equalsIgnoreCase("THE GROVE YARD")) {
	    	 @SuppressWarnings("deprecation") 
	    	 WebDriverWait wait = new WebDriverWait(driver, 10); 
	    	 WebElement table=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	    			  "/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[1]/div/div[1]/div[7]/div"
	    			  ))); 
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", table);
	    			  
	    			  List<WebElement> listvalues= driver.findElements(By.xpath(
	    			  "/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[1]/div/div[1]/div[7]/div/div/p-tieredmenu/div/p-tieredmenusub/ul/li"
	    			  ));
	    			  
	    			  for (WebElement option : listvalues) {
	    			  
	    			  System.out.println("Text :" + option.getText());
	    			  
	    			  if(option.getText().equals("Not Allow")) { option.click();
	    			  System.out.println("Not Allow Option is selected in dropdown"); 
	    			  testcase.log(Status.PASS,"Not Allow Option is selected in dropdown");
	    			  break;
	    			  }
	    			  }
			 
	    }
	    else if(prop.getProperty("tableAreaname").equalsIgnoreCase("Chinese"))	{
	    	WebElement chinesetab=driver.findElement(By.xpath("/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[1]/div/ul/li[4]/a/span[1]"));
	    	if(chinesetab.isEnabled()) {
	    		 System.out.println("Pointer moved to Chinese tab");
	    	}
	    	 WebDriverWait wait = new WebDriverWait(driver, 10); 
	    	 WebElement table=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	    			  "/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[4]/div/div[1]/div[1]/div/div"
	    			  ))); 
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", table);
	    	
	    	 List<WebElement> listvalues= driver.findElements(By.xpath(
	   			  "//div[contains(@class,'ng-trigger ng-trigger-overlayAnimation ng')]/p-tieredmenusub/ul/li"));

	    	 for (WebElement option : listvalues) {
				  
				  System.out.println("Text :" + option.getText());
				  
				  if(option.getText().equals(prop.getProperty("Roption"))) {
					  option.click();
				  System.out.println(prop.getProperty("Roption")+" Option is selected in dropdown");
				  testcase.log(Status.PASS,prop.getProperty("Roption")+" Option is selected in dropdown");
				  break;
				  }
				  }
	    	 
	    }
		}
		@Test(dependsOnMethods="wholetablevalue2")
		public static  void reservationsave(){
			WebElement rsave=driver.findElement(By.xpath("/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[4]/div/div[2]/div[2]/div[2]/button"));
			rsave.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[2]/img")));
			if(element.isEnabled()) {
				System.out.println("Reservation screen changes are saved");
				testcase.log(Status.PASS,"Reservation screen changes are saved");
			}
			
		}
		
		@Test(enabled=false)
		//(dependsOnMethods="wholetablevalue2")
		public static  void reservationreset(){
			WebElement closeicon=driver.findElement(By.xpath("//div[@class='header']/span[@class='closeIcon']"));
			closeicon.click();
			WebElement reset=driver.findElement(By.xpath("/html/body/app-root/app-reservation/div/div[2]/p-tabview/div/div[2]/p-tabpanel[4]/div/div[2]/div[2]/div[1]/button/span"));
			reset.click();
			String window=driver.getWindowHandle();
			driver.switchTo().window(window);
			WebElement ok=driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[2]/app-confirmation-popup/div/button[2]"));
			ok.click();
			testcase.log(Status.PASS,"Reservation reset");
			
			
		
		}
		
		
	}