package com.stepDefination;

import com.pageObject.Bidder.AddBidderVesselDetails;
import com.pageObject.Bidder.BidderHome;
import com.pageObject.Bidder.LiveBidPage;
import com.pageObject.Bidder.ViewTerm;
import com.pageObject.LoginAndLogout.LoginPage;
import com.pageObject.LoginAndLogout.LogoutPage;
import com.qa.configuration.ConfigManager;
import com.qa.utility.Log;
import com.qa.utility.ScreenShot;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

import static com.qa.configuration.ConfigManager.Config2;

public class VerifyAuctionNoticeForOcv {
    private static LoginPage loginPage = new LoginPage();
    private static BidderHome bidderHome = new BidderHome();
    private static LiveBidPage liveBidding = new LiveBidPage();
    private static ViewTerm viewTerm = new ViewTerm();
    private static Scroll scroll = new Scroll();
    private static SoftAssert softAssert = new SoftAssert();
    private static AddBidderVesselDetails addBidderVesselDetails = new AddBidderVesselDetails();
    private static LogoutPage logoutPage =new LogoutPage();

    @Test(priority = 1, enabled = true)
    public void verify_Auction_Notice_Is_Present_for_BidderOne(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            Thread.sleep(2000);
            loginPage.enterUsername("valid_usercode1");
            loginPage.enterPassword("valid_password");
            ScreenShot.takeScreenshot("AucNoticeBid1");
            loginPage.clickSignInButton();

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
                ScreenShot.takeScreenshot("AucNoticeBid1");
                String parent = scroll.fetchPartentWindow();
                viewTerm.selectTheAcceptButton();
                Thread.sleep(2000);
                Set<String> allWindows = scroll.fetchAllWindow();
                Log.info("Radio button Selected");
                for(String child : allWindows){
                    if(!parent.contentEquals(child)){
                        scroll.switchToWindow(child);
                        ScreenShot.takeScreenshot("AucNoticeBid1");
                        addBidderVesselDetails.enterVessel_Name("datavesselname");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterImo_Number("dataimono");
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectBuilt();
                        ScreenShot.takeScreenshot("AucNoticeBid1");
                        Thread.sleep(1000);
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterClass("datavclass");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterP_IClub("datapiclube");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterDeadWeight("datadeadweight");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterGrt("datagrt");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterNrt("datanrt");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterDraft("datadraft");
                        ScreenShot.takeScreenshot("AucNoticeBid1");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterAirDraft("dataairdraft");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterLengthOverall("datalengthoverall");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterBeam("databeam");
                        ScreenShot.takeScreenshot("AucNoticeBid1");
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectGearlessAndEnterHolds("datanoofholds");
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectOwnerShip();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectRightToRefusal();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectTheNationality("datanameoftheowner","dataheadowner");
                        ScreenShot.takeScreenshot("AucNoticeBid1");
                        Thread.sleep(1000);
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectVesselFlag("datapresentposition","dataetaloadport");
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectValidDocumentRequired();
                        Thread.sleep(1000);
                        addBidderVesselDetails.clickOnSubmitbutton();
                        Thread.sleep(2000);
                        scroll.alertClick();
                        Log.info("First alert clicked");
                        Thread.sleep(1000);
                        scroll.alertClick();
                        Log.info("Second alert clicked");
                        Thread.sleep(5000);
                        scroll.closeTheCurrentBrowser();
                        Log.info("Vessel details browser closed");
                    }
                }
                scroll.switchToWindow(parent);
                viewTerm.selectThePendingAuction();
                Log.info("CheckBox Selected");
                viewTerm.clickOnPendingSubmitButton();
                Log.info("Submit button Selected");
            }else {
                Log.info(viewTerm.noPendingNoticeFound());
            }
            Thread.sleep(3000);
            logoutPage.logout();
            Thread.sleep(1000);
            softAssert.assertAll();

        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

    @Test(priority = 2, enabled = true)
    public void verify_Auction_Notice_Is_Present_for_BidderTwo(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            Thread.sleep(3000);
            loginPage.enterUsername("valid_usercode2");
            loginPage.enterPassword("valid_password");
            ScreenShot.takeScreenshot("AucNoticeBid2");
            loginPage.clickSignInButton();

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
            Thread.sleep(1000);
            ScreenShot.takeScreenshot("AucNoticeBid2");
            if(viewTerm.noPendingNoticeFound().contentEquals("There is some Term need to accept")){
                viewTerm.selectThePendingAuction();
                Log.info("CheckBox Selected");
                String parent = scroll.fetchPartentWindow();
                viewTerm.selectTheAcceptButton();
                Thread.sleep(2000);
                Set<String> allWindows = scroll.fetchAllWindow();
                Log.info("Radio button Selected");
                for(String child : allWindows){
                    if(!parent.contentEquals(child)){
                        scroll.switchToWindow(child);
                        addBidderVesselDetails.enterVessel_Name("datavesselname");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterImo_Number("dataimono");
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectBuilt();
                        ScreenShot.takeScreenshot("AucNoticeBid2");
                        Thread.sleep(1000);
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterClass("datavclass");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterP_IClub("datapiclube");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterDeadWeight("datadeadweight");
                        ScreenShot.takeScreenshot("AucNoticeBid2");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterGrt("datagrt");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterNrt("datanrt");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterDraft("datadraft");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterAirDraft("dataairdraft");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterLengthOverall("datalengthoverall");
                        ScreenShot.takeScreenshot("AucNoticeBid2");
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterBeam("databeam");
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectGearlessAndEnterHolds("datanoofholds");
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectOwnerShip();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectRightToRefusal();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectTheNationality("datanameoftheowner","dataheadowner");
                        ScreenShot.takeScreenshot("AucNoticeBid2");
                        Thread.sleep(1000);
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectVesselFlag("datapresentposition","dataetaloadport");
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectValidDocumentRequired();
                        Thread.sleep(1000);
                        addBidderVesselDetails.clickOnSubmitbutton();
                        Thread.sleep(2000);
                        scroll.alertClick();
                        Thread.sleep(2000);
                        scroll.alertClick();
                        Thread.sleep(5000);
                        scroll.closeTheCurrentBrowser();
                    }
                }
                scroll.switchToWindow(parent);
                viewTerm.clickOnPendingSubmitButton();
                Log.info("Submit button Selected");
            }else {
                Log.info(viewTerm.noPendingNoticeFound());
            }
            logoutPage.logout();
            softAssert.assertAll();

        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }
}
