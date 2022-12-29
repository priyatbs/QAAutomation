package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.SleepPage;

public class SleepTestcases  extends Baseclass {
	
	
	
	@Test
	public void sleep() {
		testcase=extentreport.createTest("Sleep Test Cases");
		
		PageFactory.initElements(driver, SleepPage.class);
		
		if(!SleepPage.billingtable.isEmpty()) {
			SleepPage.sleepicon.click();
		if(SleepPage.billitemsalert.isDisplayed()) {
			System.out.println("Billing table have some invoice so before click sleep close the invoice");
			SleepPage.alertclose.click();
			refreshcheck();
			SleepPage.sleepicon.click();
			testcase.log(Status.PASS, "Sleep Functionality Testcase Passed");
		}
		
		
	}else {
		SleepPage.sleepicon.click();
		if(SleepPage.loginreturn.isDisplayed()) {
			
			System.out.println("Login Page present after sleep click");
		}
	}

		
	}
public void refreshcheck(){
	PageFactory.initElements(driver, SleepPage.class);
	SleepPage.refresh.click();
	if(SleepPage.refreshconfirmpopup.isDisplayed()) {
		System.out.println("Invoice clear alert present");
		SleepPage.refreshyesbtn.click();
	
	if(SleepPage.billingtable.isEmpty()) {
		System.out.println("Billing Table does not have items");
	}
	testcase.log(Status.PASS, "Billing Table does not have items");
}
}	
	
}
