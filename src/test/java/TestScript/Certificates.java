package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Certificates extends BaseClass {
	
	  @Test(priority = 0) // (enabled=false)
	  
	  public void salarydoc() throws InterruptedException { 
	  
	  testcase = extentreport.createTest(" Salary Certificate Apply"); 
	  WebElement requestclk = driver.findElement(By.xpath("//div[@class='menu-scroll-content']/ul/li[3]"));
	  requestclk.click(); 
	  WebElement salaryoptnselect = driver.findElement(By.xpath("//div[@class='menu-scroll-content']/ul/li[3]/ul/li[3]")); 
	  salaryoptnselect.click(); 
	  WebElement insname = driver.findElement(By.xpath("//div[@class='card']/div[1]/div[1]/input"));
	  insname.sendKeys("TestInstitute"); 
	  WebElement lanuguage =driver.findElement(By.xpath("//div[@class='card']/div[1]/div/span/p-dropdown/div/span"));
	  lanuguage.click(); 
	  WebElement lanselect = driver.findElement( By.xpath("//div[@class='card']/div[1]/div/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[1]/li")); 
	  lanselect.click(); 
	  WebElement purpose = driver.findElement(By.xpath("//div[@class='card']/div[1]/div/div/textarea"));
	  purpose.sendKeys("testdata"); 
	  WebElement submitbtn =driver.findElement(By.xpath("//div[@class='header']/div[2]/button[2]/span"));
	  submitbtn.click(); 
	  Thread.sleep(2000);
	  WebElement okbtn =
	  driver.findElement(By.xpath("//*[@id='Btn_Confirm']/div/div/div/button")); 
	  // *[@id="Btn_Confirm"]/div/div/div[3]/button // 
	  okbtn.click();
	  testcase.log(Status.PASS, " Salary Certificate Applied Successfully"); }
	 
	
	/*
	 * @Test (priority =1) //(enabled=false) (priority=1) public void
	 * Experiencedoc() {
	 * 
	 * 
	 * testcase = extentreport.createTest(" Experience Certificate Apply");
	 * WebElement requestclk=driver.findElement(By.xpath(
	 * "//div[@class='menu-scroll-content']/ul/li[3]")); requestclk.click();
	 * 
	 * WebElement expoptnselect=driver.findElement(By.xpath(
	 * "//div[@class='menu-scroll-content']/ul/li[3]/ul/li[4]"));
	 * expoptnselect.click(); WebElement insname=driver.findElement(By.xpath(
	 * "//div[@class='card']/div[1]/div[1]/input"));
	 * insname.sendKeys("TestInstitute"); WebElement
	 * lanuguage=driver.findElement(By.xpath(
	 * "//div[@class='card']/div[1]/div/span/p-dropdown/div/span"));
	 * lanuguage.click(); WebElement lanselect=driver.findElement(By.xpath(
	 * "//div[@class='card']/div[1]/div/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[1]/li"
	 * )); lanselect.click(); WebElement purpose=driver.findElement(By.xpath(
	 * "//div[@class='card']/div[1]/div/div/textarea"));
	 * purpose.sendKeys("testdata"); WebElement
	 * submitbtn=driver.findElement(By.xpath(
	 * "//div[@class='header']/div[2]/button[2]/span")); submitbtn.click();
	 * driver.quit(); testcase.log(Status.PASS,
	 * "Experience Certificate Applied Successfully");
	 * 
	 * WebElement okbtn=driver.findElement(By.
	 * xpath("//div[contains(@class, 'p-confirm-dialog')]/div[3]/button"));
	 * okbtn.click(); }
	 */
	  
	
	    
		
	/*
	 * WebElement okbtn=driver.findElement(By.
	 * xpath("//div[contains(@class, 'p-confirm-dialog')]/div[3]/button"));
	 * okbtn.click();
	 */
		 
	}
	 
	
	
	/*
	 * @Test (priority =1)//(enabled=false) (priority=3) public void overtime() {
	 * 
	 * testcase = extentreport.createTest("OverTime Apply"); WebElement
	 * requestclk=driver.findElement(By.xpath(
	 * "//div[@class='menu-scroll-content']/ul/li[3]")); requestclk.click();
	 * 
	 * 
	 * WebElement OToptnselect=driver.findElement(By.xpath(
	 * "//div[@class='menu-scroll-content']/ul/li[3]/ul/li[11]"));
	 * OToptnselect.click(); WebElement date=driver.findElement(By.xpath(
	 * "//form/div/span/div[2]/section/div/div[1]/span/p-calendar[1]/span/input"));
	 * date.sendKeys("30-10-2022"); // driver.findElement(By.xpath(
	 * "//*[@id='Req_OT_Cal_StartDate']/span/div/div/div/div[2]/table/tbody/tr[5]/td[2]"
	 * )).click(); WebElement stime=driver.findElement(By.xpath(
	 * "//form/div/span/div[2]/section/div/div[2]/span/p-calendar[1]/span/input"));
	 * stime.sendKeys("01:20"); WebElement etime=driver.findElement(By.xpath(
	 * "//form/div/span/div[2]/section/div/div[3]/span/p-calendar[1]/span/input"));
	 * etime.sendKeys("03:20"); WebElement submitbtn=driver.findElement(By.xpath(
	 * "//div[@class='header']/div[2]/button[3]/span")); submitbtn.click();
	 * testcase.log(Status.PASS,"Overtime Applied Successfully"); // WebElement
	 * okbtn=driver.findElement(By.xpath( //
	 * "//*[@id=\"Btn_Confirm\"]/div/div/div[3]/button")); // // okbtn.click(); }
	 */
	 
	 
	  
	
	/*
	 * @Test//(enabled=false) (priority=4) public void expenseclaim() { testcase =
	 * extentreport.createTest("Expense Claim Apply"); WebElement
	 * requestclk=driver.findElement(By.xpath(
	 * "//div[@class='menu-scroll-content']/ul/li[3]")); requestclk.click();
	 * 
	 * WebElement expenseoptnselect=driver.findElement(By.xpath(
	 * "//div[@class='menu-scroll-content']/ul/li[3]/ul/li[12]"));
	 * expenseoptnselect.click(); WebElement
	 * desc=driver.findElement(By.xpath("//form/div[2]/section/div/div[1]/input"));
	 * desc.sendKeys("test description"); WebElement
	 * billno=driver.findElement(By.xpath("//form/div[2]/section/div/div[4]/input"))
	 * ; billno.sendKeys("5"); WebElement
	 * amnt=driver.findElement(By.xpath("//form/div[2]/section/div/div[6]/input"));
	 * amnt.sendKeys("100"); WebElement submitbtn=driver.findElement(By.
	 * xpath("//div[contains(@class, 'card')]/div/button[2]")); submitbtn.click();
	 * testcase.log(Status.PASS,"Expense Claim applied Successfully"); // WebElement
	 * okbtn=driver.findElement(By. //
	 * xpath("//div[contains(@class, 'p-confirm-dialog')]/div[3]/button")); //
	 * okbtn.click(); }
	 */
	  
	 