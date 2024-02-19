package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestDataRepository;
import com.ctbt.automation.util.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Country")
    private WebElement countryField;

    @FindBy(id = "Mobile")
    private WebElement phoneNumberField;

    @FindBy(id = "ConfirmPhoneNumber")
    private WebElement confirmPhoneNumber;

    @FindBy(xpath = "//input[@id='IsESign']/..")
    private WebElement isESign;

    @FindBy(id = "view_disclosure")
    private WebElement viewDisclosure;

    @FindBy(xpath = "//button[text()='CLOSE']")
    private WebElement closeBtn;

    @FindBy(xpath = "//button[text()='Next']/..")
    private WebElement nextButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void fillAppDetails() {
        fillEmail();
        fillCountry();
        fillPhoneNumber();
        clickAndWait(viewDisclosure);
        clickAndWait(closeBtn);
        waitFor(2);
        clickAndWait(isESign);
        ReportUtil.addScreenShot(LogStatus.PASS, "Welcome page displayed");
    }

    public void fillEmail() {
        String randomEmail = generateRandomString(6) + "@mail.com";
        TestDataRepository.storeTestData("email",randomEmail);
        waitAndType(emailField, randomEmail);
    }
    public void fillCountry() {
        TestDataRepository.storeTestData("country", TestProperties.getProperty("country"));
        waitAndType(countryField, TestProperties.getProperty("country"));
    }

    public void fillPhoneNumber() {
        long phoneNumber = generateRandom10DigitNumber();
        TestDataRepository.storeTestData("phoneNumber",phoneNumber+"");
        waitAndType(phoneNumberField, String.valueOf(phoneNumber));
        fillConfirmPhoneNumber(phoneNumber);
    }
    public void fillConfirmPhoneNumber(long phoneNumber) {
        waitAndType(confirmPhoneNumber, String.valueOf(phoneNumber));
    }
    public void clickNextButton() {
        clickAndWait(nextButton);
    }

}
