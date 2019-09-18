package com.utilComponents;

import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.base.TestBase;
import com.qa.configuration.DriverManager;
import com.stepDefination.Logout;
import org.testng.annotations.*;

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