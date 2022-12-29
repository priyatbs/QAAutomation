package tests;

import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.OrdersPage;

public class Cancelorder extends Baseclass{
	public String orderno = "select OrderNo from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and OrderNo =?";
	public String dbordernocheck;
	@Test	
	public void ordercancel() {
		PageFactory.initElements(driver, OrdersPage.class);
		OrdersPage.Ordersicon.click();
		int num = 0;
		try {
		dbordernocheck = jdbcTemplate.queryForObject(
				"select OrderNo from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype<>'A' and OrderNo=?",
				new Object[] {prop.getProperty("ordernotoselect") }, String.class);
		}catch(Exception e) {}
		if(num < 0) {
			System.out.println("No order number present");
			
		}else {
			for (WebElement os: OrdersPage.ordersselection) {
				if (os.getText().equalsIgnoreCase(dbordernocheck)) {
					OrdersPage.selectcancelitem.click();
					OrdersPage.orderspageokbutton.click();
					OrdersPage.cancelorder.click();
					if(OrdersPage.cancelconfirmationpopup != null) {
						OrdersPage.okconfirmation.click();
						//break;
					}
				}
			}	
		}
	
	}	
	
	@Test(dependsOnMethods="ordercancel")
	public void cancelledordervalidation() {
		PageFactory.initElements(driver, OrdersPage.class);
		try {
		
		for(WebElement order : OrdersPage.ordersselection){
			if (order.getText().equalsIgnoreCase(dbordernocheck)) {
				System.out.println("Order is not cancelled , still exist");
			}else {
				System.out.println("Order is cancelled");
			}
		
			}
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getLocalizedMessage());
	}
	
}
}