package com.utilComponents;

import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.base.TestBase;
import com.qa.configuration.DriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Hooks extends TestBase {
    private static LogoutPage logoutPage = new LogoutPage();

    @AfterTest
    public void logoutBidder(){
        logoutPage.logout();
    }

    @AfterSuite
    public void tearDown(){
        DriverManager.cleanup();
    }
}