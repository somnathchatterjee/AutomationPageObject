package com.pageObject.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UploadAuctionNotice {

    @FindBy(how = How.XPATH, using = "selectauctionnotice")
    private WebElement Selectauctionnotice;

    @FindBy(how = How.XPATH, using = "numberofstages")
    private WebElement numberofstages;

    @FindBy(how = How.XPATH, using = "auctionrule")
    private WebElement auctionrule;

    @FindBy(how = How.XPATH, using = "auctionsubrule")
    private WebElement auctionsubrule;

    @FindBy(how = How.XPATH, using = "starttime")
    private WebElement starttime;

    @FindBy(how = How.XPATH, using = "notclosebefore")
    private WebElement notclosebefore;

    @FindBy(how = How.XPATH, using = "displayestartbid")
    private WebElement displayestartbid;

    @FindBy(how = How.XPATH, using = "displayedecrement")
    private WebElement displayedecrement;

    @FindBy(how = How.XPATH, using = "note")
    private WebElement note;

    @FindBy(how = How.XPATH, using = "uploadauction")
    private WebElement uploadauction;

    @FindBy(how = How.XPATH, using = "uploadbutton")
    private WebElement uploadbutton;

    @FindBy(how = How.XPATH, using = "downloadexcelformat")
    private WebElement downloadexcelformat;

    public void clickToDownloadExcel(){
        downloadexcelformat.click();
    }

    public boolean isDownloadExcelDisplayed(){
       return downloadexcelformat.isDisplayed();
    }





}
