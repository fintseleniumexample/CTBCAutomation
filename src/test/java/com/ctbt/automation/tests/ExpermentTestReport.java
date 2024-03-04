package com.ctbt.automation.tests;

import com.ctbt.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpermentTestReport extends BaseTest {
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
        return new Object[][]{
                {"Checking"},
                // { "Savings" },


        };
    }

    @Test(dataProvider = "accounts")
    public void ctbcSavingAndCheckingAccountVericationTest(String accountName) {
        System.out.println(" this is example test:" + accountName);
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        Assert.fail("failed testing");
    }

//    @Test(dataProvider = "accounts")
//    public void ctbcSavingAndCheckingAccountVericationTest2(String accountName) {
//        System.out.println(" this is example test:" + accountName);
//        try {
//            Thread.sleep(10000);
//        } catch (Exception e) {
//
//        }
//    }
//
//    @Test(dataProvider = "accounts")
//    public void ctbcSavingAndCheckingAccountVericationTest3(String accountName) {
//        System.out.println(" this is example test:" + accountName);
//        Assert.fail("3rd scenarios fail");
//    }
//
//    @Test(dataProvider = "accounts")
//    public void ctbcSavingAndCheckingAccountVericationTest4(String accountName) {
//        System.out.println(" this is example test:" + accountName);
//        Assert.fail("4rd scenarios fail");
//
//    }
}
