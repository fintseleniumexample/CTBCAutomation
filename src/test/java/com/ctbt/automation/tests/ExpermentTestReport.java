package com.ctbt.automation.tests;

import com.ctbt.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpermentTestReport extends BaseTest {


    @DataProvider(name = "accounts")
    public Object[][] provideCredentials() {
        return new Object[][]{
                {"Checking"},
                // { "Savings" },


        };
    }

//    @Test(dataProvider = "accounts")
//    public void ctbcSavingAndCheckingAccountVericationTest(String accountName) {
//        System.out.println(" this is example test:" + accountName);
//
//
//    }

    @Test(dataProvider = "accounts")
    public void ctbcSavingAndCheckingAccountVericationTest2(String accountName) {
        System.out.println(" this is example test:" + accountName);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }

//    @Test(dataProvider = "accounts")
//    public void ctbcSavingAndCheckingAccountVericationTest3(String accountName) {
//        System.out.println(" this is example test:" + accountName);
//
//    }

    @Test(dataProvider = "accounts")
    public void ctbcSavingAndCheckingAccountVericationTest4(String accountName) {
        System.out.println(" this is example test:" + accountName);
        Assert.fail("5th scenarios fail");

    }
}
