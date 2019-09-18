package com.stepDefination;

import com.pageObject.LogoutPage;

public class Logout {
    public static LogoutPage logoutPage = new LogoutPage();

    public static void logoutfrompage(){
        logoutPage.logout();
    }
}
