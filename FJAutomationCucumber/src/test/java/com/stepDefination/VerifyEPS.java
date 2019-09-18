package com.stepDefination;

import com.pageObject.EpsUser;
import com.utilComponents.Scroll;
import org.testng.annotations.Test;

public class VerifyEPS {

    public static EpsUser epsUser = new EpsUser();
    public static Scroll scroll = new Scroll();

    @Test(priority = 1)
    public void verify_login() throws InterruptedException {
        epsUser.navigateToEps();
        Thread.sleep(2000);
        epsUser.epsLogin("epsuserid", "epslogpass");
        epsUser.epsSelectorganization("epsloginorg");
        epsUser.clickOnOk();
    }

    @Test(priority = 2)
    public void dashboard(){

        epsUser.workOnDashboard();
    }
    @Test(priority = 3)
    public void fdashboard(){
        epsUser.addFinanceReqest();
        epsUser.selectClientOrg("epsclientorga");
        epsUser.selectClientDataPoint("epsdatapoints");
        epsUser.selectDataPointno("epsdatapointno");
        epsUser.selectBankAccount("bankacc");
        scroll.scrollUp();
        epsUser.enterCreditTenure();
        epsUser.enterFinanceAmount();
        epsUser.clickUserSubmit();
        epsUser.selectAlert();
        epsUser.backTomainWindow();
    }
}
