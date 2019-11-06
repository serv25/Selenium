package demo.selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import demo.selenium.utils.ConfigUtil;
import demo.selenium.utils.EnvironmentUtil;
import demo.selenium.utils.ReportUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    public void afterMethod(ITestResult result) throws IOException {

        int status = result.getStatus();
        String testName = result.getMethod().getMethodName();

        if (status == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test " + testName + " failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(getScreenshotPath(testName));
        } else if (status == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test " + testName + " is passed");
        } else if (status == ITestResult.SKIP) {
            test.log(Status.SKIP, testName + " is skipped: " + result.getThrowable());
        }
        report.flush();

        log.info("\n----------Finish test " + result.getMethod().getMethodName() + "----------");
    }

    protected String getScreenshotPath(String testName) {
        if (driver == null) {
            return null;
        }

        File destFile = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File screenshotDir = new File(
                System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots");

        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        String screenshotName = testName + "_" + timeStamp + ".png";

        try {
            destFile = new File(screenshotDir + File.separator + screenshotName);
            Files.copy(scrFile.toPath(), destFile.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }
}
