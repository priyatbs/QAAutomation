package Script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Logout extends Baseclass {
	
	@Test(priority = 1)
	public void logscript() {
		testcase = extentreport.createTest("Logout");
		WebElement proimg = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[3]/div/span"));
		proimg.click();
		List <WebElement> prolist = driver.findElements(By.xpath("/html/body/div"));
		System.out.println(prolist.size());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		for (int i = 0; i <= prolist.size() - 1; i++) {
			if(prolist.get(i).getText().contains("Profile")){
				prolist.get(i).click();
				testcase.log(Status.PASS, "Logged out successfully");
				break;
			}else {
				System.out.println("Element not available");
			}
		}
		
		/*
		 * for(WebElement li : prolist) { if(li.getText().equalsIgnoreCase("Profile")) {
		 * li.click(); break; } }
		 */
	}

}


/*
 * System.out.println(LoginCommonObjects.avc.size()); for (int i = 0; i <=
 * LoginCommonObjects.avc.size() - 1; i++) { if
 * (LoginCommonObjects.avc.get(i).getText().
 * contains("New Era Technology # 440099")) {
 * LoginCommonObjects.avc.get(i).click(); break;
 */
