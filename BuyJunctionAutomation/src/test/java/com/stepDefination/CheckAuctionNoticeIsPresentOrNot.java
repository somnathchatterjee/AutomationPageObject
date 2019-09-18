package com.stepDefination;

import com.pageObject.Bidder.AddBidderVesselDetails;
import com.pageObject.Bidder.BidderHome;
import com.pageObject.Bidder.LiveBidPage;
import com.pageObject.Bidder.ViewTerm;
import com.pageObject.LoginAndLogout.LoginPage;
import com.qa.utility.Log;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;


public class CheckAuctionNoticeIsPresentOrNot {

    private static LoginPage loginPage = new LoginPage();
    private static BidderHome bidderHome = new BidderHome();
    private static LiveBidPage liveBidding = new LiveBidPage();
    private static ViewTerm viewTerm = new ViewTerm();
    private static Scroll scroll = new Scroll();
    private static SoftAssert softAssert = new SoftAssert();
    private static AddBidderVesselDetails addBidderVesselDetails = new AddBidderVesselDetails();

    //@Test(priority = 1)
    public void verify_Auction_Notice_Is_Present_Or_Not_Under_Pending(){

        try {

            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            Thread.sleep(3000);
            loginPage.enterUsername("valid_usercode1");
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
                String parent = scroll.fetchPartentWindow();
                viewTerm.selectTheAcceptButton();
                Thread.sleep(2000);
                Set<String> allWindows = scroll.fetchAllWindow();
                Log.info("Radio button Selected");
                for(String child : allWindows){
                    if(!parent.contentEquals(child)){
                        scroll.switchToWindow(child);
                        addBidderVesselDetails.enterVessel_Name("datavesselname");
                        addBidderVesselDetails.enterImo_Number("dataimono");
                        addBidderVesselDetails.selectBuilt();
                        Thread.sleep(1000);
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.enterClass("datavclass");
                        addBidderVesselDetails.enterP_IClub("datapiclube");
                        addBidderVesselDetails.enterDeadWeight("datadeadweight");
                        addBidderVesselDetails.enterGrt("datagrt");
                        addBidderVesselDetails.enterNrt("datanrt");
                        addBidderVesselDetails.enterDraft("datadraft");
                        addBidderVesselDetails.enterAirDraft("dataairdraft");
                        addBidderVesselDetails.enterLengthOverall("datalengthoverall");
                        addBidderVesselDetails.enterBeam("databeam");
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectGearlessAndEnterHolds("datanoofholds");
                        addBidderVesselDetails.selectOwnerShip();
                        addBidderVesselDetails.selectRightToRefusal();
                        addBidderVesselDetails.selectTheNationality("datanameoftheowner","dataheadowner");
                        scroll.pageDown();
                        Thread.sleep(1000);
                        addBidderVesselDetails.selectVesselFlag("datapresentposition","dataetaloadport");
                        addBidderVesselDetails.selectValidDocumentRequired();
                        addBidderVesselDetails.clickOnSubmitbutton();
                        scroll.alertClick();
                        scroll.alertClick();
                        scroll.closeTheCurrentBrowser();
                    }

                }
                scroll.switchToWindow(parent);
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

   // @Test(priority = 2)
    public void verify_Auction_Notice_Is_Present_Or_Not_Under_Accepted(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            viewTerm.selectAccepedCheckBox();
            int noofnotice = viewTerm.numberOfAcceptedNotice();
            softAssert.assertEquals(2,noofnotice);
            softAssert.assertAll();
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

    //@Test(priority = 3)
    public void verify_Auction_Notice_Is_Present_Or_Not_Under_Rejected(){

        try {
            Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
            viewTerm.selectRejectedCheckBox();
            int noofnotice = viewTerm.numberOfAcceptedNotice();
            softAssert.assertEquals(0,noofnotice);
            softAssert.assertAll();
        }catch (Exception e){
            Log.error(e.getMessage());
        }

    }

}
