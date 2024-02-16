package example.example.pages;

import example.example.util.TestProperties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CRMLoginPage extends BasePage {
    private WebDriver driver;
    @FindBy(name = "loginfmt")
    private WebElement emailField;
    @FindBy(id = "idSIButton9")
    private WebElement nextButton;
    @FindBy(name = "passwd")
    private WebElement pwdField;
    @FindBy(id = "idBtn_Back")
    private WebElement noBtn;

    public CRMLoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginToCRM()  {
            waiter.until(ExpectedConditions.visibilityOf(emailField));
            emailField.sendKeys(TestProperties.getProperty("crmUsername"));
            waiter.until(ExpectedConditions.visibilityOf(nextButton));
            nextButton.click();
            waiter.until(ExpectedConditions.visibilityOf(pwdField));
            pwdField.sendKeys(TestProperties.getProperty("crmPassword"));
            waiter.until(ExpectedConditions.visibilityOf(nextButton));
            nextButton.click();
            waiter.until(ExpectedConditions.visibilityOf(noBtn));
            waiter.until(ExpectedConditions.elementToBeClickable(noBtn));
            noBtn.click();
    }

    }

