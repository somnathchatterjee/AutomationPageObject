package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminHome extends TestBase {

    @FindBy(how = How.XPATH, using = "auctionnotice")
    private WebElement Auctionnotice;

    @FindBy(how = How.XPATH, using = "noticeactivity")
    private WebElement Noticeactivity;

    @FindBy(how = How.XPATH, using = "addauctionnotice")
    private WebElement Addauctionnotice;

    @FindBy(how = How.XPATH, using = "auctionactivity")
    private WebElement Auctionactivity;

    @FindBy(how = How.XPATH, using = "auctionnoticeupload")
    private WebElement Auctionnoticeupload;

    @FindBy(how = How.XPATH, using = "staticnode")
    private WebElement Staticnode;

    @FindBy(how = How.XPATH, using = "createstaticnode")
    private WebElement Createstaticnode;

    @FindBy(how = How.XPATH, using = "addvesseldetails")
    private WebElement Addvesseldetails;

    @FindBy(how = How.XPATH, using = "confirmauctionnotice")
    private WebElement confirmauctionnotice;

    @FindBy(how = How.XPATH, using = "checkauctionnotice")
    private WebElement checkauctionnotice;

    @FindBy(how = How.XPATH, using = "auctions")
    private WebElement auctions;

    @FindBy(how = How.XPATH, using = "manage")
    private WebElement manage;

    @FindBy(how = How.XPATH, using = "changeauctionstatus")
    private WebElement changeauctionstatus;

    @FindBy(how = How.XPATH, using = "manageauctions")
    private WebElement manageauctions;

    @FindBy(how = How.XPATH, using = "closedauction")
    private WebElement closedauction;

    @FindBy(how = How.XPATH, using = "auctionreport")
    private WebElement auctionreport;

    @FindBy(how = How.XPATH, using = "auctionlte")
    private WebElement auctionlte;


    public void hoverOnAuctionNotice(){
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(Auctionnotice));
            Actions actions = new Actions(driver);
            actions.moveToElement(Auctionnotice).build().perform();
    }

    public void hoverOnNoticeActivity(){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(Noticeactivity).build().perform();
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isAddAuctionNoticedisplayed(){
        return Addauctionnotice.isDisplayed();
    }

    public void clickOnAddAuctionNotice(){
        if(isAddAuctionNoticedisplayed()){
            Addauctionnotice.click();
        }else {
            System.out.println("Add Auction Notice button is not displaying");
        }
    }

    public void hoverOnAuctionActivity(){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(Auctionactivity).build().perform();
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isAddAuctionNoticeUploaddisplayed(){
        return Auctionnoticeupload.isDisplayed();
    }

    public void clickOnUploadAuctionNotice(){

            Auctionnoticeupload.click();
    }

    public void hoverOnStaticNode(){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(Staticnode).build().perform();
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnCreateStaticNode(){

        Createstaticnode.click();
    }

    public void clickOnAddVesselDetail(){

        Addvesseldetails.click();
    }

    public void clickOnConfirmNotice(){

        confirmauctionnotice.click();
    }

    public void clickOnCheckAuctionNotice(){

        checkauctionnotice.click();
    }

    public void hoverOnAuctions(){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(auctions).build().perform();
            Thread.sleep(1000);
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public void hoverOnManage(){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(manage).build().perform();
            Thread.sleep(1000);
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public void clickOnChangeAuctionStatus(){

        changeauctionstatus.click();
    }

    public void clickOnClosedAuction(){
        hoverOnAuctions();
        hoverOnManage();
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(manageauctions).build().perform();
            Thread.sleep(1000);
            closedauction.click();
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public void hoverOnAuctionReport(){
        hoverOnAuctions();
        hoverOnManage();
        try {

            Actions act = new Actions(driver);
            act.moveToElement(auctionreport).build().perform();
            Thread.sleep(1000);
            auctionlte.click();
            Thread.sleep(2000);
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }
}
