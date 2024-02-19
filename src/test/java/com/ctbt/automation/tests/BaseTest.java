package com.ctbt.automation.tests;

import java.util.concurrent.TimeUnit;

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

import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * Every test class should extend this calss.
 *
 * @author Satheesh Guduru
 */
@Listeners({ ReportListener.class, LogListener.class })
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

//		System.setProperty("webdriver.edge.driver", Constants.EDGE_DRIVER_PATH);
//
//		// Initialize EdgeDriver
//		 driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
		navigateToBaseUrl();
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
		String crmBaseUrl = TestProperties.getProperty("crmbase.url");
		driver.get(crmBaseUrl);

	}
	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {

	}
}