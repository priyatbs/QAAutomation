package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Billingpage {

	@FindBy(xpath="//div[@class='billingSection']/app-billing-header")
	public static WebElement billingheader;
	
	@FindBy(xpath="//div[@class='headerContent order_no']/span")
	public static WebElement invoice;
	
	@FindBy(xpath="//button[contains(@class,'p-element p-button-raised defaultBtn actionButton secondaryBtnColor2 btnMargin p-button p-component')]/span")
	public static WebElement checkout;
	
	@FindBy(xpath="//div[contains(@class, 'ng-trigger ng-trigger-animation ng-tns')]")
	public static WebElement paymentpage;
	
	@FindBy(xpath="//div[@class='p-element ng-trigger ng-trigger-animation ng-tns-c15-2 p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")
	public static WebElement noinvoicealert;
	
	@FindBy(xpath="//div[@class='p-dialog-header ng-tns-c15-2 ng-star-inserted']/span[@id='pr_id_3-label']")
	public static WebElement alertheader;
	
	@FindBy(xpath="//div[@class='ng-tns-c15-2 p-dialog-content']/p")
	public static WebElement alertmessage;

	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/p-dialog[1]/div/div/div[1]/div/button")
	public static WebElement alertclose;
	
	@FindBy(xpath="//div[@class='infoSection']/span[@class='page-title totalSec']")
	public static WebElement totalvalue;
	
	@FindBy(xpath="//input[@id='Amount']")
	public static WebElement payamountvalue;

	
	@FindBy(xpath="//div[@class='payment_type_sec']/div/button")
	public static List<WebElement> paymenttype;
	
	@FindBy(xpath="//div[@class='inner_payment']/p[@class='amount']")
	public static WebElement paidamount;
	
	
	@FindBy(xpath="//input[@id='captureCard']")
	public static WebElement capturecardcheckbox;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-payment/p-dialog[2]/div/div")
	public static WebElement capturecard;
	
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-payment/p-dialog[2]/div/div/div[2]/div[2]/div/button[2]/span")
	public static WebElement capturecardok;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-payment/div[1]/div[2]/div/div/div[2]/button")
	public static WebElement paymentok;
	
	@FindBy(xpath="//*[@id=\"ItemCard\"]/div[1]/div/img")
	public static WebElement itemclick;
	
	@FindBy(xpath="//div[@class ='amountContainer']/input")
	public static WebElement Payamount;
	
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/div/div[2]/button[1]/span")
	public static WebElement paycash;
	
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-item-management/div/div/div[2]/button[1]/span")
	public static WebElement preorder;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-item-management/div/div/div[2]/button[1]/span")
	public static WebElement createorder;
	
	@FindBy(xpath="//table[@id='pr_id_6-table']/tbody/tr")
	public static List<WebElement> updatetabledata;
	
	
	@FindBy(xpath="//table[@id='pr_id_9-table']/tbody/tr")
	public static List<WebElement> inserttabledata;
	
	//Bill breakup

	@FindBy(xpath="//app-billing-payment/div/div[1]/div[1]/div[1]/div[1]/span[2]")
	public static WebElement subtotal;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/div/div[1]/div[1]/div[1]/div[2]/span[2]")
	public static WebElement Discount;
	
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/div/div[1]/div[1]/div[1]/div[3]/span[2]")
	public static WebElement ItemDiscount;
	
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/div/div[1]/div[1]/div[1]/div[4]/span[2]")
	public static WebElement VAT;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/div/div[1]/div[1]/div[2]/div/span[2]")
	public static WebElement Total;
	
	@FindBy(xpath="//div[@class='infoSection']/span/img[@class='imageBtn']")
	public static WebElement Billdiscount;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div']")
	public static WebElement Billdiscountpopup;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-billing-discount/div[2]/div[2]/button/span")
	public static WebElement Billdiscountokbtn;
	
	
	@FindBy(xpath="//input[@placeholder='Amount']")
	public static WebElement Billdiscountamount;
	
	@FindBy(xpath="//table[@class='p-datatable-table ng-star-inserted']/thead/tr/th")
	public static List<WebElement> Billingtableheader;
	
	@FindBy(xpath="//table[@class='p-datatable-table ng-star-inserted']/tbody/tr")
	public static List<WebElement> Billingtableitems;
	
	@FindBy(xpath="//input[@name='quantity']")
	public static List<WebElement> Billingitemsqty;
	
	@FindBy(xpath="//table[@class='p-datatable-table ng-star-inserted']/tbody/tr/td/p-tablecheckbox[@class='p-element billingCheckbox ng-star-inserted']/div")
	public static List<WebElement> billingtablecheckbox;
	
	@FindBy(xpath="//div[@class='tableContent tableContent1']/span[@class='tableLabel']")
	public static WebElement orderno;
}
