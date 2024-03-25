package com.ctbt.automation.pages;

import com.ctbt.automation.util.ReportUtil;
import com.ctbt.automation.util.TestDataRepository;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;

public class CRMHomePage extends BasePage {
    @FindBy(xpath = "//div[@title='NRA']/../../..")
    private WebElement nraTab;
    @FindBy(xpath = "//span[text()='NRA Applications']/..")
    private WebElement nraApplicationsLink;
    @FindBy(xpath = "//span[text()='Active NRA Applications']")
    private WebElement nraApplicationTab;
    @FindBy(xpath = "//*[contains(@class,'symbolFont ChevronDownMed-symbol')]")
    private WebElement dropDownArrow;
    @FindBy(xpath = "//span[text()='Invitations Analytics']")
    private WebElement invitationsAnalytics;
    @FindBy(xpath = "//span[text()='NRA Analytics']")
    private WebElement NRAAnalytics;
    @FindBy(xpath = "//div[contains(@class,'chartcontainer-row suiter-chart')]")
    private List<WebElement> graphCount;
    @FindBy(xpath = "//div[@id='DashboardScrollView']")
    private WebElement dashBoardViewElem;

    @FindBy(xpath = "//div[@class='ag-center-cols-container']/div[1]//div[@role='presentation']")
    private WebElement latestNRAApp;
    @FindBy(xpath = "//label[text()='Face Comparison Result']/../../..//select//option[@data-selected='true']")
    private WebElement faceComparisonResult;
    @FindBy(xpath = "//label[text()='KYC Onboarding Status']/../../..//select//option[@data-selected='true']")
    private WebElement kycOnboardingStatus;
    @FindBy(xpath = "//select[@aria-label='Application Status']")
    private WebElement appStatus;
    @FindBy(xpath = "//li[@title='KYC']")
    private WebElement kycTab;
    @FindBy(xpath = "//*[@aria-label='OFAC Check']")
    private WebElement ofacMatch;
    @FindBy(xpath = "//span[text()='Actions']/../..")
    private WebElement actionsDropdwn;
    @FindBy(xpath = "//textarea[@aria-label='Comments']")
    private WebElement ofacComments;
    @FindBy(xpath = "//span[text()='Save and close this OFAC Alert.']/..")
    private WebElement closeOfacAlert;
    @FindBy(xpath = "//*[@aria-label='OFAC Approvals']")
    private WebElement ofacApprovalsTab;
    @FindBy(xpath = "//a[contains(@aria-label,'OFAC')]")
    private WebElement ofactApprovalLink;
    @FindBy(xpath = "//option[text()='Approve']")
    private WebElement optApprove;
    @FindBy(xpath = "//option[text()='Approve']/..")
    private WebElement select;
    @FindBy(xpath = "//span[text()='Save & Close']")
    private WebElement saveClose;
    @FindBy(xpath = "//li[@title='Products']")
    private WebElement productsTab;
    @FindBy(xpath = "//div[contains(text(),'Account Number') and contains(@class,'ms-TooltipHost root')]/../../../../../../../../../../../following-sibling::div[2]/div[2]/div/div/div/div[3]")
    private WebElement prodAccNo;
    @FindBy(xpath = "(//button[@title='Refresh'])[2]")
    private WebElement refreshForAc;

    public CRMHomePage(WebDriver driver) {
        super(driver);
    }
    public void clickNRAATab() {
        driver.switchTo().frame("AppLandingPage");

        waiter.until(ExpectedConditions.visibilityOf(nraTab));
        waiter.until(ExpectedConditions.elementToBeClickable(nraTab));
        nraTab.click();
        waitFor(3);
        driver.switchTo().defaultContent();
    }

