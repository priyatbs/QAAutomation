package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Billingpage;
import pagefactory.OrdersPage;

public class Orders extends Baseclass {
	
	public static String ordernotoselect;
	public static String firemethod;
	

	@Test
	//(priority = 0)
	public void aOrdersValidation() {
		testcase = extentreport.createTest("Orders Page Testcases");

		// Below script cross checks the order number details from UI and DB

		PageFactory.initElements(driver, OrdersPage.class);

		OrdersPage.Ordersicon.click();
		if (OrdersPage.ordertitle.isEnabled()) {
			System.out.println("Orders page was open");
		}
		Integer ordercount = jdbcTemplate.queryForObject(
				"select Count(OrderNo) from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype<>'A'",
				Integer.class);
		List<String> orderno = jdbcTemplate.queryForList(
				"select OrderNo from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and OrderStatus='P' and ordertype<>'A' order by OrderNo asc",
				String.class);

		int a = OrdersPage.orderdetails.size();
		if (a == ordercount) {
			for (String ordernoindb : orderno) {
				for (WebElement orders : OrdersPage.orderdetails) {
					if (orders.getText().equals(ordernoindb)) {
						System.out.println("Orders are same as in DB. Pending Ordernumber is " + orders.getText());

						testcase.log(Status.PASS, "Pending Orders are cross checked with DB and UI");
						break;

					}

				}
			}
		} else {
			System.out.println("Order numbers in DB: " + orderno);
			for (WebElement orders : OrdersPage.orderdetails) {
				System.out.println("Order numbers in OrdersPage: " + orders.getText());
			}
			testcase.log(Status.FAIL, "Some Pending Orders are gets mismatch with DB and UI");
		}

	}

	@Test(enabled=false)
	//(priority = 1)
	
