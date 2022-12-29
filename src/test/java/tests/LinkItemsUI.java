package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pagefactory.ItemMenuClassFamilyPage;

public class LinkItemsUI extends Baseclass {
	
	public static String linkitemtablabelname;
	public static String notestoclick="NO ICE";

	@Test
	public void linkitemslabelcheck() {
		testcase=extentreport.createTest("Verify link Items Label check");
		for(WebElement label:ItemMenuClassFamilyPage.linkitemstablabelname) {
		if(linkitemtablabelname.contains(label.getText())) {
			System.out.println("Label: " +label.getText());
			for(WebElement notes:ItemMenuClassFamilyPage.notesdetails) {
			System.out.println("notes details check box: " +notes.getText());
			if(notestoclick.contains(notes.getText())) {
				notes.click();
				System.out.println("Selected notes option is: " +notes.getText());
				
			}
			}
		}
			

	}
	}
	
}
