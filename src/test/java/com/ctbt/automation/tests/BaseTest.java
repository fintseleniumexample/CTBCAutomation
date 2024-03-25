package com.ctbt.automation.tests;


import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.ctbt.automation.listeners.CustomTestNGReporter;
import com.ctbt.automation.report.ExtentReportManager;
import org.openqa.selenium.Dimension;
import org.testng.TestRunner;
import org.testng.annotations.BeforeClass;
import com.ctbt.automation.context.Constants;
import com.ctbt.automation.context.WebDriverContext;
import com.ctbt.automation.listeners.LogListener;
import com.ctbt.automation.listeners.ReportListener;
import com.ctbt.automation.util.LoggerUtil;
import com.ctbt.automation.util.MailUtil;
import com.ctbt.automation.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static com.ctbt.automation.util.Gpt3ApiRequestXMLReader.getOpenAIOpnion;

/**
 * Every test class should extend this calss.
 *
 * @author Satheesh Guduru
 */
@Listeners({ ReportListener.class, LogListener.class , CustomTestNGReporter.class})
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.log("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * Wrap all up.
	 *
	 * @param context the context
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		boolean mailSent = MailUtil.sendMail(total, passed, failed, skipped);
		LoggerUtil.log("Mail sent : " + mailSent);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

	/**
	 * Setup.
	 */
	@BeforeMethod
	protected void setup() {
	System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		//WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		//ops.addArguments("--incognito");
		//ops.addArguments("disable-infobars");
		//ops.setExperimentalOption("devtools", true);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
		navigateToBaseUrl();
	}
	public WebDriver selenoidDriver(){
try {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setBrowserName("chrome");
	capabilities.setVersion("120"); // Or specify a specific version

	// Set Selenoid URL
	String selenoidUrl = "http://localhost:4444/wd/hub"; // Change to your Selenoid URL

	// Create WebDriver instance
	 driver = new RemoteWebDriver(new URL(selenoidUrl), capabilities);
}catch (Exception e){
e.printStackTrace();
}
		return driver;
	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
	public void navigateToBaseUrl() {
		String baseUrl = TestProperties.getProperty("base.url");
		driver.get(baseUrl);
		driver.manage().deleteAllCookies();
	}
	public void navigateToCRMApplication(){
		if (isResponsiveView()) {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
			setup();
		}

		String crmBaseUrl = TestProperties.getProperty("crmbase.url");
		driver.get(crmBaseUrl);

	}

	public void openAppinMobileView(){
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--window-size=375,812"); // Set your desired window size
		chromeOptions.addArguments("--start-maximized"); // Maximize the window
		chromeOptions.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1"); // Emulate iPhone user agent
		// Set the path to the chromedriver executable
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);

		// Initialize WebDriver with Chrome options
		 driver = new ChromeDriver(chromeOptions);

		WebDriverContext.setDriver(driver);
		navigateToBaseUrl();
	}
	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {

	}
	@BeforeSuite
	public void afterSuite() {
		String reportFilePath = "./reports/testng-results.xml";
		File reportFile = new File(reportFilePath);
		if (reportFile.exists()) {
			if (reportFile.delete()) {
				System.out.println("TestNG report deleted successfully from: " + reportFilePath);
			} else {
				System.out.println("Failed to delete TestNG report from: " + reportFilePath);
			}
		} else {
			System.out.println("TestNG report not found at: " + reportFilePath);
		}

	}
	@BeforeClass
	public void setupClassName(ITestContext context) {
	}
	public boolean isResponsiveView(){
		Dimension windowSize = driver.manage().window().getSize();

		// Check if the window size matches the expected dimensions
		int expectedWidth = 515;
		int expectedHeight = 738;
		boolean isResponsive = windowSize.getWidth() == expectedWidth && windowSize.getHeight() == expectedHeight;

		return isResponsive;
	}
}
