package TestScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import PageFactory.CommonObjects;
import PageFactory.LoginCommonObjects;
import PageFactory.RequestCommonObjects;

public class CommonClass extends BaseClass {
	public static HSSFWorkbook Workbook;
	public static HSSFSheet sheet;
	
//*********************Excel read And write common code*********************************
	public static void excelcommonread(String sheetname) throws IOException {
		File file=new File(prop.getProperty("Excel"));
		FileInputStream inputStream = new FileInputStream(file);
		Workbook = new HSSFWorkbook(inputStream);
		sheet=Workbook.getSheet(sheetname);	
	}
	
	public static void excelcommonwrite() throws IOException {
		
		File outputfile=new File(prop.getProperty("Excel"));
		FileOutputStream outputstream=new FileOutputStream(outputfile);
		Workbook.write(outputstream);
	}
	

//*********************Side-Menus selection common code*********************************
	public static void testobjects(String menuname,String submenuname) {

	PageFactory.initElements(driver, CommonObjects.class);
	driver.findElement(By.xpath("//*[@id='Request']")).click();
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy(0,1000)");
	System.out.println(LoginCommonObjects.reqli.size());
	for(int i =0; i<=LoginCommonObjects.reqli.size() -1; i++) {
		if(LoginCommonObjects.reqli.get(i).getText().contains(submenuname)) {
			LoginCommonObjects.reqli.get(i).click();
		}break;
			
			}
			
		}
	
	
	
	
}
