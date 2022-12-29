package TestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageFactory.CommonObjects;
import PageFactory.LoginCommonObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EndofService extends BaseClass {
	String id = "0000000008";
	String pwd = "123456";
	
	@Test(priority = 1)
	public void eosscript() throws InterruptedException {
//		WebDriver driver;
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//
//		driver.get("http://192.168.200.8:8016/");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		PageFactory.initElements(driver, LoginCommonObjects.class);
//		PageFactory.initElements(driver, CommonObjects.class);
//		LoginCommonObjects.compdd.click();
//		testcase = extentreport.createTest("ESS Login");    
//		//testcase.log(Status.PASS, "Added successfully");
//		if (LoginCommonObjects.etypeheader.getText().equalsIgnoreCase("Employee")) {
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,500)");
//
//			System.out.println(LoginCommonObjects.avc.size());
//			for (int i = 0; i <= LoginCommonObjects.avc.size() - 1; i++) {
//				if (LoginCommonObjects.avc.get(i).getText().contains("New Era Technology # 440099")) {
//					LoginCommonObjects.avc.get(i).click();
//					break;
//
//				}
//
//			}
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			LoginCommonObjects.Login();
//			testcase.log(Status.PASS, "Logged in successfully");
//		} else {
//			System.out.println("Field not present or header name is changed");
//		}
		testcase = extentreport.createTest("End of Service Apply");
		driver.findElement(By.xpath("//*[@id='Request']")).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 7500)");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id='End of Service']/a")).click();
		for(int i =0; i<=LoginCommonObjects.reqli.size() -1; i++) {
			if(LoginCommonObjects.reqli.get(i).getText().contains("End of Service")) {
				// WebElement element =driver.findElement(By.xpath("//div[@class='p-scrollpanel-bar p-scrollpanel-bar-y'"));
				
				//body/app-root/app-main/div/app-menu/div/p-scrollpanel/div/div[3]
				//element.click();
				//div[@class='p-scrollpanel-bar p-scrollpanel-bar-y'
//				
//				for(WebElement opt : element) {
//					opt.sendKeys(Keys.DOWN);
//					js.executeScript("scrollBy(0, 7500)");
				//	js.executeScript("arguments[0].style.background='yellow'", element);
//				}
				
				//js.executeScript("arguments[0].scrollIntoView(true);",element);
				
				//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
				LoginCommonObjects.reqli.get(i).click();
				//driver.findElement(By.xpath("//*[@id='End of Service']/a")).click();
			}
		}
		Thread.sleep(1000);
	LoginCommonObjects.radio1.click();	
	LoginCommonObjects.eoscal.click();
	LoginCommonObjects.paginator.click();
	System.out.println(LoginCommonObjects.datehdr.getText());
	if(LoginCommonObjects.datehdr.getText().equalsIgnoreCase("November2022")) {
		LoginCommonObjects.date.click();
		driver.findElement(By.xpath("//*[@id='amountRequested']")).sendKeys("300");
		LoginCommonObjects.notes.sendKeys("Prolonged Illness");
		//LoginCommonObjects.eossubmit.click();
	}
	else {
		System.out.println("field not available");
	}
	
	LoginCommonObjects.radio2.click();
	LoginCommonObjects.eoscal.click();
	LoginCommonObjects.paginator.click();
	System.out.println(LoginCommonObjects.datehdr.getText());
	if(LoginCommonObjects.datehdr.getText().equalsIgnoreCase("December2022")) {
		LoginCommonObjects.date.click();
		LoginCommonObjects.notes.sendKeys("Prolonged Illness");
		LoginCommonObjects.eossubmit.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@id='Btn_Confirm']/div/div/div[3]/button")).click();
//		
		testcase.log(Status.PASS, "End of Service applied successfully");
	
	
	}}}



		
