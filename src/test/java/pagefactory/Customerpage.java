package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.Baseclass;

public class Customerpage extends Baseclass{
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[3]/img")
	public static WebElement customercreation;
	
	@FindBy(xpath="//div[@class='Name_sec']/input[@formcontrolname='customer_name_e']")
	public static WebElement customernameeng;
	
	@FindBy(xpath="//div[@class='Name_sec']/input[@formcontrolname='customer_name_a']")
	public static WebElement customernamearabic;
	
	@FindBy(xpath="//div[@class='mobile_sec']/input[@formcontrolname='mobile']")
	public static WebElement mobile;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-customer-management/div[2]/form/div/p-button[3]/button/span[1]")
	public static WebElement save;
	
	@FindBy(xpath="/html/body/app-root/p-dialog/div/div")
	public static WebElement successpopup;
	
	@FindBy(xpath="html/body/p-dynamicdialog/div/div/div[2]/app-customer-management/div[2]/form/div/p-button[5]/button/span[1]")
	public static WebElement okbtn;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[1]/app-topbar/div/div[2]/div[4]/img")
	public static WebElement selectcustomerbtn;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-select-customer/div[1]/form/input[2]")
	public static WebElement searchcustomernameE;
	
	@FindBy(xpath="//form[@class='search_form ng-untouched ng-pristine ng-invalid']/input[@formcontrolname='customer_name_a']")
	public static WebElement searchcustomernameA;	

	@FindBy(xpath="//form[@class='search_form ng-untouched ng-pristine ng-invalid']/input[@formcontrolname='mobile']")
	public static WebElement searchmobile;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-select-customer/div[1]/form/button/span[2]")
	public static WebElement searchbtn;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-select-customer/div[3]/p-dropdown/div")
	public static List<WebElement> customerdropdown;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-select-customer/div[4]/button[2]/span")
	public static WebElement selectokbtn;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-customer-management/div[1]/form/div[1]/input[@formcontrolname='mobile']")
	public static WebElement editsearchbtn;
	
	
	
	
	public static void newcustomercreate() {
		customernameeng.sendKeys(prop.getProperty("customernamee"));
		customernamearabic.sendKeys(prop.getProperty("customernamea"));
		mobile.sendKeys(prop.getProperty("mobile"));
		save.click();
	}
	
	public static void selectcustomer() {
		customernameeng.sendKeys(prop.getProperty("customernamee"));
		searchbtn.click();
	}
}
