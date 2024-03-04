package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class CRMHomePage extends BasePage {
    @FindBy(xpath = "//div[@title='NRA']/../../..")
    private WebElement nraTab;
    @FindBy(xpath = "//span[text()='NRA Applications']/..")
    private WebElement nraApplicationsLink;
    @FindBy(xpath = "//span[text()='Active NRA Applications']")
    private WebElement nraApplicationTab;
    @FindBy(xpath = "//*[contains(@class,'symbolFont ChevronDownMed-symbol')]")
    private WebElement dropDownArrow;
    @FindBy(xpath = "//span[text()='Invitations Analytics']")
    private WebElement invitationsAnalytics;
    @FindBy(xpath = "//span[text()='NRA Analytics']")
    private WebElement NRAAnalytics;
    @FindBy(xpath = "//div[contains(@class,'chartcontainer-row suiter-chart')]")
    private List<WebElement> graphCount;

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
    public void verifySixGraphs() {
        waitFor(2);
        waiter.until(ExpectedConditions.visibilityOf(graphCount.get(0)));
        while(graphCount.size()<6){
            scrollDownUsingRobot();
            waitFor(2);
        }
        Assert.assertEquals(graphCount.size(),6, "Six Graphs not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Six Graphs displayed");
    }
    public void verifyTwoDropDowns() {
        waiter.until(ExpectedConditions.visibilityOf(dropDownArrow));

        waiter.until(ExpectedConditions.elementToBeClickable(dropDownArrow));
        dropDownArrow.click();
        Assert.assertTrue(invitationsAnalytics.isDisplayed(), " Invitations Analytics drop down displayed");
        Assert.assertTrue(NRAAnalytics.isDisplayed(), " Nra Analytics drop down displayed");
        waitFor(2);
        ReportUtil.addScreenShot(LogStatus.PASS, "Two drop downs displayed");
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
