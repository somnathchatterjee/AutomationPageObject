package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.DateAndTime;
import com.qa.utility.Log;
import com.utilComponents.Scroll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChangeAuctionStatus extends TestBase {

    Scroll scroll = new Scroll();
    public static String key = "AucId";

    @FindBy(how = How.XPATH, using = "statusfirstdate")
    private WebElement statusfirstdate;

    @FindBy(how = How.XPATH, using = "statusseconddate")
    private WebElement statusseconddate;

    @FindBy(how = How.XPATH, using = "auctionstatus")
    private WebElement auctionstatus;

    @FindBy(how = How.XPATH, using = "auctiontype")
    private WebElement auctiontype;

    @FindBy(how = How.XPATH, using = "clientid")
    private WebElement clientid;

    @FindBy(how = How.XPATH, using = "searchbutton")
    private WebElement searchbutton;

    @FindBy(how = How.XPATH, using = "statuscheckbox")
    private List<WebElement> statuscheckbox;

    @FindBy(how = How.XPATH, using = "statussuccess")
    private List<WebElement> statussuccess;

    @FindBy(how = How.XPATH, using = "tabledata")
    private WebElement tabledata;

    @FindBy(how = How.XPATH, using = "changeauctionstatusbutton")
    private WebElement changeauctionstatusbutton;

    public void enterStartDate(){
        String latedatetime = DateAndTime.dateAndTime(-10);
        statusfirstdate.clear();
        statusfirstdate.sendKeys(latedatetime);
    }

    public void enterEndDate(){
        String erlydatetime = DateAndTime.dateAndTime(55);
        statusseconddate.clear();
        statusseconddate.sendKeys(erlydatetime);
    }

    public void selectStatus(){
        Select select = new Select(auctionstatus);
        select.selectByVisibleText("Inactive");
    }

    public void clickOnSearchbutton(){

        searchbutton.click();
    }

    public boolean isTableDataDisplayed(){

        return tabledata.isDisplayed();
    }

    public void selectLatestCreatedAuctionCheckBox(){
        int a = statuscheckbox.size();
        for(int i = 1; i<a; i++) {
            statuscheckbox.get(i).click();
        }

    }

    public void clickOnChangeAuctionStatusButton(){
        try {
            changeauctionstatusbutton.click();
            Thread.sleep(2000);
            scroll.alertClick();
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public boolean isSuccessMessageDisplayed(){

        return statussuccess.get(0).isDisplayed();
    }

    public void getAuctionId(){
        String id = statussuccess.get(0).getText().replaceAll("[^0-9]", "");
        ConfigManager.wirte_config1("AucId1", id);
        String id1 = statussuccess.get(1).getText().replaceAll("[^0-9]", "");
        ConfigManager.wirte_config2("AucId2", id1);
    }

}
