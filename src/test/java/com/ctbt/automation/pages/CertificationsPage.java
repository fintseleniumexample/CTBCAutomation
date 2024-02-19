package com.ctbt.automation.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.ctbt.automation.util.ReportUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CertificationsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Certifications & Backup Withholding')]")
    private WebElement certificationsLabel;
    @FindBy(xpath = "//input[@name='BackUpWithHoldingCertified' and @value='No']/../..")
    private WebElement backUpWithHoldingCertifiedRadio;

    @FindBy(xpath = "//input[@name='No, I'm not subject to backup withholding' and @value='No']/../..")
    private WebElement jointBackUpWithHoldingCertifiedRadio;

    @FindBy(xpath = "//input[@id='TaxCertified']/..")
    private WebElement taxCertifiedCheckBox;
    @FindBy(xpath = "//input[@name='PoliticalExposed' and @value='No']/../..")
    private WebElement policallyExosed;
    @FindBy(xpath = "//input[@name='PoliticalExposed_1' and @value='No']/../..")
    private WebElement jointPolicallyExosed;

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
    public void checkpolicallyExosed(String acountName) {

        waiter.until(ExpectedConditions.visibilityOf(policallyExosed));
        waiter.until(ExpectedConditions.elementToBeClickable(policallyExosed));
        javaScriptClick(policallyExosed);
        if(acountName.equalsIgnoreCase("Joint")) {

        waiter.until(ExpectedConditions.visibilityOf(jointPolicallyExosed));
        waiter.until(ExpectedConditions.elementToBeClickable(jointPolicallyExosed));
        javaScriptClick(jointPolicallyExosed);
        }

    }

    }


