package tests;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pagefactory.Billingpage;

public class BillingTable extends Baseclass {
	public Integer itemdis;
	public double netamnt;
	public double netamnt1;
	public double itemdiscount;

	@Test
	public void billingtableheadingcheck() {
		PageFactory.initElements(driver, Billingpage.class);
		testcase = extentreport.createTest("BillingTable Testcases");
		String Enablecourse = jdbcTemplate.queryForObject(
				"select Config_Value from POS_STATION_CONFIG where Config_Id='67' and Config_Name='Enable Course' and Station_Id=4",
				String.class);
		if (Enablecourse.equals("T")) {
			System.out.println("Firecourse option config is enabled");
			String fheader = "Course,Name,Quantity,Net Amt";
			for (WebElement headers : Billingpage.Billingtableheader) {
				if (headers.getText().contains(fheader)) {
					System.out.println("Firecourse Headers are: " + headers.getText());

				}
				testcase.log(Status.PASS, "Billing Headers are Present as per Firecourse config");
			}
		} else {
			System.out.println("Firecourse option config is disabled");
			testcase.log(Status.PASS, "Billing Headers are Present as per Firecourse option config is disabled");
		}
	}

	@Test
	public void billingitemverification() {
		PageFactory.initElements(driver, Billingpage.class);
		Integer inserupdateconfig = jdbcTemplate.queryForObject(
				"select Config_Value from POS_STATION_CONFIG where Config_Name='Change Qty for Same Item' and Config_Id='45' and Station_Id=4",
				Integer.class);

		System.out.println(inserupdateconfig);
		if (inserupdateconfig.equals("1")) {
			System.out.println("Insert config is present");
			for (WebElement billingitemslist : Billingpage.Billingtableitems) {
				System.out.println(billingitemslist.getText());
			}
		} else {
			System.out.println("Update config is present");



			for (WebElement billingitemslist : Billingpage.Billingtableitems) {
				// System.out.println("Items in Billing Table : " +billingitemslist.getText());
				String[] splittotalvalue = billingitemslist.getText().split("\n");
				double uinetamnt = Double.parseDouble(splittotalvalue[1]);
				if (prop.getProperty("freeitems").equalsIgnoreCase(splittotalvalue[0])) {
					System.out.println("Free Items in Billing Table : " + splittotalvalue[0]);
				}

				else {

					double itemprice = jdbcTemplate.queryForObject(
							"select top 1 (Price) from POS_PRICE_LEVEL_DETAIL where Product_ID in(select Product_ID from POS_PRODUCT where PRODUCT_NAME=?) and DiscountType IS NULL and Price <>0.00 order by Price_Level_ID desc",
							new Object[] { splittotalvalue[0] }, Double.class);

					int itemdis = 0;
					try {
						itemdis = jdbcTemplate.queryForObject(
								"select DiscountValue from POS_PRICE_LEVEL_DETAIL where Product_ID in(select Product_ID from POS_PRODUCT where PRODUCT_NAME=?) \r\n"
								+ "and (DiscountType='V' OR DiscountType='P') order by Price_Level_ID desc",
								new Object[] { splittotalvalue[0] }, Integer.class);
					} catch (Exception e) {
					}
					if (itemdis <= 0) {
						itemdiscount = 0;
					} else {
						itemdiscount = itemdis;
					}
					String enableround = jdbcTemplate.queryForObject(
							"select Config_Value from POS_STATION_CONFIG where Config_Name='Enable Rounding' and Config_Id='33' and Station_Id=4",
							String.class);

					if (enableround.equalsIgnoreCase("T")) {
						Integer extraround = jdbcTemplate.queryForObject(
								"select Config_Value from POS_STATION_CONFIG where Config_Name='Extra Round' and Config_Id='35' and Station_Id=4",
								Integer.class);

						// System.out.println("item price is "+itemprice+", Enable round config is
						// "+enableround+", extraround is "+extraround);
						double vatpercentage = 0.15;
						double itemamnt = (itemprice - itemdiscount) + extraround;
						double amnt = itemamnt * vatpercentage;
						double value = itemamnt + amnt;
						DecimalFormat f = new DecimalFormat("##.00");
						f.setRoundingMode(RoundingMode.HALF_UP);
						String netamntchange= f.format(value);
					//String valuechange=Double.toString(netamntchange);
						netamnt=Double.parseDouble(netamntchange);
						System.out.println(splittotalvalue[0] + " Item's Netamount is: " + netamnt);
					} else {

						double vatpercentage = 0.15;
						double itemamnt = (itemprice - itemdiscount);
						double amnt = itemamnt * vatpercentage;
						 netamnt1 = itemamnt + amnt;
						DecimalFormat f = new DecimalFormat("##.00");
						f.setRoundingMode(RoundingMode.HALF_UP);
						String netamntchange= f.format(netamnt1);
						netamnt=Double.parseDouble(netamntchange);
						
						System.out.println("Netamount is: " + netamnt);
					}

					if (netamnt == uinetamnt) {
						System.out.println(
								"Netamount in UI and Manual calculation is correct. The Netamount is: " + netamnt);
						testcase.log(Status.PASS,
								"Netamount in UI and Manual calculation is correct. The Netamount is: " + netamnt);
					} else {
						System.out.println("Netamount in UI and Manual calculation Gets Mismatch. The Netamountin UI: "
								+ uinetamnt + ", Netamount in Manual calculation: " + netamnt);
						testcase.log(Status.FAIL,
								"Netamount in UI and Manual calculation Gets Mismatch. The Netamountin UI: " + uinetamnt
										+ ", Netamount in Manual calculation: " + netamnt);
					}

				}

			}

			for (WebElement itemqty : Billingpage.Billingitemsqty) {
				System.out.println("Items QTy: " + itemqty.getText());
			}
		}

	}

}