        public void clickNRAApplicationsLink() {
        waiter.until(ExpectedConditions.visibilityOf(nraApplicationsLink));
        nraApplicationsLink.click();
            waitFor(3);
    }
    public void verifyNraApplicationTab() {
        waiter.until(ExpectedConditions.visibilityOf(nraApplicationTab));
        Assert.assertTrue(nraApplicationTab.isDisplayed(), "Active NRA Applications is not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Active NRA Applications page displayed");
    }
    public void verifySixGraphs() {
        waitFor(2);
        waiter.until(ExpectedConditions.visibilityOf(graphCount.get(0)));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;
        try {
            Robot robot = new Robot();
            robot.mouseWheel(1);
            robot.mouseMove(centerX, centerY);
        }catch (Exception e){
            e.printStackTrace();
        }
        // Move mouse to the center of the screen

        while(graphCount.size()<6){
            scrollDownUsingRobot();
            waitFor(2);
        }
        Assert.assertEquals(graphCount.size(),6, "Six Graphs not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "Six Graphs displayed");
    }
    public void verifyTwoDropDowns() {
        waiter.until(ExpectedConditions.visibilityOf(dropDownArrow));

        waiter.until(ExpectedConditions.elementToBeClickable(dropDownArrow));
        dropDownArrow.click();
        Assert.assertTrue(invitationsAnalytics.isDisplayed(), " Invitations Analytics drop down displayed");
        Assert.assertTrue(NRAAnalytics.isDisplayed(), " Nra Analytics drop down displayed");
        waitFor(2);
        ReportUtil.addScreenShot(LogStatus.PASS, "Two drop downs displayed");
    }
    public void verifyInvitationAnalyticsDashBoard(){
        waiter.until(ExpectedConditions.visibilityOf(dropDownArrow));

        waiter.until(ExpectedConditions.elementToBeClickable(dropDownArrow));
        dropDownArrow.click();
        waiter.until(ExpectedConditions.visibilityOf(invitationsAnalytics));

        waiter.until(ExpectedConditions.elementToBeClickable(invitationsAnalytics));
        invitationsAnalytics.click();
        waitFor(2);
        waiter.until(ExpectedConditions.visibilityOf(graphCount.get(0)));
        while(graphCount.size()<3){
            scrollDownUsingRobot();
            waitFor(2);
        }
        Assert.assertEquals(graphCount.size(),3, "3 Graphs not displayed");
        ReportUtil.addScreenShot(LogStatus.PASS, "3 Graphs displayed");
    }

    public void clickFirstNRAApp() {
        waiter.until(ExpectedConditions.visibilityOf(latestNRAApp));
        latestNRAApp.click();
        waitFor(3);
    }
    public void verifyAccNo(){
        waitFor(5);
        waiter.until(ExpectedConditions.visibilityOf(productsTab));
        waiter.until(ExpectedConditions.elementToBeClickable(productsTab));
        productsTab.click();
        waitFor(3);
        waiter.until(ExpectedConditions.visibilityOf(refreshForAc));
        waiter.until(ExpectedConditions.elementToBeClickable(refreshForAc));
        System.out.println("prodAccNo.getText()===>"+prodAccNo.getText());
        int i=0;
        int accNo=0;
        boolean flag=false;
        while(i<4 && !flag){
            try {
                refreshForAc.click();
                waitFor(3);
                accNo=   Integer.parseInt(prodAccNo.getText());
                flag=true;
                i++;
            }catch (Exception e){
                flag=false;
            }
        }
        waiter.until(ExpectedConditions.visibilityOf(prodAccNo));
        Assert.assertTrue(accNo>0, "Account no not generated successfully");
        ReportUtil.addScreenShot(LogStatus.PASS, "Account no generated successfully");
    }
    public void verifyOFACCheck(){
        waiter.until(ExpectedConditions.visibilityOf(kycTab));
        waiter.until(ExpectedConditions.elementToBeClickable(kycTab));
        kycTab.click();
       // String custName= "Tlaeywa";
         String custName= TestDataRepository.retrieveTestData("firstName");
        String kycAccLink="//span[contains(text(),'"+custName+"')]/..";
        WebElement custNameLink=driver.findElement(By.xpath(kycAccLink));
        waiter.until(ExpectedConditions.visibilityOf(custNameLink));
        waiter.until(ExpectedConditions.elementToBeClickable(custNameLink));
        custNameLink.click();
        waiter.until(ExpectedConditions.visibilityOf(ofacMatch));
        Assert.assertTrue(ofacMatch.getText().contains("Match"), "OFAC check not displayed as Match");
        ReportUtil.addScreenShot(LogStatus.PASS, "OFAC check displayed as Match");
    }
    public void creatOFACTicket(){
        waiter.until(ExpectedConditions.visibilityOf(actionsDropdwn));
        waiter.until(ExpectedConditions.elementToBeClickable(actionsDropdwn));
        actionsDropdwn.click();
        String ofacTicketXpath="//*[contains(text(),'Create OFAC Ticket')]";
        WebElement ofacTicketAction=driver.findElement(By.xpath(ofacTicketXpath));
        waiter.until(ExpectedConditions.visibilityOf(ofacTicketAction));
        waiter.until(ExpectedConditions.elementToBeClickable(ofacTicketAction));
        ofacTicketAction.click();
        waiter.until(ExpectedConditions.visibilityOf(ofacComments));
        waiter.until(ExpectedConditions.elementToBeClickable(ofacComments));
        ofacComments.click();
        ofacComments.sendKeys("its not fraud");
        waiter.until(ExpectedConditions.visibilityOf(closeOfacAlert));
        waiter.until(ExpectedConditions.elementToBeClickable(closeOfacAlert));
        closeOfacAlert.click();

    }
    public void approveOFACTicket(){
        waiter.until(ExpectedConditions.visibilityOf(ofacApprovalsTab));
        waiter.until(ExpectedConditions.elementToBeClickable(ofacApprovalsTab));
        ofacApprovalsTab.click();
        waitFor(4);
        waiter.until(ExpectedConditions.visibilityOf(ofactApprovalLink));
        waiter.until(ExpectedConditions.elementToBeClickable(ofactApprovalLink));
        ofactApprovalLink.click();
        waiter.until(ExpectedConditions.visibilityOf(select));
        waiter.until(ExpectedConditions.elementToBeClickable(select));
        select.click();
        waiter.until(ExpectedConditions.visibilityOf(optApprove));
        waiter.until(ExpectedConditions.elementToBeClickable(optApprove));
        optApprove.click();
        waiter.until(ExpectedConditions.visibilityOf(saveClose));
        waiter.until(ExpectedConditions.elementToBeClickable(saveClose));
        saveClose.click();
        waitFor(5);
    }
    public void verifyFaceComparisonResult() {
        waiter.until(ExpectedConditions.visibilityOf(faceComparisonResult));

        waitFor(2);
        scrollVerticallyWithMouse(200);
        waitFor(2);
        Assert.assertTrue(faceComparisonResult.getText().equalsIgnoreCase("No Approvals Required"), "Face Comparison Result not displayed as No Approvals Required");
        ReportUtil.addScreenShot(LogStatus.PASS, "Face Comparison Result displyed as No Approvals Required");

    }
    public void verifyKYCOnboardingStatus() {
        waiter.until(ExpectedConditions.visibilityOf(kycOnboardingStatus));
        waitFor(2);
        scrollVerticallyWithMouse(200);
        waitFor(2);
        Assert.assertTrue(kycOnboardingStatus.getText().equalsIgnoreCase("Onboard Customer"), "KYC Onboarding Status not displayed as Onboard Customer");
        ReportUtil.addScreenShot(LogStatus.PASS, "KYC Onboarding Status displayed as Onboard Customer");

    }
    public void verifyAppStatusAsDeclined() {
        waiter.until(ExpectedConditions.visibilityOf(appStatus));
        waitFor(2);

        waitFor(2);
        Assert.assertTrue(appStatus.getAttribute("title").equalsIgnoreCase("Declined"), "App status not displayed as Declined");
        ReportUtil.addScreenShot(LogStatus.PASS, "App status displayed as Declined");

    }
}
