package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestDataRepository;
import com.ctbt.automation.util.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PersonalInformationPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Personal Information')]")
    private WebElement personalInfoLabel;

    @FindBy(id = "FirstName")
    private WebElement firstName;
    @FindBy(id = "CountryOfCitizenship")
    private WebElement countryOfCitizenship;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "DOB")
    private WebElement dob;

    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Mobile")
    private WebElement mobile;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPersonalInformationPage() {
        waitForVisibilityOf(personalInfoLabel);
        Assert.assertTrue(personalInfoLabel.isDisplayed(), "Personal Information page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Personal Information page displayed");
    }



    public void fillPeronalInfo() {

        enterFirstName();
        enterLname();
        fillJointEmail();
        enterCountryOfCitizenship();
        enterDob();
        fillJointPhoneNumber();
    }



    public void enterDob() {
        waitForVisibilityOf(dob);
        TestDataRepository.storeTestData("jointDOB", TestProperties.getProperty("jointDOB"));
        dob.sendKeys(TestProperties.getProperty("jointDOB"));
    }
    public void enterLname() {
        String jointLastNameVal=RandomStringUtils.randomAlphabetic(5, 10);
        waitForVisibilityOf(lastName);
        TestDataRepository.storeTestData("jointLName",jointLastNameVal);
        lastName.sendKeys(jointLastNameVal);

    }

    public void enterFirstName() {
        String jointFirstNameVal= RandomStringUtils.randomAlphabetic(5, 10);
        waitForVisibilityOf(firstName);
        TestDataRepository.storeTestData("jointFirstName",TestProperties.getProperty("jointFirstNameVal"));
        firstName.sendKeys(jointFirstNameVal);


    }
    public void fillJointEmail() {
        String randomEmail = generateRandomString(6) + "@mail.com";
        TestDataRepository.storeTestData("jointEmail",randomEmail);
        waitAndType(email, randomEmail);
    }
    public void fillJointPhoneNumber() {
        long phoneNumber = generateRandom10DigitNumber();
        TestDataRepository.storeTestData("jointPhoneNumber",phoneNumber+"");
        waitAndType(mobile, String.valueOf(phoneNumber));

    }
    public void enterCountryOfCitizenship() {
        selectDropdownOption(countryOfCitizenship);
    }




}
