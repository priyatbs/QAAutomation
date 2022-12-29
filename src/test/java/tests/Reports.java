package tests;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagefactory.Reportspage;

public class Reports extends Baseclass {
@Test
public void clickreports() {
	
	PageFactory.initElements(driver, Reportspage.class);
	Reportspage.sidemenuimageclick.click();
	Reportspage.Reportclick.click();
	String reportnames=prop.getProperty("nameofreport");
	if(Reportspage.Reportspopup.isDisplayed()) {
		System.out.println("Reports window dialog opened");
		Reportspage.fromdate.sendKeys(prop.getProperty("fromdate"));
		Reportspage.fromdate.sendKeys(Keys.ENTER);
		Reportspage.todate.sendKeys(prop.getProperty("todate"));
		Reportspage.todate.sendKeys(Keys.ENTER);
		for(WebElement rname: Reportspage.reportname ) {
			switch (prop.getProperty("reportnames")) {
				case "Summary1":
					Reportspage.summary1reportcheckbox.click();
					Reportspage.previewbtn.click();
					
				 case "Summary 2":
					Reportspage.summary2reportcheckbox.click();
					ArrayList<String> Summary2 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(Summary2.get(1));
				case "Sub-cards":
					Reportspage.subcardsreportcheckbox.click();
					ArrayList<String> Subcards = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(Subcards.get(1));
				case "Order":
					Reportspage.orderreportcheckbox.click();
					ArrayList<String> Order = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(Order.get(1));
				case "Totals":
					Reportspage.Totalsreportcheckbox.click();
					ArrayList<String> Totals = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(Totals.get(1));
		
			}
				
			}
		}
				
	}
	
}

