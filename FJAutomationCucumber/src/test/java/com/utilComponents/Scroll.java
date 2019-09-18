package com.utilComponents;

import com.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll extends TestBase {

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
    }

    public void alertClick(){

        driver.switchTo().alert().accept();
    }
}
