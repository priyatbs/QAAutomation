package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestCommonObjects {
	@FindBy(xpath = "*[@id=\"Req_RR_Cal_LastWorkDate\"]/span/button")
	public static WebElement recalendar;

	@FindBy(xpath = "//*[@id=\"Req_RR_Txt_Reason\"]")
	public static WebElement reasontxt;

	@FindBy(xpath = "//*[@id=\"Req_RR_Fup_Attachment\"]/div/div[1]/span/span[2]")
	public static WebElement attachmnt;

	@FindBy(id = "Req_RR_Btn_Reset")
	public static WebElement resetbtn;

	@FindBy(id = "Req_RR_Btn_Submit")
	public static WebElement submitbtn;
	
	
	@FindBy(xpath ="//*[@id=\"Req_RR_Cal_LastWorkDate\"]/span/div/div/div/div[1]/button[2]/span")
	public static WebElement paginator;
	
	
	@FindBy(xpath ="//*[@id=\"Req_RR_Cal_LastWorkDate\"]/span/div/div/div/div[2]/table/tbody/tr[4]/td[5]/span")
	public static WebElement datesel;
	
	

	
	
	//////***********End of Service***********//////////////////
	
	
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



	
	public static void resapply(String Notes) {
		RequestCommonObjects.recalendar.click();
		RequestCommonObjects.paginator.click();
		RequestCommonObjects.datesel.click();
		RequestCommonObjects.reasontxt.sendKeys("Prolonged illness");
	
		
		
	}
}
