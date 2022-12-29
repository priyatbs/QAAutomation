package Script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class BookAppointment extends Baseclass {
	@Test(priority = 1)
	public void bascript() throws InterruptedException {
		testcase = extentreport.createTest("Book Appointments");
		WebElement bkbtn = driver.findElement(By.xpath(
				"/html/body/app-root/app-dashboard/div/div[2]/app-sidemenu/div/div/p-scrollpanel/div[1]/div/div[1]/button"));
		bkbtn.click();
		WebElement doc1 = driver.findElement(By.xpath("//*[@id='0000000002']/div/div/div/div"));
		System.out.println(doc1.getText());
		// if(doc1.isDisplayed()) {
		doc1.click();

		WebElement doccard = driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div[3]/app-slot-selection/div/div[2]/div[1]"));
		String doccart = doccard.getText();
		System.out.println(doccart);

		List<WebElement> datelist = driver.findElements(By.xpath(
				"/html/body/app-root/app-dashboard/div/div[3]/app-slot-selection/div/div[2]/div[2]/p-card/div/div/div/div/div[7]"));

		System.out.println(datelist.size());
		Thread.sleep(1000);

		testcase.log(Status.INFO, "List of Dates Fetched");

		for (int i = 0; i <= datelist.size() - 1; i++) {
			if (datelist.get(i).getText().contains("06:30 PM")) {
				Thread.sleep(5000);
				datelist.get(i).click();
				WebElement yesbtn = driver.findElement(By.xpath(
						"/html/body/app-root/app-dashboard/div/div[3]/app-slot-selection/div/p-confirmdialog/div/div/div[3]/div/div[2]/div[1]/button"));
				yesbtn.click();
				WebElement sucmsg = driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[1]"));
				System.out.println("Success message appeared");
				testcase.log(Status.INFO, "Success Message Appeared");
				driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[1]/div/button/span")).click();
				testcase.log(Status.PASS, "Appointment Booked Successfully");
				driver.quit();
				break;

			} else {
				System.out.println("fail");
			}
		}

	}

}
