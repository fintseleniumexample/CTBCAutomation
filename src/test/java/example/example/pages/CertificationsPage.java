package example.example.pages;

import com.relevantcodes.extentreports.LogStatus;
import example.example.util.ReportUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class CertificationsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Certifications & Backup Withholding')]")
    private WebElement certificationsLabel;
    @FindBy(xpath = "//input[@name='BackUpWithHoldingCertified' and @value='No']/../..")
    private WebElement backUpWithHoldingCertifiedRadio;
    @FindBy(xpath = "//input[@id='TaxCertified']/..")
    private WebElement taxCertifiedCheckBox;
    @FindBy(xpath = "//input[@name='PoliticalExposed' and @value='No']/../..")
    private WebElement policallyExosed;

    public CertificationsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCertificationsLabelPage() {
        waiter.until(ExpectedConditions.visibilityOf(certificationsLabel));
        Assert.assertTrue(certificationsLabel.isDisplayed(), "certifications page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "certifications page displayed");
    }
    public void checkBackUpWithHoldingCertifiedRadio() {

        waiter.until(ExpectedConditions.visibilityOf(backUpWithHoldingCertifiedRadio));
        waiter.until(ExpectedConditions.elementToBeClickable(backUpWithHoldingCertifiedRadio));
        javaScriptClick(backUpWithHoldingCertifiedRadio);

    }
    public void checkTaxCertifiedCheckBox() {

        waiter.until(ExpectedConditions.visibilityOf(taxCertifiedCheckBox));
        waiter.until(ExpectedConditions.elementToBeClickable(taxCertifiedCheckBox));
        taxCertifiedCheckBox.click();

    }
    public void checkpolicallyExosed() {

        waiter.until(ExpectedConditions.visibilityOf(policallyExosed));
        waiter.until(ExpectedConditions.elementToBeClickable(policallyExosed));
        javaScriptClick(policallyExosed);

    }

    }


