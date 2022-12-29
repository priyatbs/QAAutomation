package Script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Profile extends Baseclass{
	
	@Test(priority = 1)
	public void proscript() {
		
		
		
			testcase = extentreport.createTest("Profile");
			WebElement proimg = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[3]/div/span"));
			proimg.click();
			List <WebElement> prolist = driver.findElements(By.xpath("/html/body/div"));
			System.out.println(prolist.size());
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			for (int i = 0; i <= prolist.size() - 1; i++) {
				if(prolist.get(i).getText().contains("Profile")){
					driver.findElement(By.xpath("//*[@id='admin']/div[1]")).click();
					WebElement prohdr =driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-profile/div/div[1]/div"));
					System.out.println(prohdr.getText());
					testcase.log(Status.PASS, "Profile displayed successfully");
					break;
				}else {
					System.out.println("Element not available");
				}
			}
		
	}
		
	}


