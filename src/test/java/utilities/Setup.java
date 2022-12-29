package utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.grid.Main;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Setup {
	public static WebDriver driver;
	public static Properties prop;
	public static JdbcTemplate jdbcTemplate;

	public static void configfileread() throws IOException {
		prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("config.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		databaseConnection();
		// property=prop.getProperty("key");
	}

	public static void databaseConnection() {
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dataSource.setUrl(prop.getProperty("dburl"));
			dataSource.setUsername(prop.getProperty("dbusername"));
			dataSource.setPassword(prop.getProperty("dbpassword"));
			jdbcTemplate = new JdbcTemplate(dataSource);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public static void takeScreenShot(String fileName) throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File(prop.getProperty("fileWithPath") + fileName + ".jpeg");
		try {
			FileUtils.copyFile(srcFile, DestFile);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public static void extendReport(String testName, String testDesc) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Reports/POS.html"));
		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest(testName, testDesc);
		// creates a toggle for the given test, add all log events under it

	}

}