	public void bOrderstypeCheck() {
		String orderstatus = "P,N";
		for (WebElement porderdetails : OrdersPage.preorder) {
			// System.out.println("Pre Order number is in Screen: "+
			// porderdetails.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String preorderinvoicedb = jdbcTemplate.queryForObject(
					"select OrderType from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype<>'A' and OrderNo=?",
					new Object[] { porderdetails.getText() }, String.class);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if (orderstatus.contains(preorderinvoicedb)) {
				System.out.println("Pre Ordertype Order Number and Order Type " + porderdetails.getText() + " : "
						+ preorderinvoicedb);
				testcase.log(Status.PASS,
						"Pre Orders are in DB and UI is same. The Order Number is " + porderdetails.getText());
			}

			else
				testcase.log(Status.FAIL,
						"Pre Orders are in DB and UI is not same. The Order Number is " + porderdetails.getText());

		}
		for (WebElement corderdetails : OrdersPage.createorder) {
			// System.out.println("Create Order number is in Screen: "
			// +corderdetails.getText());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String createorderinvoicedb = jdbcTemplate.queryForObject(
					"select OrderType from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and OrderNo=?",
					new Object[] { corderdetails.getText() }, String.class);
			if (createorderinvoicedb.equalsIgnoreCase("O")) {
				System.out.println("Create Ordertype Order Number and Order Type " + corderdetails.getText() + " : "
						+ createorderinvoicedb);
				testcase.log(Status.PASS, "Create orders are in DB and UI is same");
			} else
				testcase.log(Status.FAIL,
						"Create Orders are in DB and UI is not same.The Order Number is " + corderdetails.getText());
		}
	}

	@Test
	//(priority = 2)
	
	public void cOrdersCountCheck() {
		PageFactory.initElements(driver, OrdersPage.class);
		if (OrdersPage.ordertitle.isEnabled()) {

			// New Orders Count check
			// System.out.println("New Orders Count Button is present "
			// +OrdersPage.newcount.getText());
			String str1 = OrdersPage.newcount.getText();
			String newcount = str1.substring(str1.indexOf("(") + 1, str1.indexOf(")"));
			int i = Integer.parseInt(newcount);
			Integer neworderscount = jdbcTemplate.queryForObject(
					"select Count(OrderNo)  from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and OrderStatus='N' and ordertype<>'A'",
					Integer.class);
			if (neworderscount.equals(i)) {
				System.out
						.println("New orders Count in Orders Page is same as DB and UI.The Count is " + neworderscount);
				testcase.log(Status.PASS,
						"New orders Count in Orders Page is same as DB and UI.The Count is " + neworderscount);
			}

			// Processing Orders Count check
			// System.out.println("Processing Orders Count Button is present "
			// +OrdersPage.processingcount.getText());
			String str = OrdersPage.processingcount.getText();
			String answer = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
			// System.out.println(answer);
			int j = Integer.parseInt(answer);
			Integer processingorderscount = jdbcTemplate.queryForObject(
					"select Count(OrderNo)  from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and OrderStatus='P' and ordertype<>'A'",
					Integer.class);
			if (processingorderscount.equals(j)) {
				System.out.println(
						"Processing Count in Orders Page is same as DB and UI.The Count is " + processingorderscount);
				testcase.log(Status.PASS,
						"Processing Count in Orders Page is same as DB and UI.The Count is " + processingorderscount);
			}

			// Total Pending Orders Count check
			// System.out.println("Total Pending Orders Count Button is present "
			// +OrdersPage.totalpendingorders.getText());
			/*
			 * String str3 = OrdersPage.totalpendingorders.getText();
			 * System.out.println(str3); String totalpendings
			 * =str3.substring(str3.indexOf("-")+1, str3.indexOf(" "));
			 * System.out.println(totalpendings); String trimval=totalpendings.trim(); int k
			 * = Integer.parseInt(trimval); System.out.println(k);
			 * //System.out.println("total pending orders:"+totalpendings); String
			 * totalpendingscount=jdbcTemplate.
			 * queryForObject("select Count(OrderNo)  from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype<>'A'"
			 * , String.class); System.out.println(totalpendingscount);
			 * if(totalpendingscount.equals(totalpendings)) { System.out.
			 * println("Total Pending  Orders Count in Orders Page is same as DB and UI.The Count is "
			 * +totalpendingscount); testcase.log(Status.PASS,
			 * "Total Pending  Orders Count in Orders Page is same as DB and UI.The Count is "
			 * +totalpendingscount); }
			 */

			// Orders Count check

			// System.out.println("Orders Count Button is present "
			// +OrdersPage.orderscount.getText());
			String str4 = OrdersPage.orderscount.getText();
			String ordersbuttoncount = str4.substring(str4.indexOf(":") + 1);
			String trimval = ordersbuttoncount.trim();
			int l = Integer.parseInt(trimval);

			// System.out.println("Orders orders:"+ordersbuttoncount);
			Integer orderscountindb = jdbcTemplate.queryForObject(
					"select Count(OrderNo) from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype='O'",
					Integer.class);
			if (orderscountindb.equals(l)) {
				System.out.println("Orders Count in Orders Page is same as DB and UI.The Count is " + orderscountindb);
				testcase.log(Status.PASS,
						"Orders Count in Orders Page is same as DB and UI.The Count is " + orderscountindb);
			}
			// PreOrders Count check

			// System.out.println("Orders Count Button is present "
			// +OrdersPage.preorderscount.getText());
			String str5 = OrdersPage.preorderscount.getText();
			String preorderscount = str5.substring(str5.indexOf(":") + 1);
			String trimvalofpreorderscount = preorderscount.trim();
			int m = Integer.parseInt(trimvalofpreorderscount);
			// System.out.println("totalpending orders:"+ordersbuttoncount);
			Integer preorderscountindb = jdbcTemplate.queryForObject(
					"select Count(OrderNo) from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype='P'",
					Integer.class);
			if (preorderscountindb.equals(m)) {
				System.out.println(
						"Pre-Orders Count in Orders Page is same as DB and UI.The Count is " + preorderscountindb);
				testcase.log(Status.PASS,
						"Pre-Orders Count in Orders Page is same as DB and UI.The Count is " + preorderscountindb);
			}

		}
	}

	
	@Test
	//(priority = 3)

	public void dorderselection() {

		PageFactory.initElements(driver, OrdersPage.class);
		PageFactory.initElements(driver, Billingpage.class);
		for (WebElement orders : OrdersPage.orderdetails) {
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class);
			ordernotoselect=prop.getProperty("ordernotoselect1");
			if (orders.getText().contains(ordernotoselect)) {
				Integer orderno = Integer.parseInt(ordernotoselect);
				String ordertype = jdbcTemplate.queryForObject(
						"select OrderType from POS_INVOICES where SOLD_SUB_TOTAL<>0 and Completed=0 and (OrderStatus='P' or OrderStatus='N') and ordertype<>'A'and user_id=26 and OrderNo=?",
						new Object[] { orderno }, String.class);
				orders.click();
				if (OrdersPage.orderspageokbutton.isEnabled()) {
					OrdersPage.orderspageokbutton.click();

					System.out.println("orders is selected" + ordernotoselect);
					if (OrdersPage.ordernoinbillingheader.getText().equals(ordernotoselect)) {
						System.out.println("Selected order " + ordernotoselect + " is Present in Billing Screen");
						testcase.log(Status.PASS,
								"Selected order " + ordernotoselect + " is Present in Billing Screen");

						String Enablecourse = jdbcTemplate.queryForObject(
								"select Config_Value from POS_STATION_CONFIG where Config_Id='67' and Config_Name='Enable Course' and Station_Id=4",
								String.class);

						if (ordertype.equalsIgnoreCase("O") && Enablecourse.equalsIgnoreCase("T")) {
							for (WebElement fireoptn : OrdersPage.fireconfigoptions) {
								if (fireoptn.getText().equalsIgnoreCase(firemethod)) {

									System.out.println(fireoptn.getText()
											+ " option is present in Billing table for the selected item ");

									for (WebElement item : Billingpage.billingtablecheckbox) {

										if (!item.isSelected()) {
											item.click();
											System.out.println(item.getText() + " Item is selected in billing table");
										}
									}
									fireoptn.click();
									System.out.println("Selected Items are Fired");
									testcase.log(Status.PASS, "Selected Items are Fired");

								}

							}
						}

						else {
							System.out.println("Selected order is preorder/Fire course options are not Enabled ");
							testcase.log(Status.FAIL,
									"Selected order is preorder. and the order number is " + ordernotoselect
											+ " .Fire course options are not Enabled. Config value in DB "
											+ Enablecourse);
						}
					}

				} else
					testcase.log(Status.FAIL,
							"Selected order " + orders.getText() + " is not Present in Billing Screen");

				break;
			}

		}

	}
}
