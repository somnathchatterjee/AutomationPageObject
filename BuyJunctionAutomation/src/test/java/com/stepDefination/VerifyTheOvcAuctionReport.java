package com.stepDefination;

import com.pageObject.Admin.AdminHome;
import com.pageObject.Admin.AuctionReport;
import com.pageObject.LoginAndLogout.LoginPage;
import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.utility.Log;
import com.qa.utility.ScreenShot;
import com.utilComponents.Wait;
import org.testng.annotations.Test;

import java.rmi.Remote;

public class VerifyTheOvcAuctionReport {
    private static AdminHome adminHome = new AdminHome();
    private static LoginPage loginPage = new LoginPage();
    private static AuctionReport auctionReport = new AuctionReport();
    private static LogoutPage logoutPage = new LogoutPage();

    @Test
    public void check_The_Bid_Report(){

        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(2000);
            loginPage.enterUsername("Admin_usercode");
            Thread.sleep(1000);
            loginPage.enterPassword("valid_password1");
            Thread.sleep(2000);
            loginPage.clickSignInButton();
            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }

            Thread.sleep(1000);
            adminHome.hoverOnAuctionReport();
            Thread.sleep(1000);
            auctionReport.enterValueOfAucIdOne();
            auctionReport.selectAuctionRuleMultiSealedBid();
            auctionReport.clickOnEnterButton();
            Thread.sleep(5000);
            ScreenShot.takeScreenshot("Report");
            Thread.sleep(2000);
            auctionReport.back();
            auctionReport.enterValueOfAucIdTwo();
            auctionReport.selectAuctionRuleEnglishNoTies();
            auctionReport.clickOnEnterButton();
            Thread.sleep(5000);
            ScreenShot.takeScreenshot("Report");
            Thread.sleep(2000);
            logoutPage.logout();
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }
}
