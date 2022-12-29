package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.ItemMenuClassFamilyPage;

public class Itemlist extends Baseclass{
	
	@Test
	public void itemsUI(){
		testcase =extentreport.createTest("Item List -UI screen");
		PageFactory.initElements(driver, ItemMenuClassFamilyPage.class);
		ItemMenuClassFamilyPage.itemicon.click();
		if(ItemMenuClassFamilyPage.itempopup.isDisplayed()) {
			if(ItemMenuClassFamilyPage.itemheader.getText().equalsIgnoreCase("Items")) {
				for(WebElement header: ItemMenuClassFamilyPage.itemtableheader) {
					System.out.println(header.getText());
				}
			}
		}
		
	}
	 
}
