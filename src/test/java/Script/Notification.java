package Script;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Notification extends Baseclass {
	@Test(priority =1)
	public void noscript(){
		testcase = extentreport.createTest("Notifications");
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[4]/a\r\n")).click();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[1]/div/img")).click();
		driver.findElement(By.xpath("//*[@id=\"notification\"]/div/div/div[6]/div")).click();
		WebElement we = driver.findElement(By.xpath ("/html/body/app-root/app-dashboard/div/div[3]/app-notifications/div/div[1]/div"));
		System.out.println(we.getText());
		List<WebElement> abc = driver.findElements(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-notifications/div/div[2]"));
		System.out.println(abc.lastIndexOf(abc));
		if(we.getText().equalsIgnoreCase("Notifications")) {
			System.out.println("Notifications present");
		}
		testcase.log(Status.PASS, "Notifications are visible");
	}

}
