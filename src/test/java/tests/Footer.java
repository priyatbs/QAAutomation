package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Footer extends Baseclass {

	@Test
	public void footer() {
		testcase=extentreport.createTest("POS application Footer Verification");
		List<WebElement> footerpage=driver.findElements(By.xpath("//span[@class='footerDetails']"));
		System.out.println();
		
		for(WebElement footerlist:footerpage) {
			System.out.println(footerlist.getText());
			final String sql= "select Config_Name,Config_Value from POS_STATION_CONFIG where Config_Id in('1','2','4','5','7')";
			jdbcTemplate.query(sql, new RowCallbackHandler(){
				public void processRow(ResultSet resultSet) throws SQLException {
		
					while (resultSet.next()) {
						String Config_name = resultSet.getString("Config_Name");
						String Config_Value = resultSet.getString("Config_Value");
						
					}
					
				}
			});
			testcase.log(Status.PASS, "Footer Testcase got pass");
		}
	}	
}	
	
	
	
	
//	@Test
//	public void FooterTestcase() {
//		List<WebElement> footerpage=driver.findElements(By.xpath("//div[@class='row appFooter']/div/span"));
//		for(WebElement footerlist:footerpage) {
//			System.out.println(footerlist.getText());
//			jdbcTemplate.query("select Config_Name,Config_Value from POS_STATION_CONFIG where Config_Id in('1','2','4','5','7')", new RowCallbackHandler(){
//				public void processRow(ResultSet resultSet) throws SQLException {
//				
//				while (resultSet.next()) {
//					int Config_Name = resultSet.getRow();
//					//int Config_Name = resultSet.getRow();
//				String Config_Value = resultSet.getString("Config_Value");
//				
//				
//				System.out.println(Config_Name+":" +Config_Value);
//				
//				break;
//				}
//				}
//
//				
//
//				}
//
//		
//		)
//			;
//		}
//		
//		
//	}
//}
	

