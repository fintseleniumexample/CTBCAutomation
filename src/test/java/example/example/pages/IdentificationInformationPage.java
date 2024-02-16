package example.example.pages;

import example.example.context.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class IdentificationInformationPage extends BasePage {


    @FindBy(xpath = "//div[text()='Identification Information']")
    private WebElement identificationInformationLabel;
    @FindBy(xpath = "//button[contains(text(),'Capture Passport')]")
    private WebElement capturePassport;

    public IdentificationInformationPage(WebDriver driver) {
        super(driver);
    }


    public void verifyIdentificationInfoPage() {
        waiter.until(ExpectedConditions.visibilityOf(identificationInformationLabel));
        Assert.assertTrue(identificationInformationLabel.isDisplayed(), "Identification  Information page is not displayed");
    }

    public void uploadPassport() {
        waiter.until(ExpectedConditions.visibilityOf(capturePassport));
        waiter.until(ExpectedConditions.elementToBeClickable(capturePassport));
        javaScriptClick(capturePassport);
        uploadImageUsingRobot(Constants.UPLOAD_PASSPORT);
        waitFor(3);
    }

    }


