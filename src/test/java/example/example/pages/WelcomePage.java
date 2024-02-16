package example.example.pages;

import com.relevantcodes.extentreports.LogStatus;
import example.example.util.ReportUtil;
import example.example.util.TestDataRepository;
import example.example.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        TestDataRepository.storeTestData("country",TestProperties.getProperty("country"));
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
