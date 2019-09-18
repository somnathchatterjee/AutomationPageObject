package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.ScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BranchView extends TestBase {

    @FindBy(how = How.XPATH, using = "fromdatebranch")
    private WebElement Fromdatebranch;

    @FindBy(how = How.XPATH, using = "todatebranch")
    private WebElement Todatebranch;

    @FindBy(how = How.XPATH, using = "prevmonthbranch")
    private WebElement Prevmonthbranch;

    @FindBy(how = How.XPATH, using = "nextmonthbranch")
    private WebElement Nextmonthbranch;

    @FindBy(how = How.XPATH, using = "monthfirstdaybranch")
    private WebElement Monthfirstdaybranch;

    @FindBy(how = How.XPATH, using = "todaydatebranch")
    private WebElement Todaydatebranch;

    @FindBy(how = How.XPATH, using = "viewsubmitbuttonbranch")
    private WebElement Viewsubmitbuttonbranch;

    @FindBy(how = How.XPATH, using = "searchbranch")
    private WebElement Searchbranch;

    @FindBy(how = How.XPATH, using = "modifybuttonbranch")
    private List<WebElement> Modifybuttonbranch;

    @FindBy(how = How.XPATH, using = "statusmodalbranch")
    private WebElement Statusmodalbranch;

    @FindBy(how = How.XPATH, using = "savebranch")
    private WebElement Savebranch;

    @FindBy(how = How.XPATH, using = "closebranch")
    private WebElement Closebranch;


    public boolean isFromDateDisplayed(){
        return Fromdatebranch.isDisplayed();
    }

    public boolean isToDateDisplayed(){
        return Todatebranch.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed(){
        return Viewsubmitbuttonbranch.isDisplayed();
    }

    public boolean isSearchBoxDisplayed(){
        return Searchbranch.isDisplayed();
    }

   /* public boolean isSearchedDataDisplayed(){
        return Modifybuttonbranch.isDisplayed();
    }*/

    public void selectFromDataBranch() {
        try {

            Fromdatebranch.click();
            Thread.sleep(1000);
            Prevmonthbranch.click();
            Thread.sleep(1000);
            Monthfirstdaybranch.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectToDataBranch() {
        try {
            Todatebranch.click();
            Thread.sleep(1000);
            Todaydatebranch.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnSubmitButtonBranch(){

        Viewsubmitbuttonbranch.click();
    }

    public void enterDataOnSearchBox(){

        Searchbranch.sendKeys(ConfigManager.getData("branchnameone"));
    }

    public void clickOnmodifyButtonandClose(){
        try {
            List<WebElement> bttn1 = Modifybuttonbranch;
            bttn1.get(0).click();
            ScreenShot.takeScreenshot();
            Closebranch.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
