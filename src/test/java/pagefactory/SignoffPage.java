package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignoffPage {
	@FindBy(xpath="//div[@class='userName']")
	public static WebElement signoffintopbar;
	
	@FindBy(xpath="//div[@class='profileCard menuItemText']")
	public static WebElement signoffclick;
	
	@FindBy(xpath="//div[contains(@class, 'ng-trigger ng-trigge')]")
	public static WebElement signoffpopup;
	
	@FindBy(xpath="//app-confirmation-popup[@class='ng-star-inserted']/div/button[2]")
	public static WebElement signoffyes;
	
	@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c38-14 endofday p-dialog p-dynamic-dialog p-component ng-star-inserted']")
	public static WebElement endoffthedaypopup;
}
