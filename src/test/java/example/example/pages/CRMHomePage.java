package example.example.pages;

import com.relevantcodes.extentreports.LogStatus;
import example.example.util.ReportUtil;
import example.example.util.TestProperties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CRMHomePage extends BasePage {
    @FindBy(xpath = "//div[@title='NRA']/../../..")
    private WebElement nraTab;
    @FindBy(xpath = "//span[text()='NRA Applications']/..")
    private WebElement nraApplicationsLink;
    @FindBy(xpath = "//span[text()='Active NRA Applications']")
    private WebElement nraApplicationTab;
    @FindBy(xpath = "//div[@class='ag-center-cols-container']/div[1]//div[@role='presentation']")
    private WebElement latestNRAApp;
    @FindBy(xpath = "//label[text()='Face Comparison Result']/../../..//select//option[@data-selected='true']")
    private WebElement faceComparisonResult;
    @FindBy(xpath = "//label[text()='KYC Onboarding Status']/../../..//select//option[@data-selected='true']")
    private WebElement kycOnboardingStatus;

    public CRMHomePage(WebDriver driver) {
        super(driver);
    }
    public void clickNRAATab() {
        driver.switchTo().frame("AppLandingPage");

        waiter.until(ExpectedConditions.visibilityOf(nraTab));
        waiter.until(ExpectedConditions.elementToBeClickable(nraTab));
        nraTab.click();
        waitFor(3);
        driver.switchTo().defaultContent();
    }

        public void clickNRAApplicationsLink() {
        waiter.until(ExpectedConditions.visibilityOf(nraApplicationsLink));
        nraApplicationsLink.click();
            waitFor(3);
    }
    public void verifyNraApplicationTab() {
        waiter.until(ExpectedConditions.visibilityOf(nraApplicationTab));
        Assert.assertTrue(nraApplicationTab.isDisplayed(), "Active NRA Applications is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Active NRA Applications page displayed");
    }
    public void clickFirstNRAApp() {
        waiter.until(ExpectedConditions.visibilityOf(latestNRAApp));
        latestNRAApp.click();
        waitFor(3);
    }
    public void verifyFaceComparisonResult() {
        waiter.until(ExpectedConditions.visibilityOf(faceComparisonResult));

        waitFor(2);
        scrollVerticallyWithMouse(200);
        waitFor(2);
        Assert.assertTrue(faceComparisonResult.getText().equalsIgnoreCase("No Approvals Required"), "Face Comparison Result not displayed as No Approvals Required");
        ReportUtil.addScreenShot(LogStatus.PASS, "Face Comparison Result displyed as No Approvals Required");

    }
    public void verifyKYCOnboardingStatus() {
        waiter.until(ExpectedConditions.visibilityOf(kycOnboardingStatus));
        waitFor(2);
        scrollVerticallyWithMouse(200);
        waitFor(2);
        Assert.assertTrue(kycOnboardingStatus.getText().equalsIgnoreCase("Onboard Customer"), "KYC Onboarding Status not displayed as Onboard Customer");
        ReportUtil.addScreenShot(LogStatus.PASS, "KYC Onboarding Status displayed as Onboard Customer");

    }
}
