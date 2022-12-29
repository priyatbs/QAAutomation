package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.SetUp;

public class Tablespage extends SetUp {
	
	
//	@FindBy(xpath="//div[@class='col-12 zeroPadding']/button/span[text()='Tables'])")
//	public static WebElement Tables;
	 
	@FindBy(xpath="/html/body/app-root/app-table-management/div")
	public static WebElement Tableshomepage;
	
	@FindBy(xpath="//div[@class='tableFooter']/div/div']")
	public static List<WebElement> Tablefooter;
	
	
	@FindBy(xpath="//div[@class='header']/span[@class='page-title']")
	public static WebElement Tablesheader;
	
	@FindBy(xpath="//ul[@class='p-tabview-nav']/li")
	public static List<WebElement> Areaname;
	
	@FindBy(xpath="/html/body/app-root/app-table-management/p-dialog/div/div")
	public static WebElement SelectNoofPersons;
	
	@FindBy(xpath="//input[@id='amount']")
	public static WebElement EnterNoofPersons;
	
	@FindBy(xpath="//button[@class='okButton primaryBtnColor']")
	public static WebElement EnterOk;
	
	@FindBy(xpath="//div[@class='maxSeats content-center ng-tns-c15-4']	")
	public static WebElement MaximumSeatCapacity;
	
	
	@FindBy(xpath="//div[@class='tableName']")
	public static List<WebElement> TableItems;
	
	@FindBy(xpath="//div[@class='tableBillAmount']")
	public static List<WebElement> BillAmount;
	
	@FindBy(xpath="//div[@class='parentContainer']/div/div[@class='tableHrsSeatNumbers ng-star-inserted']")
	public static List<WebElement> TableHrsSeatnum;
	
	@FindBy(xpath="//div[@class='parentContainer']/div/div[@class='tableStatus']")
	public static List<WebElement> TableStatus;	
	
	@FindBy(xpath= "//div[@class='topbarTitle']")
	public static WebElement Headername;
	
	
	public static void Selectnoofpersons() {
		EnterNoofPersons.sendKeys(prop.getProperty("noofpersons"));
		EnterOk.click();
	}

	
	
	
	
}
