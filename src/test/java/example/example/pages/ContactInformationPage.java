package example.example.pages;

import com.relevantcodes.extentreports.LogStatus;
import example.example.context.Constants;
import example.example.util.ReportUtil;
import example.example.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ContactInformationPage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[text()='Contact Information']")
    private WebElement contactInformationLabel;

    @FindBy(id = "StreetAddress")
    private WebElement streetAdress;

    public ContactInformationPage(WebDriver driver) {
        super(driver);
    }


    public void verifyCotactInfoPage() {
        waiter.until(ExpectedConditions.visibilityOf(contactInformationLabel));
        Assert.assertTrue(contactInformationLabel.isDisplayed(), "Contact Information page is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Contact Information page displayed");
    }
    public void enterStreetAdress() {
        waiter.until(ExpectedConditions.visibilityOf(streetAdress));
        streetAdress.sendKeys("2");
        try{
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e) {
        }
    }

}
