package com.ctbt.automation.tests;

import com.ctbt.automation.pages.*;
import com.ctbt.automation.context.WebDriverContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CTBCAutomationScripts extends BaseTest {
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
    private PersonalInformationPage personalInformationPage;
    @DataProvider(name = "accounts")
    public Object[][] provideCredentials() {
        return new Object[][] {
              { "Checking"  },
                { "Savings" },


        };
    }
    @Test(dataProvider = "accounts")
    public void ctbcSavingAndCheckingAccountVericationTest(String accountName) {
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
        certificationsPage.checkpolicallyExosed(accountName);
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


@Test
    public void ctbcJointAccountVericationTest() {
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount("joint");
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
            employmentInformationPage.verifyJoinAccountLabelInfoPage("joint");
            informationPage.contactInfoNextButton();



            personalInformationPage = new PersonalInformationPage(WebDriverContext.getDriver());
            personalInformationPage.verifyPersonalInformationPage();
            personalInformationPage.fillPeronalInfo();
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


         uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed("joint");
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

    @Test
    public void verifyApplicationWithMoreThanOneProduct() {
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount("Checking");
        accountSelectionPage.enterAmount("Checking");
        accountSelectionPage.verifyMaxCheckingAccMsg();

        accountSelectionPage.enterAmount("Savings");
        accountSelectionPage.enterAmount("Savings");
        accountSelectionPage.verifyMaxSavingsAccMsg();
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
        employmentInformationPage.verifyJoinAccountLabelInfoPage("Checking");
        informationPage.contactInfoNextButton();

        uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed("Checking");
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
    @Test
    public void verifyDashboardsWithDigitalBackOfficeTeamUser() {
        navigateToCRMApplication();
        crmLoginPage = new CRMLoginPage(WebDriverContext.getDriver());
        crmLoginPage.loginToCRM();
        crmHomePage = new CRMHomePage(WebDriverContext.getDriver());
        crmHomePage.clickNRAATab();
        crmHomePage.verifySixGraphs();
        crmHomePage.verifyTwoDropDowns();
        crmHomePage.verifyInvitationAnalyticsDashBoard();


    }
    @Test
    public void verifyResumeApplication() {
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();
        driver.close();
        setup();
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetailsForResume();
        welcomePage.clickNextButton();
        welcomePage.clickResumeApp();
        welcomePage.fillEmailAndPhoneForResume();
        welcomePage.resumeApplicationOTP();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount("Checking");
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
        employmentInformationPage.verifyJoinAccountLabelInfoPage("Checking");
        informationPage.contactInfoNextButton();

        uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed("Checking");
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
    @Test
    public void verifyAppWithBlankSelfie() {
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount("Checking");
        welcomePage.clickNextButton();

        informationPage = new InformationPage(WebDriverContext.getDriver());
        informationPage.verifyInfoPage();

        informationPage.uploadBlankImage();
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
        employmentInformationPage.verifyJoinAccountLabelInfoPage("Checking");
        informationPage.contactInfoNextButton();

        uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed("Checking");
        informationPage.contactInfoNextButton();

        agreementsDiscPage = new AgreementsDiscPage(WebDriverContext.getDriver());
        agreementsDiscPage.verifyAgreementsPage();
        agreementsDiscPage.checkAgreementNotice();
        informationPage.contactInfoNextButton();
        agreementsDiscPage.verifyAppUnderReview();

        navigateToCRMApplication();
        crmLoginPage = new CRMLoginPage(WebDriverContext.getDriver());
        crmLoginPage.loginToCRM();
        crmHomePage = new CRMHomePage(WebDriverContext.getDriver());
        crmHomePage.clickNRAATab();
        crmHomePage.clickNRAApplicationsLink();
        crmHomePage.verifyNraApplicationTab();
        crmHomePage.clickFirstNRAApp();
        crmHomePage.verifyAppStatusAsDeclined();
    }
    @Test(dataProvider = "accounts")
    public void ctbcSavingAndCheckingAccountVericationTestMobileView(String accountName) {
        openAppinMobileView();
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
        certificationsPage.checkpolicallyExosed(accountName);
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
    @Test
    public void ctbcJointAccountVericationTestMobileView() {
        openAppinMobileView();
        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount("joint");
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
            employmentInformationPage.verifyJoinAccountLabelInfoPage("joint");
            informationPage.contactInfoNextButton();



            personalInformationPage = new PersonalInformationPage(WebDriverContext.getDriver());
            personalInformationPage.verifyPersonalInformationPage();
            personalInformationPage.fillPeronalInfo();
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


         uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed("joint");
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

    @Test
    public void verifyOFACScenario( ) {

        welcomePage = new WelcomePage(WebDriverContext.getDriver());
        welcomePage.fillAppDetails();
        welcomePage.clickNextButton();

        accountSelectionPage = new AccountSelectionPage(WebDriverContext.getDriver());
        accountSelectionPage.verifyAccountPage();
        accountSelectionPage.enterAmount("Checking");
        welcomePage.clickNextButton();

        informationPage = new InformationPage(WebDriverContext.getDriver());
        informationPage.verifyInfoPage();
        informationPage.uploadImage();
        informationPage.fillPersonalDetailForOFAC();
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
        employmentInformationPage.verifyJoinAccountLabelInfoPage("Checking");
        informationPage.contactInfoNextButton();

        uploadDocumentsPage = new UploadDocumentsPage(WebDriverContext.getDriver());
        uploadDocumentsPage.verifyUploadDocumentsLabelPage();
        uploadDocumentsPage.uploadDoc();
        informationPage.contactInfoNextButton();

        certificationsPage = new CertificationsPage(WebDriverContext.getDriver());
        certificationsPage.verifyCertificationsLabelPage();
        certificationsPage.checkBackUpWithHoldingCertifiedRadio();
        certificationsPage.checkTaxCertifiedCheckBox();
        certificationsPage.checkpolicallyExosed("Checking");
        informationPage.contactInfoNextButton();

        agreementsDiscPage = new AgreementsDiscPage(WebDriverContext.getDriver());
        agreementsDiscPage.verifyAgreementsPage();
        agreementsDiscPage.checkAgreementNotice();
        informationPage.contactInfoNextButton();
        agreementsDiscPage.verifyAppUnderReview();

        navigateToCRMApplication();
       crmLoginPage = new CRMLoginPage(WebDriverContext.getDriver());
               crmLoginPage.loginToCRM();
        crmHomePage = new CRMHomePage(WebDriverContext.getDriver());
        crmHomePage.clickNRAATab();
        crmHomePage.clickNRAApplicationsLink();
        crmHomePage.verifyNraApplicationTab();
        crmHomePage.clickFirstNRAApp();
       crmHomePage.verifyOFACCheck();

       crmHomePage.creatOFACTicket();
        crmHomePage.approveOFACTicket();
        crmHomePage.clickNRAApplicationsLink();
        crmHomePage.clickFirstNRAApp();
          crmHomePage.verifyAccNo();
    }

}
