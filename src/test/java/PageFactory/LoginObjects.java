package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjects {
	@FindBy(xpath="//form/div[1]/span/input")
	public static WebElement nationalid;

	@FindBy(xpath="//form/div[3]/span/input")
	public static WebElement fileno;

	@FindBy(xpath="//form/div[4]/span/input")
	public static WebElement pwd;

	@FindBy(xpath="//form/div[6]/button")
	public static WebElement loginbtn;

	

}