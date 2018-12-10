package com.curahealthecareTestNG.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.curahealthecareTestNG.Utilities.BrowserUtils;
import com.curahealthecareTestNG.Utilities.ConfigurationReader;
import com.curahealthecareTestNG.Utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;
	protected Actions actions;
	protected ExtentReports report;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentTest extentLogger;
	
	
	@BeforeTest
	public void setUpTest() {

		report = new ExtentReports();
		String filePath = System.getProperty("user.dir") + "/test-output/report.html";
		htmlReporter = new ExtentHtmlReporter(filePath);
		report.attachReporter(htmlReporter);
		report.setSystemInfo("ENV", "staging");
		report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		htmlReporter.config().setReportName("CURA Healthcare Service Automated Test Reports");
	}
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional String browser) {
		driver = Driver.getDriver(browser);
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();

		driver.get(ConfigurationReader.getProperty("url"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotLocation = BrowserUtils.getScreenshot(result.getName());

			extentLogger.fail(result.getName());

			extentLogger.addScreenCaptureFromPath(screenshotLocation);

			extentLogger.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test Case Skipped is " + result.getName());
		}
		Driver.closeDriver();
		
	}
	@Parameters({"browser"})
	@AfterTest
	public void tearDownTest(String browser) {
		Driver.closeDriver();
		report.flush();

	}

}
