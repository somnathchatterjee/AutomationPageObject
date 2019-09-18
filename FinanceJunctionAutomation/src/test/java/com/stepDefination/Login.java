package com.stepDefination;

import com.pageObject.LoginPage;
import com.qa.utility.Log;
import org.testng.annotations.Test;

public class Login {

    public static LoginPage loginPage = new LoginPage();

    public static void loginUser(){

        try {
            Log.startTestCase("Start testing");
            loginPage.enterUsername("valid_username");
            Log.info("The username get entered");
            Thread.sleep(2000);
            loginPage.enterPassword("valid_password");
            Log.info("Pasword get Entered");
            Thread.sleep(2000);
            loginPage.selectBusinessUnit("valid_buname");
            Thread.sleep(1000);
            loginPage.clickSignInButton();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
