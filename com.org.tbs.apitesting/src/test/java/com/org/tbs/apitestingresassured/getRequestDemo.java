package com.org.tbs.apitestingresassured;

import org.apache.logging.log4j.LogManager;  
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class getRequestDemo extends baseClass{

	//@BeforeSuite
	public void setUp() {
		System.out.println("Setup");	
	}
	/*************************************************Get Request******************************************************************/
	//@Test

	public void getReq() {
		testcase = extentreport.createTest("Get API");
		RestAssured.baseURI = "http://192.168.200.18:8080/";
		RestAssured.basePath = "messages/";
		given().when().get().then().log().all().statusCode(200);
		int expected_statuscode = 200;
		int actualcode = given().when().get().getStatusCode();
		long time = given().when().get().getTime();
		String boody = given().when().get().getBody().asString();
		System.out.println(boody);
		System.out.println(actualcode);

		testcase.log(Status.PASS, "testpassed" + " status code is :" + actualcode  + " "  +"Response time:" + time  +boody 
				);

	}

	/*************************************************Post Request******************************************************************/
	@SuppressWarnings("unchecked")
	@Test
	public void postReq() {
		RestAssured.baseURI = "https://iis.thoughtbees.com/emsserver/emsserver.dll/";
		RestAssured.basePath = "login/";
		//String payload = "{\"company_id\":\"000003\",\"entity_type\":\"P\",\"NationalId\":\"1759787698\",\"LoginType\":\"N\",\"password\":\"123456\"}";
		JSONObject jsobj = new JSONObject();
		jsobj.put("company_id", "440099");
		jsobj.put("entity_type","E");
		jsobj.put("id", "0000550055");
		jsobj.put("password", "123456");
		given().body(jsobj).when().post().then().log().all();
	}
	/*************************************************Patch Request******************************************************************/
	// @Test
	public void patchReq() {
		RestAssured.baseURI = "https://reqres.in/api/users/";
		String userData = "{\"name\" : \"aaaa\", " + " \"job\" : \"leader\"}";
		given().body(userData).when().patch().then().log().all().assertThat().statusCode(200);
		// .body(s:"updatedAt", is(notNullValue()));
	}
	/*************************************************Put Request******************************************************************/
	// @Test
	public void putReq() {
		RestAssured.baseURI = "https://reqres.in/api/users/";
		String userData = "{\"name\" : \"aaaa\", " + " \"job\" : \"leader\"}";
		given().body(userData).when().put().then().log().all().assertThat().statusCode(200);

	}
	/*************************************************Delete Request******************************************************************/
	//	@Test
	public void delReq() {
		RestAssured.baseURI = "http://192.168.200.18:8080/Appointments";
		String data = "{\"Authorization\" : \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxNzU5Nzg3Njk4IiwianRpIjoiUCIsImlhdCI6MTY3MTUyOTUzNCwiZXhwIjoxNjcxODc1MTM0LCJpc3MiOiIwMDAwMDMifQ.LH5Ly2QABSUIQduKgODg4vZgCMZXOtUcMFcz4usAmgw\", "
				+ " \"PlannerId\" : \"{3BBB88EB-6858-4AB4-B0FA-D9BC31A57FE1}\", "
				+ " \"AppointDate\" : \"24/12/2022\" , " + " \"AppointType\" : \"A\"}";
		// String token =
		// "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";

		//		  RestAssured.given().header("Authorization", "Bearer " + token)
		//		  .header("Content-Type", "application/json");
		given().body(data).when().delete().then().log().all().assertThat().statusCode(200);
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("TearDown");
	}
	@Test
	public static void jsconexample() {
		testcase = extentreport.createTest("POST API");
		RestAssured.baseURI = "https://iis.thoughtbees.com/emsserver/emsserver.dll/";
		RestAssured.basePath = "login/";
		//String payload = "{\"company_id\":\"440099\",\"entity_type\":\"E\",\"id\":\"0000550055\",\"password\":\"123456\"}";
		JSONObject jsobj = new JSONObject();
		jsobj.put("company_id", "440099");
		jsobj.put("entity_type","E");
		jsobj.put("id", "0000550055");
		jsobj.put("password", "123456");
		//jsobj.put("password", "123456");
		given().
		given().body(jsobj).when().post().then().log().all().statusCode(200);
		int actualcode = given().when().get().getStatusCode();
		long time = given().when().get().getTime();
		System.out.println(given().when().get().statusLine());
		System.out.println(time);
	}
	
	
	public void jiratest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.1.18:8080/");
		driver.findElement(By.id("login-form-username")).sendKeys("sathiyadevi");
		driver.findElement(By.id("login-form-password")).sendKeys("Yuganms@nov");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id = 'aui-responsive-header-dropdown-0-trigger']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated("//*[@id = 'aui-responsive-header-dropdown-0-trigger']"));
		driver.findElement(By.xpath("//*[@id = 'aui-responsive-header-dropdown-0-trigger']")).click();
		List<WebElement> abc = driver.findElements(By.xpath("//div[@id='greenhopper_menu_dropdown_recent']/ul/li"));
		for(WebElement options: abc) {
			System.out.println(options.getText());
		}
	}



}

