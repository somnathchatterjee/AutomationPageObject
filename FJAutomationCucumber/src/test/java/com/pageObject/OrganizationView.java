package com.pageObject;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
    private WebElement Modifybuttonorg;

    @FindBy(how = How.XPATH, using = "statusmodalorg")
    private WebElement Statusmodalorg;

    @FindBy(how = How.XPATH, using = "saveorg")
    private WebElement Saveorg;

    @FindBy(how = How.XPATH, using = "closeorg")
    private WebElement Closeorg;



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

    public void selectCurrentDataOrg() {
        try {
            Todateorg.click();
            Thread.sleep(1000);
            Todaydateorg.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
