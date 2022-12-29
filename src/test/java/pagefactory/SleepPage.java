package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SleepPage {
	
	@FindBy(xpath="//div[@class='topbarItems']/img[@src='assets/icons/pause.svg' and @class='topbarImg']")
	public static WebElement sleepicon;
	
	@FindBy(xpath="//table[@class='p-datatable-table ng-star-inserted']/tbody/tr")
	public static List<WebElement> billingtable;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[1]/app-topbar/p-dialog/div/div/div[1]")
	public static WebElement billitemsalert;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[1]/app-topbar/p-dialog/div/div/div[1]/div")
	public static WebElement alertclose;
	
	//@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c38-16 session p-dialog p-dynamic-dialog p-component ng-star-inserted']")
	//public static WebElement invoiceclear;
	
	@FindBy(xpath="//div/button[@class='p-ripple p-element p-confirm-dialog-accept p-button p-component yes ltr']")
	public static WebElement invoiceclearyesbtn;
	
	@FindBy(xpath="//div/button[@class='p-ripple p-element p-confirm-dialog-reject p-button p-component no']")
	public static WebElement invoiceclearnobtn;
	
	@FindBy(xpath="//div[@class='loginLogo']")
	public static WebElement loginreturn;
	
	@FindBy(xpath="//div/img[@class='refreshImg']")
    public static WebElement refresh;
	
	@FindBy(xpath="//div[contains(@class, 'session p-dialog p-dynamic-dialog p-component')]")
	 public static WebElement refreshconfirmpopup;
	
	@FindBy(xpath="//div[contains(@class, 'p-dialog-footer')]/button[2]")
	public static WebElement refreshyesbtn;

}
