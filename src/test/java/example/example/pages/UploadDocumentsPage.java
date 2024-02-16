package example.example.pages;

import com.relevantcodes.extentreports.LogStatus;
import example.example.context.Constants;
import example.example.util.ReportUtil;
import example.example.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadDocumentsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Upload Documents')]")
    private WebElement uploadDocumentsLabel;
    @FindBy(xpath = "(//label[text()='UPLOAD'])[1]")
    private WebElement uploadDocs;

    public UploadDocumentsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyUploadDocumentsLabelPage() {
        waitForVisibilityOf(uploadDocumentsLabel);
        Assert.assertTrue(uploadDocumentsLabel.isDisplayed(), "Upload Documents page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Upload Documents page displayed");
    }
    public void uploadDoc() {

        waiter.until(ExpectedConditions.visibilityOf(uploadDocs));
        waiter.until(ExpectedConditions.elementToBeClickable(uploadDocs));
        javaScriptClick(uploadDocs);
        uploadImageUsingRobot(Constants.UPLOAD_DOC);
        waitFor(3);
    }
    }


