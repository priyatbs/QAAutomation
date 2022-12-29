package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Hamburgersidepage;

public class Reprint extends Baseclass{
	public Integer invoice;
	public String parentwindow;
	@Test
	public void reprintvalidation() {
		parentwindow = driver.getWindowHandle();
		PageFactory.initElements(driver, Hamburgersidepage.class);
		String invoicequery="select INVOICE_ID from POS_INVOICES where INVOICE_ID =?;";
		try {
			invoice=jdbcTemplate.queryForObject(invoicequery,
				new Object[] {prop.getProperty("userinvoice")}, Integer.class);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(invoice >= 0) {
			Hamburgersidepage.Sidemenubar.click();
			for(WebElement element : Hamburgersidepage.listelements){
				   if (element.getText().equals("Reprint")){
				    	element.click();
				    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				    	Hamburgersidepage.invoiceno.sendKeys(prop.getProperty("userinvoice"));
				    	Hamburgersidepage.reprintokbtn.click();
				    	driver.switchTo().window(parentwindow);
					    break;
				   }
			}
		}else {
			System.out.println("No such invoice present in database");
		}
	}
}
