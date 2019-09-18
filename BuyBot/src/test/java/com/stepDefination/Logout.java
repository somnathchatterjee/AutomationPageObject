package com.stepDefination;

import com.pageObject.LoginAndLogout.LogoutPage;

public class Logout {
    private static LogoutPage logoutPage = new LogoutPage();

    public static void logoutfrompage(){
        logoutPage.logout();
    }

}
