package com.ctbt.automation.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestDataRepository;
import com.ctbt.automation.util.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AccountSelectionPage extends BasePage {

    @FindBy(xpath = "//button[text()='Checking Account']")
    private WebElement checkingAccount;
    @FindBy(xpath = "//button[text()='Savings Account']")
    private WebElement savingsAccount;

    @FindBy(id = "Amount")
    private WebElement amount;
    @FindBy(id = "(//input[@id='Amount'])[2]")
    private WebElement savingsAmount;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;
    @FindBy(xpath = "(//button[text()='Add'])[2]")
    private WebElement savingsAddButton;
    @FindBy(xpath = "//div[text()='Personal Basic Checking']/../..//div[text()='Maximum product(s) added.']")
    private WebElement maxCheckingAcc;
    @FindBy(xpath = "//div[text()='Personal Savings Account']/../..//div[text()='Maximum product(s) added.']")
    private WebElement maxSavingAcc;


    public AccountSelectionPage(WebDriver driver) {
        super(driver);
    }


    public void verifyAccountPage() {
        waiter.until(ExpectedConditions.visibilityOf(checkingAccount));
        Assert.assertTrue(checkingAccount.isDisplayed(), "Account page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Account page displayed");
    }
    public void verifyMaxCheckingAccMsg() {
        waiter.until(ExpectedConditions.visibilityOf(maxCheckingAcc));
        Assert.assertTrue(maxCheckingAcc.isDisplayed(), "'Maximum product(s) added' not displayed for Checking");
        ReportUtil.addScreenShot(LogStatus.PASS, "'Maximum product(s) added' message displayed for Checking");
    }
    public void verifyMaxSavingsAccMsg() {
        waitFor(2);
        waiter.until(ExpectedConditions.visibilityOf(maxSavingAcc));
        Assert.assertTrue(maxSavingAcc.isDisplayed(), "'Maximum product(s) added' not displayed for Savings");
        ReportUtil.addScreenShot(LogStatus.PASS, "'Maximum product(s) added' message displayed for Savings");
    }
    public void enterAmount(String accountName) {
        if(accountName.equalsIgnoreCase("Savings") || accountName.equalsIgnoreCase("Joint")){
            waiter.until(ExpectedConditions.visibilityOf(savingsAccount));
            savingsAccount.click();
            waitFor(2);
            ReportUtil.addScreenShot(LogStatus.PASS, "Savings Account page displayed");
            List amountList=driver.findElements(By.xpath("//input[@id='Amount']"));
            System.out.println("amountList size:"+amountList.size());
          //  waiter.until(ExpectedConditions.visibilityOf(savingsAmount));
            if(amountList.size()>1){
                ((WebElement)amountList.get(1)).sendKeys(TestProperties.getProperty("amount"));
            }else{
                ((WebElement)amountList.get(0)).sendKeys(TestProperties.getProperty("amount"));
            }
            TestDataRepository.storeTestData("amount", TestProperties.getProperty("amount"));

            List addList=driver.findElements(By.xpath("//button[text()='Add']"));
            System.out.println("addList size:"+addList.size());
            if(addList.size()>1){

                waiter.until(ExpectedConditions.visibilityOf( savingsAddButton));
                waiter.until(ExpectedConditions.elementToBeClickable( savingsAddButton));
                savingsAddButton.click();

            }else{
                clickAdd();
            }

        }else {
            waiter.until(ExpectedConditions.visibilityOf(amount));
            TestDataRepository.storeTestData("amount", TestProperties.getProperty("amount"));
            amount.sendKeys(TestProperties.getProperty("amount"));
            clickAdd();
        }

    }


    public void clickAdd() {

        waiter.until(ExpectedConditions.visibilityOf(addButton));
        waiter.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }
}
