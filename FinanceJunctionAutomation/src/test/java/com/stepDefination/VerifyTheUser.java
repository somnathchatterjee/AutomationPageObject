package com.stepDefination;

import com.pageObject.HomePage;
import com.pageObject.UserAdd;
import com.pageObject.UserView;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheUser {

    private static HomePage homePage = new HomePage();
    private static UserView userView = new UserView();
    private static UserAdd userAdd = new UserAdd();
    private static Scroll scroll = new Scroll();
    private static SoftAssert softAssert = new SoftAssert();

    @Test(priority = 10)
    public void openAddUserPage(){
        try {
            homePage.clickOnRegisterButton();
            Thread.sleep(1000);
            homePage.clickOnAddUser();
            Thread.sleep(1000);
            System.out.println("*****The Add user page is open.... Please enter your details*****");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 11)
    public void verifyAddUser(){
        try {
            userAdd.seletUserOrganization("UserOrganization");
            Thread.sleep(500);
            userAdd.seletUserBranch("UserBranch");
            Thread.sleep(500);
            userAdd.seletUserType("UserType");
            Thread.sleep(500);
            userAdd.enterFirstName("FirstName");
            Thread.sleep(500);
            userAdd.enterLastName("LastName");
            Thread.sleep(500);
            userAdd.enterUserLoginId("UserLogin");
            Thread.sleep(500);
            userAdd.selectCountry("UserCountry");
            Thread.sleep(500);
            userAdd.selectState("UserState");
            Thread.sleep(500);
            userAdd.enterCity("UserCity");
            Thread.sleep(500);
            userAdd.enterAddress("UserAddress");
            Thread.sleep(500);
            userAdd.enterPostalCode("PostalCode");
            Thread.sleep(500);
            userAdd.enterPanNo("PAN");
            Thread.sleep(500);
            userAdd.enterPhone("Phonenumber");
            Thread.sleep(500);
            userAdd.enterFax("FAX");
            Thread.sleep(500);
            userAdd.enterPrimaryEmail("PrimaryEmail");
            Thread.sleep(500);
            userAdd.enterPrimaryMobile("PrimaryMobile");
            Thread.sleep(500);
            userAdd.clickOnSubmitButton();
            System.out.println("**************The user is created successfully******************");
            scroll.alertClick();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 12)
    public void openViewUserPage(){
        try {
            homePage.clickOnRegisterButton();
            Thread.sleep(1000);
            homePage.clickOnViewUser();
            Thread.sleep(1000);
            System.out.println("*****The Add user page is open.... Please enter your details*****");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 13)
    public void verifyTheAddedUser(){
        try{
            boolean userdatef = userView.isFromDateDisplayed();
            softAssert.assertTrue(userdatef);
            Thread.sleep(500);
            boolean userdatet = userView.isToDateDisplayed();
            softAssert.assertTrue(userdatet);
            Thread.sleep(500);
            userView.selectFromDataBranch();
            Thread.sleep(500);
            userView.selectToDataBranch();
            Thread.sleep(500);
            userView.clickOnSubmitButtonBranch();
            Thread.sleep(500);
            boolean searchuser = userView.isSearchBoxDisplayed();
            softAssert.assertTrue(searchuser);
            Thread.sleep(500);
            userView.enterDataOnSearchBox();
            Thread.sleep(500);
            userView.clickOnModifyButtonAndClose();
            Thread.sleep(500);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
