package com.ctbt.automation.pages;

import com.ctbt.automation.context.Constants;
import com.relevantcodes.extentreports.LogStatus;
import com.ctbt.automation.util.ReportUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UploadDocumentsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Upload Documents')]")
    private WebElement uploadDocumentsLabel;
    @FindBy(xpath = "(//label[text()='UPLOAD'])[1]")
    private WebElement uploadDocs;
    @FindBy(xpath = "(//label[text()='UPLOAD'])[1]/following-sibling::label")
    private WebElement uploadDocsMobileView;
    @FindBy(xpath = "(//label[text()='UPLOAD'])[2]")
    private WebElement uploadDocs2;
    @FindBy(xpath = "(//label[text()='UPLOAD'])[2]/following-sibling::label")
    private WebElement uploadDoc2sMobileView;
    public UploadDocumentsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyUploadDocumentsLabelPage() {
        waitForVisibilityOf(uploadDocumentsLabel);
        Assert.assertTrue(uploadDocumentsLabel.isDisplayed(), "Upload Documents page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Upload Documents page displayed");
    }
    public void uploadDoc() {

        if (isResponsiveView()) {
            waiter.until(ExpectedConditions.visibilityOf(uploadDocsMobileView));
            waiter.until(ExpectedConditions.elementToBeClickable(uploadDocsMobileView));
            uploadDocsMobileView.click();
            uploadImageUsingRobot(Constants.UPLOAD_DOC);
            waitFor(3);
            waiter.until(ExpectedConditions.visibilityOf(uploadDoc2sMobileView));
            waiter.until(ExpectedConditions.elementToBeClickable(uploadDoc2sMobileView));
            uploadDoc2sMobileView.click();
            uploadImageUsingRobot(Constants.IMAGE_PATH);
            waitFor(3);
        } else {
            waiter.until(ExpectedConditions.visibilityOf(uploadDocs));
            waiter.until(ExpectedConditions.elementToBeClickable(uploadDocs));
            uploadDocs.click();
            uploadImageUsingRobot(Constants.UPLOAD_DOC);
            waitFor(3);
            waiter.until(ExpectedConditions.visibilityOf(uploadDocs2));
            waiter.until(ExpectedConditions.elementToBeClickable(uploadDocs2));
            uploadDocs2.click();
            uploadImageUsingRobot(Constants.IMAGE_PATH);
            waitFor(3);
        }

    }

    public boolean isResponsiveView(){
        Dimension windowSize = driver.manage().window().getSize();
        System.out.println("windowSize.getWidth()==>"+windowSize.getWidth());
        System.out.println(" windowSize.getHeight()==>"+ windowSize.getHeight());

        // Check if the window size matches the expected dimensions
        int expectedWidth = 515;
        int expectedHeight = 738;
        boolean isResponsive = windowSize.getWidth() == expectedWidth && windowSize.getHeight() == expectedHeight;

        return isResponsive;
    }
    }


