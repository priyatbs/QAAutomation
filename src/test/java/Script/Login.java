package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageFactory.LoginObjects;
import PageFactory.SuggestionCommonObjects;

public class Login extends Baseclass {
	@Test(priority = 0)
	public void Oaslogin() throws InterruptedException {
		PageFactory.initElements(driver, LoginObjects.class);
		driver.navigate().to(prop.getProperty("url"));
		LoginObjects.nationalid.sendKeys("1464550621");
		LoginObjects.pwd.sendKeys("123456");
		LoginObjects.loginbtn.click();
		Thread.sleep(5000);
		/*
		 * driver.findElement(By.xpath(
		 * "/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[4]/a\r\n"
		 * )).click();
		 * 
		 * 
		 * PageFactory.initElements(driver, SuggestionCommonObjects.class);
		 * //SuggestionCommonObjects.sugoptn.click(); driver.findElement(By.xpath(
		 * "/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[4]/a\r\n"
		 * )).click(); SuggestionCommonObjects.ddtype.click();
		 * SuggestionCommonObjects.ot2.click(); SuggestionCommonObjects.sugadd();
		 * Thread.sleep(2000); SuggestionCommonObjects.mobno.clear();
		 * SuggestionCommonObjects.mobno.sendKeys("854123975");
		 * SuggestionCommonObjects.sub.sendKeys("test");
		 * SuggestionCommonObjects.desc.sendKeys("test");
		 * SuggestionCommonObjects.subtn.click(); WebElement a1
		 * =driver.findElement(By.xpath(
		 * "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[1]/span/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li"
		 * )); System.out.println(a1.getText());
		 */

	}
}
