package tests;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Billingpage;

public class Billbreakup extends Baseclass{
	double itempricesum =0,dbitemdiscount,dbitemprice;
	double dbsubtotal,vatpercentage=0.15,subtotal;
	int dbitemdis = 0;
	double dis =0,sumdis;
	double extraround;
	
@Test
public void breakup() {
	PageFactory.initElements(driver, Billingpage.class);
	testcase =extentreport.createTest("Bill breakup section");
	//split bill breakup section
	
	String totalval[] = Billingpage.subtotal.getText().split(" "); 
	double subtotalUI =Double.parseDouble(totalval[1]);
	
	String disc[] = Billingpage.Discount.getText().split(" "); 
	double discount =Double.parseDouble(disc[1]);
	
	String[] itemdisc = Billingpage.ItemDiscount.getText().split(" "); 
	double itemdiscount =Double.parseDouble(itemdisc[1]);
	
	String vat[] = Billingpage.VAT.getText().split(" ");
	double VAT =Double.parseDouble(vat[1]);
	
	String total[] = Billingpage.Total.getText().split(" "); 
	double Total =Double.parseDouble(total[1]);
	
	// billing table UI and taking item price and discount from db and sum up
	for (WebElement billingitemslist : Billingpage.Billingtableitems) {
		String[] splittotalvalue = billingitemslist.getText().split("\n");
		double uinetamnt = Double.parseDouble(splittotalvalue[1]);
		
		if (prop.getProperty("freeitems").equalsIgnoreCase(splittotalvalue[0])) {
			System.out.println("Free Items in Billing Table : " + splittotalvalue[0]);
		}else {
			try {
				extraround = jdbcTemplate.queryForObject(
						"select Config_Value from POS_STATION_CONFIG where Config_Name='Extra Round' and Config_Id='35'",
						Double.class);
				dbitemprice = jdbcTemplate.queryForObject(
					"select top 1 (Price) from POS_PRICE_LEVEL_DETAIL where Product_ID in(select Product_ID from POS_PRODUCT where PRODUCT_NAME=?) and DiscountType IS NULL order by Price_Level_ID desc",
						new Object[] { splittotalvalue[0] }, Double.class);
				dbitemdis = jdbcTemplate.queryForObject(
						"select top 1 (Price) from POS_PRICE_LEVEL_DETAIL where Product_ID in(select Product_ID from POS_PRODUCT where PRODUCT_NAME=?) and DiscountType='V' order by Price_Level_ID desc",
						new Object[] { splittotalvalue[0] }, Integer.class);
				
			} catch (Exception e) {}

			if (dbitemdis <= 0) {
				dbitemdiscount = 0;
			} else { dbitemdiscount = dbitemdis;}
			
			
			sumdis = dbitemdiscount + dis;
			dis = sumdis;
			
			subtotal = dbitemprice + extraround + itempricesum;
			itempricesum = subtotal;
									
			if(itempricesum == subtotalUI) {
				
				//dis =qty* dis;
				Billingpage.Billdiscount.click();
				String userdis =prop.getProperty("billdiscount");
				double userbilldiscount =Double.parseDouble(userdis);
				if(subtotalUI >= userbilldiscount) {
					Billingpage.Billdiscountamount.sendKeys(userdis);
					Billingpage.Billdiscountokbtn.click();
					}else { System.out.println("Bill Discount is greater than billing amount");
					testcase.log(Status.FAIL, "Bill Discount is greater than billing amount");
					}	
				
				if(dis == itemdiscount) {
					subtotal = subtotal- itemdiscount;
					//double vattotal = Precision.round(subtotalUI * vatpercentage,2);
					double vattotal = subtotalUI * vatpercentage;
					DecimalFormat f = new DecimalFormat("##.00");
					f.setRoundingMode(RoundingMode.HALF_UP);
					System.out.println(f.format(vattotal)); 
					System.out.println("vattotal :" +vattotal);
					if(vattotal == VAT) {
						double subvattotal = subtotalUI + vattotal;
						System.out.println("subvattotal :" +subvattotal);
						testcase.log(Status.PASS,"SubTotal with VAT displayed in UI is match with calculated VAT");
						if(subvattotal == Total ) {
							System.out.println("total :" +subvattotal);
							testcase.log(Status.PASS,"Total displayed in UI is match with calculated total");
						}
					}
				}
			}
		}
	
		}
		System.out.println("Item discount Billing Table : " + dis);
		System.out.println("Total in Billing Table : " + itempricesum);
		}

}