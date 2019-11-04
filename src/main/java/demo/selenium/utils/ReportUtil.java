package demo.selenium.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil {

	private static final String REPORT_PATH = "test-output" + File.separator + "extent-report.html";
	private static ExtentReports extentReports;

	public static ExtentReports getReport() {
		if (extentReports == null) {
			init();
		}
		return extentReports;
	}

	private static void init() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(REPORT_PATH);
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.STANDARD);

		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Environment", System.getProperty("environment"));
		extentReports.setSystemInfo("Browser", System.getProperty("browser"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.attachReporter(reporter);
	}
}
