package com.utilComponents;

import com.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll extends TestBase {

    public void scrollUp(String x, String y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void scrollUpToVisibleElement(WebElement element){
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView();", element);
    }


    public String alertText(){
        return driver.switchTo().alert().getText();
    }

    public void alertClick(){

        driver.switchTo().alert().accept();
    }
}
