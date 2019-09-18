package com.stepDefination;

import com.pageObject.EpsUser;
import com.pageObject.HomePage;
import com.pageObject.OrganizationAdd;
import com.pageObject.OrganizationView;
import com.qa.utility.ScreenShot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sun.awt.windows.ThemeReader;

public class VerifyTheOrganization {

    SoftAssert softAssert = new SoftAssert();
    private static OrganizationAdd organizationAdd=new OrganizationAdd();
    public static OrganizationView organizationView = new OrganizationView();
    private static HomePage homePage = new HomePage();
    private static EpsUser epsUser = new EpsUser();


    @Test(priority = 1)
    public void openAddOgranizationPage() throws Exception {
        homePage.clickOnRegisterButton();
        ScreenShot.takeScreenshot();
        Thread.sleep(2000);
        homePage.clickOnAddOrganization();
        ScreenShot.takeScreenshot();

    }

    @Test(priority = 2)
    public void verifyTheBusinessUnitIsDisplayed() throws Exception {
        boolean bu = organizationAdd.businessUnitDisplayed();
        ScreenShot.takeScreenshot();
        softAssert.assertTrue(bu);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyTheAddOrganization(){
        try {
            organizationAdd.selectBusinessUnit("bisunessunitdropdown");
            Thread.sleep(500);
            organizationAdd.selectOrganizationType("organizationtype");
            Thread.sleep(500);
            organizationAdd.enterOrganizationName("organizationname");
            Thread.sleep(500);
            organizationAdd.selectCountry("organizationcountryname");
            Thread.sleep(500);
            organizationAdd.selectState("organizationstate");
            Thread.sleep(500);
            organizationAdd.enterCity("organizationcity");
            Thread.sleep(500);
            organizationAdd.enterAddress("organizationaddress");
            Thread.sleep(500);
            organizationAdd.enterEmail("organizationemail");
            Thread.sleep(500);
            organizationAdd.clickSubmitButton();
            Thread.sleep(500);
            epsUser.selectAlert();

        }catch (Exception e){
            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 4)
    public void openViewOrganization(){

        homePage.clickOnRegisterButton();
        homePage.clickOnViewOrganization();

    }

    @Test(priority = 5)
    public void verifyTheAddedOrganization(){
        try {
            boolean fromdate = organizationView.isFromDateDisplayed();
            softAssert.assertTrue(fromdate);
            organizationView.selectFromDataOrg();
            Thread.sleep(1000);
            boolean todate = organizationView.isToDateDisplayed();
            softAssert.assertTrue(todate);
            organizationView.selectToDataOrg();
            Thread.sleep(1000);
            boolean button = organizationView.isSubmitButtonDisplayed();
            softAssert.assertTrue(button);
            organizationView.clickOnSubmitButtonOrg();
            Thread.sleep(2000);
            softAssert.assertTrue(organizationView.isSearchBoxDisplayed());
            organizationView.enterDataOnSearchBox();
            Thread.sleep(5500);
            //softAssert.assertTrue(organizationView.isSearchedDataDisplayed());
            //Thread.sleep(1000);
            organizationView.clickOnmodifyButtonandClose();
            softAssert.assertAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
