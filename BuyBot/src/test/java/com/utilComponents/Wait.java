package com.utilComponents;

import com.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait extends TestBase {

    public static void implicitWait(int sec){
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(int sec){

        driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
    }

}
