package com.utilComponents;

import com.qa.base.TestBase;

import java.util.concurrent.TimeUnit;

public class Wait extends TestBase {

    public static void implicitWait(int sec){
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(int sec){

        driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
    }

}
