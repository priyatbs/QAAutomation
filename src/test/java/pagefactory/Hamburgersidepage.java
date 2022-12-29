package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Hamburgersidepage {
	@FindBy(xpath="//img[@id='topMenu']")
	public static WebElement Sidemenubar;
	
	@FindBy(xpath="//div[@class='moduleListMenu']")
	public static WebElement SideMenuelements;
	
	@FindBy(xpath="//ul[contains(@class,'p-menu-list p-reset')]/li")
	public static List<WebElement> listelements;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div")
	public static WebElement Tableview;
	
	@FindBy(xpath="//span[@class='p-dialog-title ng-tns-c35-4']")
	public static WebElement Tableheadername;
	
	@FindBy(xpath="//span[@class='p-dialog-header-close-icon pi pi-times ng-tns-c35-4']")
	public static WebElement Closebutton;
		
	@FindBy(xpath= "//div[@class='topbarTitle']")
	public static WebElement Headername;
			
	@FindBy(xpath="//div[contains(@src,'assets/icons/items.svg')]")
	public static WebElement Items;
	
	@FindBy(xpath="//div[contains(@src,'assets/icons/reservation.svg')]")
	public static WebElement Reservation;
	
	@FindBy(xpath="//div[contains(@src,'assets/icons/selectCustomer.svg')]")
	public static WebElement Selectcustomer;
	
	@FindBy(how = How.XPATH, using = "//a[@class='userName']" )
	public static List<WebElement> Signoff;
	
	@FindBy(xpath="//div[contains(@src,'assets/icons/pause.svg')]")
	public static WebElement Pause;
	
	@FindBy(xpath="//div[contains(@src,'assets/icons/languageSwitch.svg')]")
	public static WebElement Languageswitch;
	
	@FindBy(xpath= "//div[contains(@class,'footerDetails') and text(),'COMP')]")
	public static WebElement Companyname;
	
	@FindBy(xpath= "//div[contains(@class,'footerDetails') and normalize-space(.)='The Grove - Olaya')]")
	public static WebElement Branch;
	
	@FindBy(xpath= "//div[contains(@class,'footerDetails') and normalize-space(.)='Client 1')]")
	public static WebElement Station;
	
	@FindBy(xpath= "//div[contains(@class,'footerDetails') and normalize-space(.)=' Item Class')]")
	public static WebElement UsingItem;
	
	
	@FindBy(xpath= "//table[@id='pr_id_6-table']/thead[@class='p-datatable-thead']/tr/th")
	public static List<WebElement> Availableheader;
	
	@FindBy(xpath= "//table[@id='pr_id_6-table']/tbody[@class='p-element p-datatable-tbody']/tr/td")
	public static List<WebElement> Availablecontent;
	
	@FindBy(xpath= "//p-paginator[@class='p-element ng-star-inserted']/div/span/button")
	public static List<WebElement> pagination;
	
	@FindBy(xpath= "//div[@class='dropDown inputClass']/p-dropdown[@name='filterby']")
	public static WebElement filterby;
	
	@FindBy(xpath="//div[@class='amount']/input[@id='amount']")
	public static WebElement invoiceno;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reprint/div/div/button")
	public static WebElement reprintokbtn;
	
}
