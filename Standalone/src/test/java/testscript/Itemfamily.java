package testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Commonobjects;
import pagefactory.Itemmanagementobjects;

public class Itemfamily extends Baseclass{

	 String menuname="Item Details";
	 String submenuname="Item Family";
	 String code="0102";
	 String descE="Automationfamilytest";
	 String descA="test";
	
	@Test(priority=0)
 
	public void itemfamilyscript() {
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		Commonclass.testobjects(menuname,submenuname);
	System.out.println("Item family selected through common script");

	Commonobjects.addbtn.click();
	
	if(Itemmanagementobjects.familyheader.getText().equalsIgnoreCase("Item Family Details")) {
		System.out.println("Item Family details creation popup present");
		
		Itemmanagementobjects.itemaddedit(code, descE, descA);
		System.out.println(code+" "+Commonobjects.msgdetails.getText());
		Commonobjects.msgclosebtn.click();
		
	}
	else {
		System.out.println("Item Family details creation popup may not present or header name is changed");
	}
	
 }
	
	@Test(priority=1)
	public void itemFamilyedit() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		PageFactory.initElements(driver, Commonobjects.class);
		Commonobjects.search(code);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.editicon.click();
			Itemmanagementobjects.itemaddedit("Automationtest2", "test");
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
			
			
		}
		
	}
	
	@Test(priority=2)
	public void itemFamilydelete() {
		Commonobjects.search(code);
		PageFactory.initElements(driver, Commonobjects.class);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.deleteicon.click();
			if(Commonobjects.deletepopupmsg.isDisplayed()) {
				System.out.println(Commonobjects.deletepopupmsg.getText());
				Commonobjects.deletebtn.click();
				
				
			}
			
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
		
	}
	
	
}
