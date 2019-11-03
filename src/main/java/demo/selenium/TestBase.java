package demo.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import demo.selenium.utils.EnvironmentUtil;
import demo.selenium.utils.ReportUtil;

public class TestBase {

	protected static ExtentReports report;
	protected static ExtentTest test;
	protected static WebDriver driver;
	protected static String host;

	@BeforeSuite
	public void beforeSuite() {
		host = EnvironmentUtil.getProperty("host");
		report = ReportUtil.getReport();
	}

	@BeforeTest
	public void beforeTest() {
		driver = DriverFactory.getDriver();
		//TODO
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@AfterTest
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeClass
	public void beforeClass() {
		test = report.createTest(getClass().getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		int status = result.getStatus();

		if (status == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (status == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getMethod().getMethodName() + " is passed");
		} else if (status == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		report.flush();
	}
}
