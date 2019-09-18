package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.DateAndTime;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;
import java.util.Set;

public class AuctionUpload extends TestBase {

    @FindBy(how = How.XPATH, using = "select.auction.notice")
    private WebElement Auctionnotice;

    @FindBy(how = How.XPATH, using = "select.stage")
    private WebElement Selectstage;

    @FindBy(how = How.XPATH, using = "select.auction.rule")
    private WebElement Selectauctionrule;

    @FindBy(how = How.XPATH, using = "select.auction.sub.rule")
    private WebElement Selectauctionsubrule;

    @FindBy(how = How.XPATH, using = "select.start.time1")
    private WebElement Selectstarttime;

    @FindBy(how = How.XPATH, using = "not.close.before")
    private WebElement Notclosebefore;

    @FindBy(how = How.XPATH, using = "display.start.bid")
    private WebElement Displaystartbid;

    @FindBy(how = How.XPATH, using = "display.decrement")
    private WebElement Displaydecrement;

    @FindBy(how = How.XPATH, using = "note.data")
    private WebElement Notedata;

    @FindBy(how = How.XPATH, using = "auction.file.upload")
    private WebElement Auctionfileupload;

    @FindBy(how = How.XPATH, using = "auction.upload.button")
    private WebElement Auctionuploadbutton;

    @FindBy(how = How.XPATH, using = "starttimeimg")
    private WebElement Starttimeimg;

    @FindBy(how = How.XPATH, using = "currentdate")
    private WebElement Currentdate;

    @FindBy(how = How.XPATH, using = "enterhrs")
    private WebElement Enterhrs;

    @FindBy(how = How.XPATH, using = "entermin")
    private WebElement Entermin;

    @FindBy(how = How.XPATH, using = "successfulUploadAuctionText")
    private WebElement SuccessfulUploadAuctionText;


    public void selectAuctionNotice(){
        Select aucnotice = new Select(Auctionnotice);
        aucnotice.selectByIndex(2);
    }

    public void selectStage(int a){
        Select stage = new Select(Selectstage);
        stage.selectByIndex(a);
    }

    public void selectAuctionRule(String rules){
        Select rule = new Select(Selectauctionrule);
        rule.selectByVisibleText(ConfigManager.getData(rules));
    }

    public void selectAuctionSubRule(String subrules){
        Select subrule = new Select(Selectauctionsubrule);
        subrule.selectByVisibleText(ConfigManager.getData(subrules));
    }

    public void enterStartTime(){
        String min;
        String parent = driver.getWindowHandle();
        Starttimeimg.click();
        Set<String> allwindows = driver.getWindowHandles();
        for (String child : allwindows){
            if(!parent.contentEquals(child)){
                driver.switchTo().window(child);
                Calendar rightNow = Calendar.getInstance();
                String hour = Integer.toString(rightNow.get(Calendar.HOUR_OF_DAY));
                int mins = rightNow.get(Calendar.MINUTE)+5;
                System.out.println(mins);
                if(mins>=60){
                    int a= mins - 59;
                    System.out.println(a);
                    min = Integer.toString(rightNow.get(Calendar.MINUTE)+a-1);
                    System.out.println(min);
                }else {
                    min = Integer.toString(mins);
                }
                Enterhrs.clear();
                Enterhrs.sendKeys(hour);
                Entermin.clear();
                Entermin.sendKeys(min);
                Currentdate.click();
            }

        }
        driver.switchTo().window(parent);

    }

    public void enterNotCloseBefore(){
        Notclosebefore.clear();
        Notclosebefore.sendKeys("10");
    }

    public void selectDisplayStartBid(){
        Select startbid = new Select(Displaystartbid);
        startbid.selectByVisibleText("Yes");
    }

    public void selectDisplayDecrement(){
        Select dece = new Select(Displaydecrement);
        dece.selectByVisibleText("Yes");
    }

    public void clickToUploadExcelButton(){

        Auctionfileupload.click();
    }

    public void clickToUploadAuction(){

        Auctionuploadbutton.click();
    }

    public boolean issuccessfulUploadAuctionTextDisplayed(){

        return SuccessfulUploadAuctionText.isDisplayed();
    }


}
