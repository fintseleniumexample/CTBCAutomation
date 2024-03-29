package com.ctbt.automation.pages;

import com.ctbt.automation.context.Constants;
import com.ctbt.automation.util.TestDataRepository;
import com.relevantcodes.extentreports.LogStatus;
import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class InformationPage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Gather Your Information')]")
    private WebElement informationLabel;


    @FindBy(xpath = "//button[contains(text(),'Take a Photo')]")
    private WebElement takeAPhoto;
    @FindBy(id = "FirstName")
    private WebElement firstName;
    @FindBy(id = "LastName")
    private WebElement lastFirstName;
    @FindBy(id = "DOB")
    private WebElement DOB;
    @FindBy(id = "CountryOfCitizenship")
    private WebElement countryOfCitizenship;
    @FindBy(xpath = "//button[text()='NEXT'] | //button[text()='Next']/..")
    private WebElement contactInfoNext;
    @FindBy(xpath = "//button[text()='BACK']")
    private WebElement contactInfoBack;


    @FindBy(xpath = "//input[contains(@value,'Taiwan')]")
    private WebElement countryOfCitizenshipVal;
    public InformationPage(WebDriver driver) {
        super(driver);
    }



    public void verifyInfoPage() {
        waiter.until(ExpectedConditions.visibilityOf(informationLabel));
        Assert.assertTrue(informationLabel.isDisplayed(), "Information page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Information page displayed");
    }
    public void uploadImage() {

        waiter.until(ExpectedConditions.visibilityOf(takeAPhoto));
        waiter.until(ExpectedConditions.elementToBeClickable(takeAPhoto));
        javaScriptClick(takeAPhoto);
        uploadImageUsingRobot(Constants.IMAGE_PATH);
        waiter.withTimeout(Duration.ofSeconds(5));
    }
    public void uploadBlankImage() {

        waiter.until(ExpectedConditions.visibilityOf(takeAPhoto));
        waiter.until(ExpectedConditions.elementToBeClickable(takeAPhoto));
        javaScriptClick(takeAPhoto);
        uploadImageUsingRobot(Constants.BLANK_IMAGE_PATH);
        waiter.withTimeout(Duration.ofSeconds(5));
    }

    public void fillPersonalDetail() {
        enterFirstName();
        lastFirstName();
        enterDOB();
        countryOfCitizenship();
    }
    public void fillPersonalDetailForOFAC(){
        enterFirstName();
        lastFirstName();
        enterOFACDOB();
        countryOfCitizenship();
    }
    public void enterFirstName() {
        String firstNameVal=generateRandomString();
        TestDataRepository.storeTestData("firstName",firstNameVal);
        waiter.until(ExpectedConditions.visibilityOf(firstName));

        firstName.sendKeys(firstNameVal);
    }
    public void lastFirstName() {
        String lastNameVal=generateRandomString();
        TestDataRepository.storeTestData("lastName",lastNameVal);
        waiter.until(ExpectedConditions.visibilityOf(lastFirstName));
        lastFirstName.sendKeys(lastNameVal);
    }
    public void enterDOB() {
        waiter.until(ExpectedConditions.visibilityOf(DOB));
        TestDataRepository.storeTestData("DOB",TestProperties.getProperty("dob"));
        DOB.sendKeys(TestProperties.getProperty("dob"));
    }
    public void enterOFACDOB() {
        waiter.until(ExpectedConditions.visibilityOf(DOB));
        TestDataRepository.storeTestData("OFACdob",TestProperties.getProperty("OFACdob"));
        DOB.sendKeys(TestProperties.getProperty("OFACdob"));
    }
    public void countryOfCitizenship() {
        selectDropdownOption(countryOfCitizenship);

    }
    public void contactInfoNextButton() {
        waiter.until(ExpectedConditions.visibilityOf(contactInfoNext));
        waiter.until(ExpectedConditions.elementToBeClickable(contactInfoNext));
        contactInfoNext.click();
    }


}
