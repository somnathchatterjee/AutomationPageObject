package com.utilComponents;

import com.pageObject.LoginAndLogout.LoginPage;
import com.qa.base.TestBase;
import com.qa.utility.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;


public class Utility extends TestBase {

    public static LoginPage loginPage = new LoginPage();

    @FindBy(how = How.XPATH, using = "frameone")
    private WebElement Frameone;

    @FindBy(how = How.XPATH, using = "staticframe")
    private WebElement staticframe;

    @FindBy(how = How.XPATH, using = "staticsubframe")
    private WebElement staticsubframe;

    public void scrollUp(String x, String y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void pageDown(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public void scrollUpToVisibleElement(WebElement element){
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void highlightTheVisibleElement(WebElement element){
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


    public String alertText(){
        return driver.switchTo().alert().getText();
    }

    public void alertClick(){

        driver.switchTo().alert().accept();
    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

    public void switchToFrame(){
        //highlightTheVisibleElement(Frameone);
        driver.switchTo().frame(Frameone);
    }
    public void switchToParentFrame(){

        driver.switchTo().defaultContent();
    }

    public void explictWait(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(ele)).getText();
    }

    public void switchToFrameAtStatic(){

        driver.switchTo().frame(staticframe);
    }

    public void switchToSubFrameAtStatic(){

        driver.switchTo().frame(staticsubframe);
    }

    public String fetchPartentWindow(){

        return driver.getWindowHandle();
    }

    public Set<String> fetchAllWindow(){

        return driver.getWindowHandles();
    }

    public void switchToWindow(String windw){

        driver.switchTo().window(windw);
        driver.manage().window().maximize();
    }

    public void closeTheCurrentBrowser(){

        driver.close();
    }

    public void refreshPage(){
        driver.navigate().refresh();
        if (loginPage.isRadioButtondisplayed()) {
            Log.info("We are going to kickout other user");
            loginPage.clickRadioButton();
            loginPage.clickEnterButton();
        } else {
            driver.switchTo().alert().accept();
        }

    }
}
