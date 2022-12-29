package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.Baseclass;

public class Reportspage extends Baseclass{
	

	@FindBy(xpath="//*[@id='topMenu']")
	public static WebElement sidemenuimageclick;
	
	@FindBy(xpath="//ul[contains(@class,'p-menu-list p-reset')]/li/a/span/span[text()='Reports']")
	public static WebElement Reportclick;
	
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div")
	public static WebElement Reportspopup;
	
	
	@FindBy(xpath="//div[@class='From_date']/p-calendar/span/input")
	public static WebElement fromdate;
	
	@FindBy(xpath="//div[@class='To_date']/p-calendar/span/input")
	public static WebElement todate;
	
	@FindBy(xpath="//div[@class='report_category']/div[@class='report_section']/span")
	public static List<WebElement> reportname;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reports/div[3]/div[1]/p-radiobutton/div/div[2]")
	public static WebElement summary1reportcheckbox;
	
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reports/div[3]/div[2]/p-radiobutton/div/div[2]")
	public static WebElement summary2reportcheckbox;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reports/div[3]/div[3]/p-radiobutton/div/div[2]")
	public static WebElement subcardsreportcheckbox;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reports/div[3]/div[4]/p-radiobutton/div/div[2]")
	public static WebElement orderreportcheckbox;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reports/div[3]/div[5]/p-radiobutton/div/div[2]")
	public static WebElement Totalsreportcheckbox;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-reports/div[4]/button[2]/span")
	public static WebElement reportokbtn;
	
	
	@FindBy(xpath="//div[@class='report footer ltr']/button/span[contains(text(), 'Preview')]")
	public static WebElement previewbtn;

	
	
}
