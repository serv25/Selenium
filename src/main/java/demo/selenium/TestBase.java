package demo.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import demo.selenium.utils.ConfigUtil;
import demo.selenium.utils.EnvironmentUtil;
import demo.selenium.utils.ReportUtil;

public class TestBase {

	private final Logger log = Logger.getLogger(TestBase.class);
	protected static ExtentReports report;
	protected static ExtentTest test;
	protected static WebDriver driver;
	protected static String host;
	protected static Long implicitWaitTime;
	protected static Long pageLoadTime;

	@BeforeSuite
	public void beforeSuite() {
		report = ReportUtil.getReport();
		host = EnvironmentUtil.getProperty("host");
		implicitWaitTime = ConfigUtil.getImplicitWaitTimeProperty();
		pageLoadTime = ConfigUtil.getPageLoadTimeProperty();
	}

	@BeforeTest
	public void beforeTest() {
		driver = DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
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

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		log.info("\n----------Start test " + result.getMethod().getMethodName() + "----------");
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

		log.info("\n----------Finish test " + result.getMethod().getMethodName() + "----------");
	}
}
