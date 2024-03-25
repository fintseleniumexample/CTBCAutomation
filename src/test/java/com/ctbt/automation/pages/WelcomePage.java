package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestDataRepository;
import com.ctbt.automation.util.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//button[text()='Next' or  text()='NEXT']/..")
    private WebElement nextButton;
    @FindBy(xpath = "//button[text()='verify']")
    private WebElement verifyBtn;

    @FindBy(xpath = "//button[text()='Resume Application']")
    private WebElement resumeBtn;

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

    public void fillAppDetailsForResume(){
        waitAndType(emailField, TestDataRepository.retrieveTestData("email"));
        waitAndType(countryField, TestProperties.getProperty("country"));
        waitAndType(phoneNumberField, String.valueOf(TestDataRepository.retrieveTestData("phoneNumber")));
        fillConfirmPhoneNumber(Long.parseLong(TestDataRepository.retrieveTestData("phoneNumber")));
        clickAndWait(viewDisclosure);
        clickAndWait(closeBtn);
        waitFor(2);
        clickAndWait(isESign);
        ReportUtil.addScreenShot(LogStatus.PASS, "Welcome page displayed");
    }
    public void fillEmailAndPhoneForResume(){
        waitAndType(emailField, TestDataRepository.retrieveTestData("email"));

        waitAndType(phoneNumberField, String.valueOf(TestDataRepository.retrieveTestData("phoneNumber")));
        clickNextButton();
           ReportUtil.addScreenShot(LogStatus.PASS, "Welcome page displayed");
    }
    public void resumeApplicationOTP(){

        for(int i=1;i<7;i++) {
            String key="key";
            key=key+i;
            String xpath = "//input[@name='"+key+"']";
            WebElement element=driver.findElement(By.xpath(xpath));
            waitAndType(element, ""+i);
        }
        waitFor(2);
        clickAndWait(verifyBtn);
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
    public void clickResumeApp(){
        clickAndWait(resumeBtn);
    }

}
