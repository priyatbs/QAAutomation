package Script;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageFactory.SuggestionCommonObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Suggestion extends Baseclass {
	//public static WebDriver driver;
	@Test(priority =1)
	public  void script() throws InterruptedException {
		
		testcase =extentreport.createTest("Suggestions");
		
		
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions testd = new
		 * ChromeOptions(); driver = new ChromeDriver(testd);
		 * driver.get("http://192.168.200.8:8914"); Thread.sleep(2000); WebElement nid =
		 * driver.findElement(By.xpath("//*[@id='NationalId']"));
		 * nid.sendKeys("1759787698"); WebElement pwd =
		 * driver.findElement(By.xpath("//*[@id='password']")); pwd.sendKeys("123456");
		 * WebElement login = driver.findElement(By.xpath("//*[@id='submit']"));
		 * login.click();
		 */
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	    PageFactory.initElements(driver, SuggestionCommonObjects.class);
	    //SuggestionCommonObjects.sugoptn.click();
	    driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[4]/a\r\n")).click();
		  SuggestionCommonObjects.ddtype.click();
		  SuggestionCommonObjects.ot2.click();
	    SuggestionCommonObjects.sugadd();
	    Thread.sleep(2000);
	    SuggestionCommonObjects.mobno.clear();
	    SuggestionCommonObjects.mobno.sendKeys("854123975");
	    SuggestionCommonObjects.sub.sendKeys("test");
	    SuggestionCommonObjects.desc.sendKeys("test");
	    SuggestionCommonObjects.subtn.click();
	    testcase.log(Status.PASS, "Suggestions added Successfully");
//	    WebElement a1 =driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[1]/span/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li"));
//	    System.out.println(a1.getText());
	   
	  	}

}
