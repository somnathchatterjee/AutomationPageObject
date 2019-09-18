package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.ScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OrganizationView extends TestBase {

    @FindBy(how = How.XPATH, using = "fromdateorg")
    private WebElement Fromdateorg;

    @FindBy(how = How.XPATH, using = "todateorg")
    private WebElement Todateorg;

    @FindBy(how = How.XPATH, using = "prevmonthorg")
    private WebElement Prevmonthorg;

    @FindBy(how = How.XPATH, using = "nextmonthorg")
    private WebElement Nextmonthorg;

    @FindBy(how = How.XPATH, using = "monthfirstdayorg")
    private WebElement Monthfirstdayorg;

    @FindBy(how = How.XPATH, using = "todaydateorg")
    private WebElement Todaydateorg;

    @FindBy(how = How.XPATH, using = "viewsubmitbuttonorg")
    private WebElement Viewsubmitbuttonorg;

    @FindBy(how = How.XPATH, using = "searchorg")
    private WebElement Searchorg;

    @FindBy(how = How.XPATH, using = "modifybuttonorg")
    private List<WebElement> Modifybuttonorg;

    @FindBy(how = How.XPATH, using = "statusmodalorg")
    private WebElement Statusmodalorg;

    @FindBy(how = How.XPATH, using = "saveorg")
    private WebElement Saveorg;

    @FindBy(how = How.XPATH, using = "closeorg")
    private WebElement Closeorg;


    public boolean isFromDateDisplayed(){
        return Fromdateorg.isDisplayed();
    }

    public boolean isToDateDisplayed(){
        return Todateorg.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed(){
        return Viewsubmitbuttonorg.isDisplayed();
    }

    public boolean isSearchBoxDisplayed(){
        return Searchorg.isDisplayed();
    }

   /* public boolean isSearchedDataDisplayed(){

        return Modifybuttonorg.isDisplayed();
    }*/

    public void selectFromDataOrg() {
        try {

            Fromdateorg.click();
            Thread.sleep(1000);
            Prevmonthorg.click();
            Thread.sleep(1000);
            Monthfirstdayorg.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectToDataOrg() {
        try {
            Todateorg.click();
            Thread.sleep(1000);
            Todaydateorg.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnSubmitButtonOrg(){
        Viewsubmitbuttonorg.click();
    }

    public void enterDataOnSearchBox(){
        Searchorg.sendKeys(ConfigManager.getData("organizationname"));
    }

    public void clickOnmodifyButtonandClose(){
        try {
            List<WebElement> bttn = Modifybuttonorg;
            bttn.get(0).click();
            Thread.sleep(2000);
            //ScreenShot.takeScreenshot();
            Closeorg.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
