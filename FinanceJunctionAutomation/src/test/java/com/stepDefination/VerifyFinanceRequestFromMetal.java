package com.stepDefination;

import com.pageObject.*;
import com.qa.utility.Log;
import com.utilComponents.Scroll;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

public class VerifyFinanceRequestFromMetal {


    public static int row;
    public static int latestrow;

    public static MetalUser metalUser = new MetalUser();
    public static Scroll scroll = new Scroll();
    public static LoginPage loginPage = new LoginPage();
    public static AdminFinanceadd adminFinanceadd = new AdminFinanceadd();
    public static HomePage homePage = new HomePage();
    public static PendingRequest pendingRequest = new PendingRequest();

    @Test(priority = 1)
    public void verify_The_Metal_Login() {
        try {
            metalUser.navigateToMetal();
            metalUser.metalLogin("usernamemetal", "passwordmetal");
            if (metalUser.isRadioButtondisplayed()) {
                Log.info("We are going to kickout other user");
                metalUser.clickRadioButton();
                metalUser.clickAcceptButton();
                Thread.sleep(2000);

            } else {
                Log.info("We are in Dashboard page");
            }

            metalUser.clickAcceptButton();

        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    @Test(priority = 2)
    public void verify_The_Navigation_To_Finance_Module() {
        try {
            Thread.sleep(1000);
            metalUser.navigateToFinanceModule();
            Thread.sleep(2000);
         /* String actual = metalUser.getTitleOfPage();
          String expected = "Finance Market - Powering trade through efficient working capital management for supply chain & no guarantor business loans";
          Assert.assertEquals(actual,expected,"User not in Finance page");*/
        } catch (Exception e) {
            Log.info(e.getMessage());
        }

    }

    @Test(priority = 3)
    public void verify_The_Add_Request_From_Metal_User() {
        try {
            metalUser.navigateToAddFinanceRequest();
            Thread.sleep(1000);
            metalUser.selectOrganization();
            Thread.sleep(1000);
            metalUser.selectDataPoint();
            Thread.sleep(5000);
            metalUser.selectSoNumber();
            Thread.sleep(1000);
            boolean his = metalUser.isHistoryLinkDisplayed();
            Assert.assertTrue(his, "The history link is not displayed");
            metalUser.clickOnHistoryLink();
            Thread.sleep(1000);
            row = metalUser.sizeOfDataInTable();
            System.out.println(row);
            metalUser.closeHistory();
            Thread.sleep(1000);
            metalUser.selectBankAccount();
            Thread.sleep(1000);
            metalUser.enterCreditTenure();
            Thread.sleep(1000);
            metalUser.enterFinanceAmount2();
            Thread.sleep(1000);
            metalUser.enterFinanceAmount();
            Thread.sleep(1000);
            metalUser.clickOnSubmitButton();
            Thread.sleep(1000);
            metalUser.backToMainWindow();
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    @Test(priority = 4)
    public void verify_The_Acceptance_Of_Added_Finance_Request_From_Metal() {
        try {
            Thread.sleep(1000);
            Login.loginUser();
            Thread.sleep(1000);
            pendingRequest.navigateToFinanceRequestView();
            Thread.sleep(1000);
            pendingRequest.selectFromDate();
            Thread.sleep(1000);
            pendingRequest.selectToDate();
            Thread.sleep(1000);
            pendingRequest.clickOnSubmitButton();
            scroll.scrollUp("0","300");
            Thread.sleep(1000);
            pendingRequest.clickOnLatestModifyButton();
            Thread.sleep(1000);
            pendingRequest.modifyThestatus();
            Thread.sleep(1000);
            pendingRequest.enterConfermationNumber();
            Thread.sleep(1000);
            pendingRequest.enterModifyRemarks();
            Thread.sleep(1000);
            pendingRequest.clickOnSaveButton();
            Thread.sleep(1000);
            Logout.logoutfrompage();
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    @Test(priority = 5)
    public void verify_The_Added_Request_From_Metal_User_Is_Conferimed() {
        try {
            verify_The_Metal_Login();
            Thread.sleep(1000);
            verify_The_Navigation_To_Finance_Module();
            Thread.sleep(2000);
            metalUser.navigateToAddFinanceRequest();
            Thread.sleep(1000);
            metalUser.selectOrganization();
            Thread.sleep(1000);
            metalUser.selectDataPoint();
            Thread.sleep(5000);
            metalUser.selectSoNumber();
            Thread.sleep(1000);
            boolean his = metalUser.isHistoryLinkDisplayed();
            Assert.assertTrue(his, "The history link is not displayed");
            metalUser.clickOnHistoryLink();
            Thread.sleep(1000);
            latestrow = metalUser.sizeOfDataInTable();
            System.out.println(latestrow);
            System.out.println(row);
            Assert.assertTrue(row != latestrow, "The finance request is not submitted");
            metalUser.closeHistory();
            metalUser.navigateToRequestView();
            metalUser.selectFromDate();
            metalUser.selectToDate();
            metalUser.clickOnSubmitButtonToView();
            String status = metalUser.statusOfTheRequest();
            Assert.assertEquals(status,"Transaction Successful and Approved","Transaction is not approved");
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }
}
