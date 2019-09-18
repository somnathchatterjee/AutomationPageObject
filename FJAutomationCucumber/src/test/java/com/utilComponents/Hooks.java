package com.utilComponents;

import com.qa.base.TestBase;
import com.qa.configuration.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Hooks extends TestBase {


    @Before
    public void start() throws Exception {
        DriverManager.getInstance();
    }


    @After
    public void tearDown1(){
        DriverManager.cleanup();
    }

    @AfterClass
    public void logout(){

    }

    @AfterSuite
    public void tearDown(){
        DriverManager.cleanup();
    }
}