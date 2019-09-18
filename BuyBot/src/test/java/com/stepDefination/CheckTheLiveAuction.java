package com.stepDefination;

import com.pageObject.Bidder.BidderHome;
import com.pageObject.Bidder.LiveBidPage;
import com.pageObject.Bidder.ViewTerm;
import com.pageObject.LoginAndLogout.LoginPage;
import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.utility.Log;
import com.utilComponents.Utility;
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
    private static Utility scroll = new Utility();
    private static LogoutPage logoutPage = new LogoutPage();
    private static SoftAssert softAssert = new SoftAssert();
    static BigDecimal a;
    static BigDecimal b;

    public static String efficativePrice;

    @Test(priority = 1)
    public void navigate_To_Live_Bidding_Page(){

        //Login to bidder account
        try {
            Log.startTestCase(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Thread.sleep(1000);
            loginPage.enterUsername("valid_usercode2");
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
            Thread.sleep(1000);
            bidderHome.hoverOn_Bid_And_Click_On_Liveauction();
            scroll.alertClick();
            liveBidding.enterPassword("valid_password1");
            liveBidding.clickTransSignInButton();
            Thread.sleep(2000);
            liveBidding.deselectAuctionCheckBoxIfSelected();
            Thread.sleep(2000);
            liveBidding.selectAllAuctions();
            Thread.sleep(2000);
            liveBidding.clickOnWatchListButton();
            for(int i=0;i<=100;i++){
                checkAuctionForBid();
                System.out.println("Now wait for 3 second"+"This is:"+i+"Loop");
                Thread.sleep(180000);
            }
        } catch (Exception e) {
            System.out.println("navigate_To_Live_Bidding_Page");
            Log.info(e.getMessage());
        }
    }

    private void auction_Submit(){
        try {
            liveBidding.selectAuctionCheckBox();
            Thread.sleep(1000);
            liveBidding.clickOnMinusButton();
            Thread.sleep(1000);
            liveBidding.clickOnSubmitButton();
            boolean alert = scroll.isAlertPresent();
            if(alert){
                scroll.alertClick();
            }else {
                Log.info("No alert present : "+alert);
            }
            boolean reject = liveBidding.isBidRejectedDisplayed();
            if(reject){
                checkAuctionForBid();
            }else {
                System.out.println("------");
            }
        }catch (Exception e){
            System.out.println("auction_Submit");
            Log.info(e.getMessage());
        }
    }


    private void checkAuctionForBid() {
        try {
            scroll.switchToFrame();
            int total_size = liveBidding.sizeOfCurrentMarket();
            System.out.println("Total"+total_size);
            for (int i = 0; i < total_size; i++) {
                scroll.switchToParentFrame();
                Thread.sleep(1000);
                a = liveBidding.valueOfUserBidAmount().get(i);
                System.out.println(a);
                Thread.sleep(1000);
                scroll.switchToFrame();
                b = liveBidding.valueOfCurrentMarketAmount().get(i);
                System.out.println(b);
                if (a.compareTo(b) == -1) {
                    scroll.switchToParentFrame();
                    auction_Submit();
                    System.out.println("Main frame -1");
                } else if (a.compareTo(b) == 0) {
                    scroll.switchToParentFrame();
                    auction_Submit();
                    System.out.println("Main frame 0");
                } else {
                    while (a.compareTo(b) == 1) {
                        scroll.switchToParentFrame();
                        liveBidding.clickOnMinusButton();
                        a = liveBidding.valueOfUserBidAmount().get(i);
                    }
                    auction_Submit();
                }
            }
        }catch (Exception e){
            System.out.println("checkAuctionForBid");
            Log.info(e.getMessage());
        }
    }
}
