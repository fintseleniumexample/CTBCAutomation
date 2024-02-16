package example.example.tests;

import example.example.context.WebDriverContext;
import example.example.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WelcomePageTest extends BaseTest {
    private WelcomePage welcomePage;
    private AccountSelectionPage accountSelectionPage;
    private InformationPage informationPage;
    private ContactInformationPage contactInformationPage;
    private IdentificationInformationPage identificationInformationPage;
    private EmploymentInformationPage employmentInformationPage;
    private UploadDocumentsPage uploadDocumentsPage;
    private CertificationsPage certificationsPage;
    private AgreementsDiscPage agreementsDiscPage;
    private CRMLoginPage crmLoginPage;
    private CRMHomePage crmHomePage;
    @DataProvider(name = "accounts")
    public Object[][] provideCredentials() {
        return new Object[][] {
                { "Checking"  },
                { "Savings" },
                { "Joint" }

        };
    }
    @Test(dataProvider = "accounts")
    public void ctbcAccountVericationTest(String accountName) {
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount(accountName);
        welcomePage.clickNextButton();

        informationPage = new InformationPage(WebDriverContext.getDriver());
        informationPage.verifyInfoPage();
        informationPage.uploadImage();
        informationPage.fillPersonalDetail();
        informationPage.contactInfoNextButton();

        contactInformationPage = new ContactInformationPage(WebDriverContext.getDriver());
        contactInformationPage.verifyCotactInfoPage();
        contactInformationPage.enterStreetAdress();
        informationPage.contactInfoNextButton();

        identificationInformationPage = new IdentificationInformationPage(WebDriverContext.getDriver());
        identificationInformationPage.verifyIdentificationInfoPage();
        identificationInformationPage.uploadPassport();
        informationPage.contactInfoNextButton();

        employmentInformationPage = new EmploymentInformationPage(WebDriverContext.getDriver());
        employmentInformationPage.verifyEmploymentInfoPage();
        employmentInformationPage.fillEmploymentDetails();
        informationPage.contactInfoNextButton();
        employmentInformationPage.verifyJoinAccountLabelInfoPage(accountName);
        informationPage.contactInfoNextButton();

        uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed();
        informationPage.contactInfoNextButton();

        agreementsDiscPage = new AgreementsDiscPage(WebDriverContext.getDriver());
        agreementsDiscPage.verifyAgreementsPage();
        agreementsDiscPage.checkAgreementNotice();
        informationPage.contactInfoNextButton();
        agreementsDiscPage.verifyAccountSuccessPage();

        navigateToCRMApplication();
        crmLoginPage = new CRMLoginPage(WebDriverContext.getDriver());
        crmLoginPage.loginToCRM();
        crmHomePage = new CRMHomePage(WebDriverContext.getDriver());
        crmHomePage.clickNRAATab();
        crmHomePage.clickNRAApplicationsLink();
        crmHomePage.verifyNraApplicationTab();
        crmHomePage.clickFirstNRAApp();
        crmHomePage.verifyFaceComparisonResult();
        crmHomePage.verifyKYCOnboardingStatus();

    }


}
