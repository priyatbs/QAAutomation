package pagefactory;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage {

	@FindBy(xpath="//div[2]/div[1]/app-item-management/div/div/div[2]/button[2]")
	public static WebElement Ordersicon;
	
	@FindBy(xpath="//div/div/div[@class='header_tittle']")
	public static WebElement ordertitle;
	
	@FindBy(xpath="//div[@class='order_innersec']/div")
	public static List<WebElement> orderdetails;
	
	
	@FindBy(xpath="//div[@class='orders ng-star-inserted' and img[@src='../assets/images/processing.svg'] and  //div[@class='order_number']]")
	public static List<WebElement> preorder;
	
	@FindBy(xpath="//div[@class='orders ng-star-inserted' and img[@src='../assets/images/order.svg'] and  //div[@class='order_number']]")
	public static List<WebElement> createorder;
	
	@FindBy(xpath="//div[@class='status_inner_sec']/div[1]/h4")
	public static WebElement newcount;
	
	
	@FindBy(xpath="//div[@class='status_inner_sec']/div[2]/h4")
	public static WebElement processingcount;
	
	@FindBy(xpath="//div[@class='status_inner_sec']/div[4]/h4")
	public static WebElement totalpendingorders;
	
	@FindBy(xpath="//div[@class='status_inner_sec']/div[5]/h4")
	public static WebElement orderscount;
	
	@FindBy(xpath="//div[@class='status_inner_sec']/div[6]/h4")
	public static WebElement preorderscount;

	@FindBy(xpath="//div[@class='status_button_outer']/button")
	public static WebElement orderspageokbutton;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[1]/app-billing-table/div/div[1]/div[1]/span/span")
	public static WebElement ordernoinbillingheader;
	
	@FindBy(xpath="//div[@class='orders ng-star-inserted']")
	public static List<WebElement> ordersselection;

	
	@FindBy(xpath="/html/body/app-root/app-orders/div/div[2]/div/div/div/div[3]/h5/span")
	public static WebElement tablename;

	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-item-management/div/div/div[2]/button[4]")
	public static WebElement customerreceipt;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-item-management/p-dialog/div/div")
	public static WebElement alert;
	
	@FindBy(xpath="//div[@class='orders ng-star-inserted']")
	public static WebElement selectcancelitem;
	
	@FindBy(xpath="//div[@class='orders ng-star-inserted']/div/span")
	public static WebElement ordercancelitem;

	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[2]/div[1]/app-bill-management/div/div[2]/app-billing-payment/div/div[2]/button[2]/span")
	public static WebElement cancelorder;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div")
	public static WebElement cancelconfirmationpopup;
	
	@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[2]/app-confirmation-popup/div/button[2]/span[3]")
	public static WebElement okconfirmation;
	
	@FindBy(xpath="//div[@class='buttonSec ng-star-inserted']/button")
	public static List<WebElement> fireconfigoptions;

}
