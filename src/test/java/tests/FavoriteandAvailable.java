package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pagefactory.Hamburgersidepage;

public class FavoriteandAvailable extends Baseclass {
	
	@Test
	public void Available() {
		testcase=extentreport.createTest("Verify Side menu");
		PageFactory.initElements(driver, Hamburgersidepage.class);
		Select se=new Select(driver.findElement(By.xpath("//div[@class='dropDown inputClass']/p-dropdown[@name='filterby']")));
		se.selectByVisibleText("Pricing");
	
		Hamburgersidepage.Sidemenubar.click();
		for (WebElement element : Hamburgersidepage.listelements) {
			if (element.getText().equals("Available")) {
				element.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Hamburgersidepage.Tableview.isDisplayed();
				Select dropdown = new Select(Hamburgersidepage.filterby);
				dropdown.selectByVisibleText("Pricing");
				System.out.println("tets");
				if(Hamburgersidepage.pagination.size()>0) {
					System.out.println("Size of the pagination :" + Hamburgersidepage.pagination.size()); 

					for(WebElement pagesize:Hamburgersidepage.pagination) {
						WebDriverWait wait=new WebDriverWait(driver, 50);
						wait.until(ExpectedConditions.elementToBeClickable(pagesize)).click();
						for(WebElement header: Hamburgersidepage.Availableheader) {
							System.out.println(header.getText());
						}
			}
			}
			
			}
		}

}
}