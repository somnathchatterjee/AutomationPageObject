package com.utilComponents;

import com.qa.base.TestBase;
import com.qa.configuration.DriverManager;
import com.stepDefination.Login;
import com.stepDefination.Logout;
import org.testng.annotations.*;

public class Hooks extends TestBase {

   /* @BeforeTest
    public void login(){
        Login.loginUser();
    }

    @AfterTest
    public void loggout(){
        Logout.logoutfrompage();
    }*/

    @AfterSuite
    public void tearDown(){
        DriverManager.cleanup();
    }
}