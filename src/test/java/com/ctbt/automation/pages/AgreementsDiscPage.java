package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AgreementsDiscPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Agreements & Disclosures')]")
    private WebElement agreementDisc;
    @FindBy(xpath = "//input[@name='agreementNotice']/..")
    private WebElement agreementNotice;
    @FindBy(xpath = "//div[contains(text(),'Congratulations on successful account opening at')]")
    private WebElement accountSuccess;

    public AgreementsDiscPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAgreementsPage() {
        waiter.until(ExpectedConditions.visibilityOf(agreementDisc));
        Assert.assertTrue(agreementDisc.isDisplayed(), "Agreements & Disclosures page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Agreements & Disclosures page displayed");
    }
    public void checkAgreementNotice() {

        waiter.until(ExpectedConditions.visibilityOf(agreementNotice));
        waiter.until(ExpectedConditions.elementToBeClickable(agreementNotice));
       agreementNotice.click();

    }

    public void verifyAccountSuccessPage() {
        waiter.until(ExpectedConditions.visibilityOf(accountSuccess));
        Assert.assertTrue(accountSuccess.isDisplayed(), "accountSuccess page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "accountSuccesspage displayed");
    }
    }


