package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.ScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserView extends TestBase {

    @FindBy(how = How.XPATH, using = "fromdateuser")
    private WebElement Fromdateuser;

    @FindBy(how = How.XPATH, using = "todateuser")
    private WebElement Todateuser;

    @FindBy(how = How.XPATH, using = "prevmonthuser")
    private WebElement Prevmonthuser;

    @FindBy(how = How.XPATH, using = "nextmonthuser")
    private WebElement Nextmonthuser;

    @FindBy(how = How.XPATH, using = "monthfirstdayuser")
    private WebElement Monthfirstdayuser;

    @FindBy(how = How.XPATH, using = "todaydateuser")
    private WebElement Todaydateuser;

    @FindBy(how = How.XPATH, using = "viewsubmitbuttonuser")
    private WebElement Viewsubmitbuttonuser;

    @FindBy(how = How.XPATH, using = "searchuser")
    private WebElement Searchuser;

    @FindBy(how = How.XPATH, using = "modifybuttonuser")
    private List<WebElement> Modifybuttonuser;

    @FindBy(how = How.XPATH, using = "statusmodaluser")
    private WebElement Statusmodaluser;

    @FindBy(how = How.XPATH, using = "saveuser")
    private WebElement Saveuser;

    @FindBy(how = How.XPATH, using = "closeuser")
    private WebElement Closeuser;


    public boolean isFromDateDisplayed(){
        return Fromdateuser.isDisplayed();
    }

    public boolean isToDateDisplayed(){
        return Todateuser.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed(){
        return Viewsubmitbuttonuser.isDisplayed();
    }

    public boolean isSearchBoxDisplayed(){
        return Searchuser.isDisplayed();
    }

   /* public boolean isSearchedDataDisplayed(){
        return Modifybuttonuser.isDisplayed();
    } */

    public void selectFromDataBranch() {
        try {

            Fromdateuser.click();
            Thread.sleep(1000);
            Prevmonthuser.click();
            Thread.sleep(1000);
            Monthfirstdayuser.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectToDataBranch() {
        try {
            Todateuser.click();
            Thread.sleep(1000);
            Todaydateuser.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnSubmitButtonBranch(){

        Viewsubmitbuttonuser.click();
    }

    public void enterDataOnSearchBox(){

        Searchuser.sendKeys(ConfigManager.getData("UserLogin"));
    }

    public void clickOnModifyButtonAndClose(){
        try {
            List<WebElement> bttn2 = Modifybuttonuser;
            bttn2.get(0).click();
            ScreenShot.takeScreenshot();
            Closeuser.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
