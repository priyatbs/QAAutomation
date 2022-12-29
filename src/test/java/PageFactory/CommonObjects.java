package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonObjects {

	
	@FindBy(xpath ="/html/body/app-root/app-main/div/app-menu/div/p-scrollpanel/div/div[1]/div/div/ul/li")
	public static  List <WebElement> Menuoptions;
	
	
	@FindBy(xpath="//div[contains(@class, 'menu-scroll-content')]/ul/li[3]/ul/li/a")
	public static List <WebElement> Sidemenus;
	
	@FindBy(xpath= "/html/body/app-root/app-main/div/app-menu/div/p-scrollpanel/div/div[1]/div/div/ul/li[14]/ul/li[13]/a")
	public static WebElement menuclk;
	
	@FindBy(id ="LogoMenuClick")
	public static WebElement hamclk;
	
	
}
