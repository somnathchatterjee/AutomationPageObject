package com.stepDefination;

import com.pageObject.BranchAdd;
import com.pageObject.BranchView;
import com.pageObject.HomePage;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheBranch {

    private BranchAdd branchAdd = new BranchAdd();
    private BranchView branchView = new BranchView();
    private HomePage homePage = new HomePage();
    private SoftAssert softAssert = new SoftAssert();
    private Scroll scroll = new Scroll();

    @Test(priority = 6)
    public void openAddBranchPage(){
        try {
            homePage.clickOnRegisterButton();
            Thread.sleep(2000);
            homePage.clickOnAddBranch();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 7)
    public void verifyAddBranch(){
        try{
            branchAdd.selectBranchOrganization("branchorganizationdd");
            Thread.sleep(1500);
            branchAdd.enterBranchName("branchnameone");
            Thread.sleep(1500);
            branchAdd.selectBranchCountry("branchcountryname");
            Thread.sleep(1500);
            branchAdd.selectBranchState("branchstatename");
            Thread.sleep(1500);
            branchAdd.enterBranchCity("branchcityname");
            Thread.sleep(1500);
            branchAdd.enterBranchAddress("branchaddressdetails");
            Thread.sleep(1500);
            branchAdd.enterBranchGst("branchgstin");
            Thread.sleep(1500);
            branchAdd.clickOnBranchSubmit();
            Thread.sleep(2000);
            scroll.alertClick();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 8)
    public void openViewBranchPage(){
        try {
            homePage.clickOnRegisterButton();
            Thread.sleep(3000);
            homePage.clickOnViewBranch();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 9)
    public void verifyTheAddedBranch(){
        try{

            boolean branchdatef = branchView.isFromDateDisplayed();
            softAssert.assertTrue(branchdatef);
            Thread.sleep(500);
            boolean branchdatet = branchView.isToDateDisplayed();
            softAssert.assertTrue(branchdatet);
            Thread.sleep(500);
            branchView.selectFromDataBranch();
            Thread.sleep(1500);
            branchView.selectToDataBranch();
            Thread.sleep(1500);
            branchView.clickOnSubmitButtonBranch();
            Thread.sleep(1500);
            boolean searchbranch = branchView.isSearchBoxDisplayed();
            softAssert.assertTrue(searchbranch);
            Thread.sleep(500);
            branchView.enterDataOnSearchBox();
            Thread.sleep(500);
            branchView.clickOnmodifyButtonandClose();
            Thread.sleep(500);
            softAssert.assertAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
