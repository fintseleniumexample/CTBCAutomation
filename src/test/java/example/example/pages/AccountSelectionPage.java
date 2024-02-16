package example.example.pages;

import com.relevantcodes.extentreports.LogStatus;
import example.example.util.Gpt3ApiRequest;
import example.example.util.ReportUtil;
import example.example.util.TestDataRepository;
import example.example.util.TestProperties;
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


    public AccountSelectionPage(WebDriver driver) {
        super(driver);
    }


    public void verifyAccountPage() {
        waiter.until(ExpectedConditions.visibilityOf(checkingAccount));
        Assert.assertTrue(checkingAccount.isDisplayed(), "Account page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Account page displayed");
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
           // savingsAmount.sendKeys(TestProperties.getProperty("amount"));
            waiter.until(ExpectedConditions.visibilityOf(savingsAddButton));
            savingsAddButton.click();
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
