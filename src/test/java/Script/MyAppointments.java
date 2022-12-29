package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class MyAppointments extends Baseclass {

	@Test(priority =1)
public void myap() throws InterruptedException {
		testcase = extentreport.createTest("My Appointments");
	WebElement myoptn = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div[1]/div/div[2]/p-menu/div/ul/li[2]/a"));
	myoptn.click();
	WebElement myhdr = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-myappointments/div/div/div"));
	System.out.println(myhdr.getText());
	
	if(myhdr.getText().equalsIgnoreCase("My Appointments")) {
		testcase.log(Status.PASS, "My Appointments page opened successfully");
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-myappointments/div/p-dataview/div/div[1]/div[1]/div/div[1]/button[2]")).click();
		testcase.log(Status.INFO, "Past Appointments are Displayed");
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-myappointments/div/p-dataview/div/div[1]/div[1]/div/div[1]/button[1]")).click();
		testcase.log(Status.INFO, "Upcoming Appointments present");
	Thread.sleep(2000);
		WebElement statusq = driver.findElement(By.xpath("//*[@id='124_20221106T180000']/div/div[2]/div/div[1]"));
	WebElement cancel = driver.findElement(By.xpath("//*[@id='124_20221106T180000']/div/div[2]/div/div[2]/button"));
  
	
	System.out.println(statusq.getText());
	
	if(statusq.getText().equalsIgnoreCase("Status : Booked")) {
		testcase.log(Status.INFO, "Confirmation pop up Present");
		cancel.click();
		 WebElement yesbtn = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-myappointments/p-confirmdialog[1]/div/div/div[3]/div/div[2]/div[1]/button"));
		yesbtn.click();
		//testcase.log(Status.PASS, "Appointment cancelled Successfully");
	}
	WebElement succss = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-myappointments/p-confirmdialog[3]/div/div/div[1]/h3"));
	succss.isDisplayed();
	driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-myappointments/p-confirmdialog[3]/div/div/div[1]/div")).click();
	testcase.log(Status.INFO, "Success pop up Appeared");
	System.out.println("Appointment Cancelled successfully");
	testcase.log(Status.PASS, "Appointment cancelled Successfully");
	}
	else  {
		System.out.println("Element not available");
		testcase.log(Status.FAIL, "Appointments not Available");
	}
	}
}


