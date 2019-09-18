package com.stepDefination;

import com.pageObject.Bidder.BidderHome;
import com.pageObject.Bidder.LiveBidPage;
import com.pageObject.Bidder.ViewTerm;
import com.pageObject.LoginAndLogout.LoginPage;
import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.utility.Log;
import com.utilComponents.Scroll;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;

public class CheckTheLiveAuction {

    private static LoginPage loginPage = new LoginPage();
    private static BidderHome bidderHome = new BidderHome();
    private static LiveBidPage liveBidding = new LiveBidPage();
    private static ViewTerm viewTerm = new ViewTerm();
    private static Scroll scroll = new Scroll();
    private static LogoutPage logoutPage = new LogoutPage();
    private static SoftAssert softAssert = new SoftAssert();

    public static String efficativePrice;

   // @Test(priority = 1)
    public void verify_The_Live_Auction_User1() {

        //Login to bidder account
        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(1000);
            loginPage.enterUsername("valid_usercode1");
            loginPage.enterPassword("valid_password");
            loginPage.clickSignInButton();


            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }

            // Hover on bid(s) option and rest of the login process
            Thread.sleep(1000);
            bidderHome.hoverOn_Bid_And_Click_On_Liveauction();
            scroll.alertClick();
            liveBidding.enterPassword("valid_password");
            liveBidding.clickTransSignInButton();
            Thread.sleep(2000);
            liveBidding.deselectAuctionCheckBoxIfSelected();
            Thread.sleep(1000);
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            scroll.alertClick();
            Thread.sleep(2000);
            liveBidding.selectAuctions();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();

            //Switch to the frame
            /*Thread.sleep(4000);
            scroll.switchToFrame();
            Log.info("Switch to frame");
            Thread.sleep(2000);
            //Take current price
            String current = liveBidding.currentPrice();
            Log.info("Price to add"+current);

            //Switch back to main frame
            scroll.switchToParentFrame();
            Log.info("Switch to main frame");

            Thread.sleep(1000);
            liveBidding.enterBidAmoutn(current);*/

            test();
            liveBidding.selectFirstCheckBox();
            Thread.sleep(1000);
            liveBidding.clickOnMinusButton();
            Thread.sleep(1000);
            liveBidding.clickOnSubmitButton();
            Thread.sleep(4000);
            boolean bida = liveBidding.isBidAcceptedDisplayed();
            softAssert.assertTrue(bida);
            scroll.switchToFrame();
            boolean hammer = liveBidding.isHammerDisplayed();
            softAssert.assertTrue(hammer, "The hammer is not displaying");
            Log.info("Hammer is displaying");
            scroll.switchToParentFrame();

            Thread.sleep(2000);

            liveBidding.selectFirstCheckBox();
            liveBidding.clickOnSubmitButton();
            Thread.sleep(4000);
            boolean bidr = liveBidding.isBidRejectedDisplayed();
            softAssert.assertTrue(bidr);
            efficativePrice = liveBidding.takeEffectedBidPrice();
            Log.info("Current Efficative bid price : " + efficativePrice);
            logoutPage.logout();

            softAssert.assertAll();

        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

   // @Test(priority = 2)
    public void verify_The_Live_Auction_User2() {

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
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            scroll.alertClick();
            liveBidding.selectAuctions();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();
            Thread.sleep(1000);
            scroll.switchToFrame();
            boolean hammer = liveBidding.isHammerDisplayed();
            softAssert.assertFalse(hammer, "The hammer is displaying");
            Log.info("Hammer is not displaying");
            scroll.switchToParentFrame();

            Thread.sleep(2000);
            /*scroll.switchToFrame();
            Log.info("Switch to frame");
            Thread.sleep(2000);
            //Take current price
            String current1 = liveBidding.currentPrice();
            Log.info("Price to add" + current1);

            //Switch back to main frame
            scroll.switchToParentFrame();

            liveBidding.enterBidAmoutn(current1);*/

            test();
            Thread.sleep(1000);
            liveBidding.clickOnMinusButton();
            Thread.sleep(1000);
            liveBidding.selectFirstCheckBox();
            Thread.sleep(1000);
            liveBidding.clickOnSubmitButton();
            Thread.sleep(4000);
            boolean bida = liveBidding.isBidAcceptedDisplayed();
            softAssert.assertTrue(bida);
            Thread.sleep(1000);
            scroll.switchToFrame();
            Thread.sleep(2000);
            boolean hammer1 = liveBidding.isHammerDisplayed();
            softAssert.assertTrue(hammer1, "The hammer is not displaying");
            Log.info("Hammer is displaying");
            scroll.switchToParentFrame();
            Thread.sleep(1000);
            liveBidding.selectFirstCheckBox();
            liveBidding.clickOnSubmitButton();
            Thread.sleep(4000);
            boolean bidr = liveBidding.isBidRejectedDisplayed();
            softAssert.assertTrue(bidr);
            efficativePrice = liveBidding.takeEffectedBidPrice();
            Log.info("Current Efficative bid price : " + efficativePrice);

            softAssert.assertAll();

        } catch (Exception e) {
            Log.error(e.getMessage());
        }

    }

    public void test() {
        BigDecimal a = liveBidding.valueOfUserBidAmount();
        scroll.switchToFrame();
        BigDecimal b = liveBidding.valueOfCurrentMarketAmount();
        scroll.switchToParentFrame();

        if(a.compareTo(b)==-1){
            //click submit button
        }else if(a.compareTo(b)==0) {
            //click minus button
        }else {
            while (a.compareTo(b)==1){
                liveBidding.clickOnMinusButton();
                a = liveBidding.valueOfUserBidAmount();
            }
        }
    }
}
