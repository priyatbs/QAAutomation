package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Billingpage;
import pagefactory.OrdersPage;

public class Customerreceipt extends Baseclass{
	public static List<WebElement> tbxpath;
	public static int tablesize;
	
	@Test
	public void customerreceipt() {
		PageFactory.initElements(driver, OrdersPage.class);
		OrdersPage.Ordersicon.click();
		for(WebElement os: OrdersPage.ordersselection) {
			os.click();
			String tblname = OrdersPage.tablename.getText();
			if(!tblname.isEmpty()) {
				OrdersPage.orderspageokbutton.click();
				OrdersPage.customerreceipt.click();
				if(!OrdersPage.alert.isEnabled()) {
					System.out.println("Customer receipt opened");
				}else {
					System.out.println("Fire the items");
				}
			}
			
		}
	
	}
}
