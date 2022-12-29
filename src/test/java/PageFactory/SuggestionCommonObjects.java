package PageFactory;

import java.util.List; 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestionCommonObjects {

	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[2]"
			+ "/app-sidemenu/div/div/p-scrollpanel/div/div/div[2]/p-menu/div/ul/li[4]/a\r\n")
	public static WebElement sugoptn;
	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[1]/span/p-dropdown")
	public static WebElement ddtype;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[1]/span/p-dropdown/div/div[3]/div/ul")
	public  static List <WebElement> typelist;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[2]/span/input\r\n")
	public static WebElement pname;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[4]/span/input\r\n")
	public static WebElement mobno;

	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[5]/span/input\r\n")
	public static WebElement sub;
	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[6]/span/input\r\n")
	public static WebElement desc;
	@FindBy(xpath = "//*[@id=\"submit\"]")
	public static WebElement subtn;
	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/div")
	public static WebElement sughdr;
	@FindBy(xpath ="/html/body/app-root/app-dashboard/div/div[3]/app-suggestion/div/div[3]/form/div[1]/span/p-dropdown/div/div[3]/div/ul/p-dropdownitem[2]/li")
	public static WebElement ot2;
	
	public static void sugadd() {
		/*
		 * SuggestionCommonObjects.sugoptn.click();
		 * SuggestionCommonObjects.ddtype.click(); SuggestionCommonObjects.ot2.click();
		 */
      
		 if(sughdr.getText().equalsIgnoreCase("Suggestion")) {
			  for(WebElement ink: SuggestionCommonObjects.typelist) {
				  if(ink.getText().equalsIgnoreCase("Complaint")) {
					  ink.click();
					  
				  }
			  }
			  
		  
		  
	}
	}
}
