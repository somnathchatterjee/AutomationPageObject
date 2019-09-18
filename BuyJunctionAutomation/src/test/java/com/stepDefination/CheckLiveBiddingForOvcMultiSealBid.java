package com.stepDefination;

import com.pageObject.Bidder.BidderHome;
import com.pageObject.Bidder.LiveBidPage;
import com.pageObject.Bidder.ViewTerm;
import com.pageObject.LoginAndLogout.LoginPage;
import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.utility.Log;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;

public class CheckLiveBiddingForOvcMultiSealBid {
    private static LoginPage loginPage = new LoginPage();
    private static BidderHome bidderHome = new BidderHome();
    private static LiveBidPage liveBidding = new LiveBidPage();
    private static ViewTerm viewTerm = new ViewTerm();
    private static Scroll scroll = new Scroll();
    private static LogoutPage logoutPage = new LogoutPage();
    private static SoftAssert softAssert = new SoftAssert();

    public static String efficativePrice;

    @Test(priority = 1)
    public void verify_The_Live_Auction_Multi_Seal_Bid_User1() {

        //Login to bidder account
        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(30000);
            loginPage.enterUsername("valid_usercode1");
            Thread.sleep(2000);
            loginPage.enterPassword("valid_password1");
            Thread.sleep(2000);
            loginPage.clickSignInButton();
            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                Thread.sleep(2000);
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }

            // Hover on bid(s) option and rest of the login process
            Thread.sleep(60000);
            scroll.refreshPage();
            bidderHome.hoverOn_Bid_And_Click_On_Liveauction();
            scroll.alertClick();
            liveBidding.enterPassword("valid_password1");
            liveBidding.clickTransSignInButton();
            Thread.sleep(2000);
            liveBidding.deselectAuctionCheckBoxIfSelected();
            Thread.sleep(1000);
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            scroll.alertClick();
            Thread.sleep(2000);
            liveBidding.click();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();
            liveBidding.selectFirstCheckBox();
            Thread.sleep(1000);
            liveBidding.enterBidAmoutn("900.00");
            Thread.sleep(1000);
            liveBidding.clickOnSubmitButton();
            scroll.alertClick();
            Thread.sleep(4000);
            boolean bida = liveBidding.isBidAcceptedDisplayed();
            softAssert.assertTrue(bida);
            logoutPage.logout();
            softAssert.assertAll();

        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    @Test(priority = 2)
    public void verify_The_Live_Auction_Multi_Seal_Bid_User2() {

        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(3000);
            loginPage.enterUsername("valid_usercode2");
            Thread.sleep(1000);
            loginPage.enterPassword("valid_password");
            loginPage.clickSignInButton();

            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }
            Thread.sleep(1000);
            bidderHome.hoverOn_Bid_And_Click_On_Liveauction();
            scroll.alertClick();
            liveBidding.enterPassword("valid_password");
            liveBidding.clickTransSignInButton();
            Thread.sleep(2000);
            liveBidding.deselectAuctionCheckBoxIfSelected();
            Thread.sleep(1000);
            liveBidding.click();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            liveBidding.selectFirstCheckBox();
            Thread.sleep(1000);
            liveBidding.enterBidAmoutn("800.00");
            liveBidding.clickOnSubmitButton();
            Thread.sleep(1000);
            scroll.alertClick();
            Thread.sleep(4000);
            boolean bida = liveBidding.isBidAcceptedDisplayed();
            softAssert.assertTrue(bida);
            Thread.sleep(1000);
            efficativePrice = liveBidding.takeEffectedBidPrice();
            Log.info("Current Efficative bid price : " + efficativePrice);
            softAssert.assertAll();
            Thread.sleep(120000);
            logoutPage.logout();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    @Test(priority = 3)
    public void verify_The_Live_Auction_General_R_A_User1() {

        //Login to bidder account
        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(6000);
            loginPage.enterUsername("valid_usercode1");
            loginPage.enterPassword("valid_password1");
            loginPage.clickSignInButton();


            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }

            // Hover on bid(s) option and rest of the login process
            Thread.sleep(9000);
           // scroll.refreshPage();
            bidderHome.hoverOn_Bid_And_Click_On_Liveauction();
            scroll.alertClick();
            liveBidding.enterPassword("valid_password1");
            liveBidding.clickTransSignInButton();
            Thread.sleep(2000);
            liveBidding.deselectAuctionCheckBoxIfSelected();
            Thread.sleep(1000);
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            scroll.alertClick();
            Thread.sleep(2000);
            liveBidding.click();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();
            reverseAuction();
            Thread.sleep(2000);
            liveBidding.selectFirstCheckBox();
            Thread.sleep(1000);
            liveBidding.clickOnMinusButton();
            Thread.sleep(1000);
            liveBidding.clickOnSubmitButton();
            scroll.alertClick();
            Thread.sleep(4000);
            boolean bida = liveBidding.isBidAcceptedDisplayed();
            softAssert.assertTrue(bida);
            logoutPage.logout();
            Thread.sleep(2000);
            softAssert.assertAll();

        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    @Test(priority = 4)
    public void verify_The_Live_Auction_General_R_A_User2() {

        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(1000);
            loginPage.enterUsername("valid_usercode2");
            loginPage.enterPassword("valid_password");
            loginPage.clickSignInButton();

            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }
            Thread.sleep(1000);
            bidderHome.hoverOn_Bid_And_Click_On_Liveauction();
            scroll.alertClick();
            liveBidding.enterPassword("valid_password");
            liveBidding.clickTransSignInButton();
            Thread.sleep(2000);
            liveBidding.deselectAuctionCheckBoxIfSelected();
            Thread.sleep(1000);
            liveBidding.click();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            reverseAuction();
            Thread.sleep(1000);
            Thread.sleep(1000);
            liveBidding.clickOnMinusButton();
            Thread.sleep(1000);
            liveBidding.selectFirstCheckBox();
            Thread.sleep(1000);
            liveBidding.clickOnSubmitButton();
            Thread.sleep(1000);
            scroll.alertClick();
            Thread.sleep(4000);
            boolean bida = liveBidding.isBidAcceptedDisplayed();
            softAssert.assertTrue(bida);
            Thread.sleep(1000);
            efficativePrice = liveBidding.takeEffectedBidPrice();
            Log.info("Current Efficative bid price : " + efficativePrice);
            softAssert.assertAll();
            Thread.sleep(1000);
            logoutPage.logout();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }



    public void reverseAuction() {
        BigDecimal a = liveBidding.valueOfUserBidAmount();
        scroll.switchToFrame();
        BigDecimal b = liveBidding.valueOfCurrentMarketAmount();
        scroll.switchToParentFrame();

        if(b!=null) {
            if (a.compareTo(b) == -1) {
                //click submit button
            } else if (a.compareTo(b) == 0) {
                //click minus button
            } else {
                while (a.compareTo(b) == 1) {
                    liveBidding.clickOnMinusButton();
                    a = liveBidding.valueOfUserBidAmount();
                }
            }
        }else {
            liveBidding.clickOnMinusButton();
            liveBidding.clickOnMinusButton();
        }
    }
}
