
package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Tablespage;

public class Tablesfunc extends Baseclass{

	String areaquery = "select AreaNameE from POS_AreaStation inner join POS_Area on POS_AreaStation.AreaCode=POS_Area.AreaCode where Station_Id=1 and status='A';";
	String noofpersonquery ="select Config_Value from POS_STATION_CONFIG where Config_Id=39 and Config_Name='Enter number of persons' and Station_Id=4";
	String startuptablequery ="select Config_Value from POS_STATION_CONFIG where Config_Id=42 and Config_Name='Startup With Table';";
	String dbtablestatus="select count(*) from POS_AreaTable where TableNameE=? and TableStatus='A'";
	String dbtableseats="select TableSeats from POS_AreaTable where TableNameE=?";
			
	@Test
	public void tablesUI() {
		testcase =extentreport.createTest("Tables UI Screen");
		PageFactory.initElements(driver, Tablespage.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-12 zeroPadding']/button/span[text()='Tables']")));
		element.click();
		if(Tablespage.Tableshomepage.isDisplayed()) {

			if(Tablespage.Tablesheader.getText().equalsIgnoreCase("Tables")) {
				testcase.log(Status.PASS,"Table header is:  "+Tablespage.Tablesheader.getText());
			}
			else {
				testcase.log(Status.FAIL,"Table header is not present:  "+Tablespage.Tablesheader.getText());
			}
		}else {
			testcase.log(Status.FAIL,"Is table is opened or not?:  "+Tablespage.Tableshomepage.isDisplayed());
		}
		
	}

	@Test(dependsOnMethods="tablesUI")
		
	public void tablesvalidation(){
		testcase =extentreport.createTest("Verify given Table Area and Table name/status with screen");
		PageFactory.initElements(driver, Tablespage.class);
		String areaname = prop.getProperty("tableAreaname");
		String tablename = prop.getProperty("tablename");
		String tablestatus=jdbcTemplate.queryForObject(dbtablestatus,
				new Object[] {prop.getProperty("tablename")}, String.class);
		for(WebElement tablearea : Tablespage.Areaname)
		{
			if(tablearea.getText().equalsIgnoreCase(areaname)) {
				tablearea.click();
				testcase.log(Status.PASS,"Selected Table area is:  "+tablearea.getText());
				for(WebElement tblname : Tablespage.TableItems) {
					System.out.println(tblname.getText());
					if(tablestatus.equals("1")){
						if(tblname.getText().equalsIgnoreCase(tablename)){
							tblname.click();
							testcase.log(Status.PASS,"GivenTable is:  "+tblname.getText());
							break;
						}
					}else {
						testcase.log(Status.FAIL,"GivenTable is not available:  "+tablearea.getText());
				}
			}
		}
		}
 }	
	
	@Test(dependsOnMethods="tablesvalidation")
	public void selectpersons(){
		testcase =extentreport.createTest("Verify given no of persons with seat capacity of table in Screen");
		PageFactory.initElements(driver, Tablespage.class);
		String noofpersons=prop.getProperty("noofpersons");
		Integer tableseats=jdbcTemplate.queryForObject(dbtableseats,
				new Object[] {prop.getProperty("tablename")}, Integer.class);
		String dbnoofperson_config =jdbcTemplate.queryForObject(noofpersonquery,String.class);
		String userseatscount=prop.getProperty("noofpersons");
		int userseatcount=Integer.parseInt(userseatscount);
		if(dbnoofperson_config.equalsIgnoreCase("T")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(Tablespage.SelectNoofPersons.isDisplayed()) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				if(tableseats >= userseatcount) {
					Tablespage.Selectnoofpersons();
					testcase.log(Status.PASS," Given No of persons is equal or below seat capacity");
					if(Tablespage.Headername.isDisplayed()) {
						testcase.log(Status.PASS,"Home page displayed after selection of tables and persons ");
					}else {
						testcase.log(Status.FAIL,"No home page");
					}
				}else {
					if(Tablespage.EnterOk.isEnabled()) {
						testcase.log(Status.FAIL,"Given user count is greater than seat capacity");
					}else {
						testcase.log(Status.PASS,"Given user count is greater than seat capacity");
				}
			}
	
		}else if(Tablespage.Headername.isDisplayed())
			{
			
			testcase.log(Status.PASS,"Home page present after table selection "+Tablespage.Headername.getText());
			}
			
		}
	}

}




