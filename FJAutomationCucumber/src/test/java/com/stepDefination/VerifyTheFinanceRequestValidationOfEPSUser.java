package com.stepDefination;

import com.pageObject.AdminFinanceadd;
import com.pageObject.EpsUser;
import com.pageObject.HomePage;
import com.pageObject.LoginPage;
import com.qa.utility.ScreenShot;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;

public class VerifyTheFinanceRequestValidationOfEPSUser {

    private static EpsUser epsUser = new EpsUser();
    private static Scroll scroll = new Scroll();
    private static LoginPage loginPage = new LoginPage();
    private static AdminFinanceadd adminFinanceadd = new AdminFinanceadd();
    public static HomePage homePage = new HomePage();

    @Test(priority = 1)
    public void verifyEPSlogin() throws InterruptedException {
        epsUser.navigateToEps();
        Thread.sleep(2000);
        epsUser.epsLogin("epsuserid", "epslogpass");
        epsUser.epsSelectorganization("epsloginorg");
        epsUser.clickOnOk();
    }

    @Test(priority = 2)
    public void verifyTheEPSDashboard(){

        epsUser.workOnDashboard();
    }
    @Test(priority = 3)
    public void verifyTheEPSUserDashBoardAtFJ() throws Exception {
        epsUser.addFinanceReqest();
        epsUser.selectClientOrg("epsclientorga");
        epsUser.selectClientDataPoint("epsdatapoints");
        epsUser.selectDataPointno("epsdatapointno");
        epsUser.selectBankAccount("bankacc");
        Thread.sleep(1000);
        ScreenShot.takeScreenshot();
        Thread.sleep(500);
        scroll.scrollUp();
        epsUser.enterCreditTenure();
        epsUser.enterFinanceAmount();
        ScreenShot.takeScreenshot();
        Thread.sleep(500);
        epsUser.clickUserSubmit();
        epsUser.selectAlert();
        epsUser.backTomainWindow();
    }

    @Test(priority = 4)
    public void loginAsSuperAdmin(){
        try {
            loginPage.enterUsername("valid_username");
            Thread.sleep(1000);
            loginPage.enterPassword("valid_password");
            Thread.sleep(1000);
            loginPage.selectBusinessUnit("valid_buname");
            ScreenShot.takeScreenshot();
            Thread.sleep(1000);
            loginPage.clickSignInButton();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 5)
    public void ModifyTheLatestFinanceRequest(){
        try {
            homePage.clickFinanceRequest();
            homePage.clickFinanceAdd();
            Thread.sleep(1000);
            adminFinanceadd.selectFromDate();
            Thread.sleep(1000);
            adminFinanceadd.selectToDate();
            ScreenShot.takeScreenshot();
            Thread.sleep(500);
            adminFinanceadd.clickOnSubmitButton();
            scroll.scrollUp();
            Thread.sleep(500);
            adminFinanceadd.clickOnLatestModifyButton();
            ScreenShot.takeScreenshot();
            Thread.sleep(500);
            adminFinanceadd.modifyThestatus();
            Thread.sleep(500);
            adminFinanceadd.enterConfermationNumber();
            ScreenShot.takeScreenshot();
            Thread.sleep(500);
            adminFinanceadd.clickOnSaveButton();
            Thread.sleep(500);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
