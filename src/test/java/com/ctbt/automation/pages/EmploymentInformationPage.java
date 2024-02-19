package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestDataRepository;
import com.ctbt.automation.util.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EmploymentInformationPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'I would like to add a joint account owner')]")
    private WebElement joinAccountLabel;
    @FindBy(xpath = "//input[@name='IsJointAccount' and @value='Yes']/..")
    private WebElement isJointAccount;

    @FindBy(xpath = "//div[text()='Employment Information']")
    private WebElement employmentInformationLabel;

    @FindBy(id = "EmployementStatus")
    private WebElement employmentStatusDropdown;

    @FindBy(id = "EmployerName")
    private WebElement employerNameField;

    @FindBy(id = "AnnualIncome")
    private WebElement annualIncomeField;

    @FindBy(id = "Occupation")
    private WebElement occupationDropdown;

    public EmploymentInformationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyEmploymentInfoPage() {
        waitForVisibilityOf(employmentInformationLabel);
        Assert.assertTrue(employmentInformationLabel.isDisplayed(), "Employment Information page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Employment Information page displayed");
    }

    public void verifyJoinAccountLabelInfoPage(String account) {

        if(account.equalsIgnoreCase("Joint")){
            waitForVisibilityOf(isJointAccount);
            isJointAccount.click();
        }
        waitForVisibilityOf(joinAccountLabel);
        Assert.assertTrue(joinAccountLabel.isDisplayed(), "Join Account  info page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Join Account  Information page displayed");

    }

    public void fillEmploymentDetails() {
        enterEmploymentStatus();
        enterEmployerName();
        enterAnnualIncome();
        enterOccupation();
    }

    public void enterEmployerName() {
        waitForVisibilityOf(employerNameField);
        TestDataRepository.storeTestData("employerName", TestProperties.getProperty("employerName"));
        employerNameField.sendKeys(TestProperties.getProperty("employerName"));
    }

    public void enterAnnualIncome() {
        TestDataRepository.storeTestData("annualIncome",TestProperties.getProperty("annualIncome"));
        waitForVisibilityOf(annualIncomeField);

        annualIncomeField.sendKeys(TestProperties.getProperty("annualIncome"));
    }

    public void enterEmploymentStatus() {
        selectDropdownOption(employmentStatusDropdown);
    }

    public void enterOccupation() {
        selectDropdownOption(occupationDropdown);
    }


}
