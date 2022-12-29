package PageFactory;

import java.util.List; 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.SetUp;

public class LoginCommonObjects extends SetUp{

	@FindBy(xpath = "/html/body/app-root/"
			+ "app-signin/div/div/div[1]/div/div/form/div[1]/span/p-dropdown/div/div[3]/div/ul")
	public static List<WebElement> etype;

	@FindBy(xpath = "//*[@id='companyName']")
	public static WebElement cdd;

	@FindBy(xpath = "//*[@id='companyName']/div/div[3]/div[2]/ul/p-dropdownitem/li")
	public static List<WebElement> avc;

	@FindBy(xpath = "//*[@id='companyName']/div/div[2]")
	public static WebElement compdd;

	@FindBy(xpath = "//*[@id='companyName']/div/div[3]/div[2]/ul/p-dropdownitem/li")
	public static List<WebElement> seledd;

	@FindBy(xpath = "//*[@id=\"companyName\"]/div/div[3]/div[2]/ul/p-dropdownitem[44]/li/span")
	public static WebElement neerd;

	@FindBy(xpath = "//*[@id=\"userType\"]/div/span")
	public static WebElement etypeheader;

	@FindBy(id = "EmployeeID")
	public static WebElement empid;

	@FindBy(id = "password")
	public static WebElement pwd;

	@FindBy(id = "submit")
	public static WebElement loginbtn;
	
	@FindBy(xpath = "//*[@id='Request']/ul/li/a")
	public static  List <WebElement> reqli;
	
	///////////////////////////////***********e o s****************//////////////////////////////
	
	
	@FindBy(id ="Req_EOS_Rb _AdvancePayment")
	public static WebElement radio1;

	@FindBy(id ="Req_EOS_Rb_FullPayment")
	public static WebElement radio2;

	@FindBy(xpath ="//*[@id='Req_EOS_Cal_Date']/span/button")
	public static WebElement eoscal;


	@FindBy(xpath ="//*[@id='Rseq_EOS_Txt_notes']")
	public static WebElement notes;

	@FindBy(id ="Req_EOS_Btn_Reset")
	public static WebElement eosreset;
	
	@FindBy(id ="Req_EOS_Btn_Submit")
	public static WebElement eossubmit;
	
	@FindBy(xpath = "//*[@id='Req_EOS_Cal_Date']/span/div/div/div/div[1]/button[2]") 
	public static WebElement paginator;
	
	@FindBy(xpath="//*[@id='Req_EOS_Cal_Date']/span/div/div/div/div[2]/table/tbody/tr[4]/td[5]")
	public static WebElement date;
	
	@FindBy(xpath ="//*[@id=\"Req_EOS_Cal_Date\"]/span/div/div/div/div[1]")
	public static WebElement datehdr;
	
	
	
	///////////////////////////////********resignation**************///////////////////////////////
	
	@FindBy(xpath = "//*[@id='Req_RR_Cal_LastWorkDate']/span/button")
	public static WebElement recalendar;

	@FindBy(xpath = "//*[@id='Req_RR_Txt_Reason']")
	public static WebElement reasontxt;

	@FindBy(xpath = "//*[@id='Req_RR_Fup_Attachment']/div/div[1]/span/span[2]")
	public static WebElement attachmnt;

	@FindBy(id = "Req_RR_Btn_Reset")
	public static WebElement resetbtn;

	@FindBy(id = "Req_RR_Btn_Submit")
	public static WebElement submitbtn;
	
	
	@FindBy(xpath ="//*[@id=\"Req_RR_Cal_LastWorkDate\"]/span/div/div/div/div[1]/button[2]/span")
	public static WebElement repaginator;
	
	
	@FindBy(xpath ="//*[@id=\"Req_RR_Cal_LastWorkDate\"]/span/div/div/div/div[2]/table/tbody/tr[4]/td[5]/span")
	public static WebElement datesel;
	
	
	@FindBy(xpath ="//*[@id=\"Req_RR_Cal_LastWorkDate\"]/span/div/div/div/div[1]")
	public static WebElement redatehdr;
	

	public static void Login() {
		/*
		 * LoginCommonObjects.empid.sendKeys(id); LoginCommonObjects.pwd.sendKeys(pawd);
		 * LoginCommonObjects.loginbtn.click();
		 */
		empid.sendKeys(prop.getProperty("empid"));
		pwd.sendKeys(prop.getProperty("pawd"));
        loginbtn.click();	
	}

}
