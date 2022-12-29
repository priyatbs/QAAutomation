package tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagefactory.Customerpage;


public class Customer extends Baseclass{

	@Test
	public void newcustomer() {
		PageFactory.initElements(driver, Customerpage.class);
		Customerpage.customercreation.click();
		Customerpage.newcustomercreate();
		Customerpage.okbtn.click(); 
		System.out.println("test");
	}
	
	@Test
	public void selectcustomer() {
		
		PageFactory.initElements(driver, Customerpage.class);
		Customerpage.selectcustomerbtn.click();
		Customerpage.searchmobile.sendKeys(prop.getProperty("mobile"));
		Customerpage.searchbtn.click();
		for(WebElement dropdwn:Customerpage.customerdropdown) {
			if(dropdwn.getText().contains(prop.getProperty("customernamee"))){
				System.out.println("given  customer is selected");
				Customerpage.selectokbtn.click();
	    }
		
		}
	}
	

}
