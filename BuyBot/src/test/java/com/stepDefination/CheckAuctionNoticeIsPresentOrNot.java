package com.stepDefination;

import com.pageObject.Bidder.BidderHome;
import com.pageObject.Bidder.LiveBidPage;
import com.pageObject.Bidder.ViewTerm;
import com.pageObject.LoginAndLogout.LoginPage;
import com.qa.utility.Log;
import com.utilComponents.Utility;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CheckAuctionNoticeIsPresentOrNot {

    private static LoginPage loginPage = new LoginPage();
    private static BidderHome bidderHome = new BidderHome();
    private static LiveBidPage liveBidding = new LiveBidPage();
    private static ViewTerm viewTerm = new ViewTerm();
    private static Utility scroll = new Utility();
    private static SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void verify_Auction_Notice_Is_Present_Or_Not_Under_Pending(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            Thread.sleep(3000);
            loginPage.enterUsername("valid_usercode2");
            Thread.sleep(1000);
            loginPage.enterPassword("valid_password1");
            Thread.sleep(1000);
            loginPage.clickSignInButton();
            Thread.sleep(1000);
            if (loginPage.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                loginPage.clickRadioButton();
                loginPage.clickEnterButton();
            } else {
                Log.info("We are in AdminHome page");
            }
            boolean tc = bidderHome.isTermdropdownDisplayed();
            softAssert.assertTrue(tc);
            bidderHome.hoverOnTerm_And_Click_On_ViewTerm();
            if(viewTerm.noPendingNoticeFound().contentEquals("There is some Term need to accept")){
                viewTerm.selectThePendingAuction();
                Log.info("CheckBox Selected");
                viewTerm.selectTheAcceptButton();
                Thread.sleep(2000);
                viewTerm.clickOnPendingSubmitButton();
                Log.info("Submit button Selected");
            }else {
                Log.info(viewTerm.noPendingNoticeFound());
            }
            softAssert.assertAll();

        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

   @Test(priority = 2)
    public void verify_Auction_Notice_Is_Present_Or_Not_Under_Accepted(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            viewTerm.selectAccepedCheckBox();
            Thread.sleep(2000);
            int noofnotice1 = viewTerm.numberOfAcceptedNotice();
            softAssert.assertEquals(noofnotice1,2);
            softAssert.assertAll();
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

    @Test(priority = 3)
    public void verify_Auction_Notice_Is_Present_Or_Not_Under_Rejected(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            viewTerm.selectRejectedCheckBox();
            Thread.sleep(1500);
            int noofnotice = viewTerm.numberOfAcceptedNotice();
            softAssert.assertEquals(noofnotice,0);
            softAssert.assertAll();
        }catch (Exception e){
            Log.error(e.getMessage());
        }

    }

}
