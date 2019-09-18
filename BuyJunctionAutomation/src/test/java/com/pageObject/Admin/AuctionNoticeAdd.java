package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.DateAndTime;
import com.qa.utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class AuctionNoticeAdd extends TestBase {

    @FindBy(how = How.XPATH, using = "addauctionnoticepage")
    private WebElement Addauctionnoticepage;

    @FindBy(how = How.XPATH, using = "procurementarea1")
    private WebElement Procurementarea;

    @FindBy(how = How.XPATH, using = "productcategory")
    private WebElement Productcategory;

    @FindBy(how = How.XPATH, using = "productsubcategory")
    private WebElement Productsubcategory;

    @FindBy(how = How.XPATH, using = "rfqname")
    private WebElement Rfqname;

    @FindBy(how = How.XPATH, using = "client")
    private WebElement Client;

    @FindBy(how = How.XPATH, using = "noticedate")
    private WebElement Noticedate;

    @FindBy(how = How.XPATH, using = "eventdate")
    private WebElement Eventdate;

    @FindBy(how = How.XPATH, using = "biddingbasic")
    private WebElement Biddingbasic;

    @FindBy(how = How.XPATH, using = "specialinsturaction")
    private WebElement Specialinsturaction;

    @FindBy(how = How.XPATH, using = "pricevalidity")
    private WebElement Pricevalidity;

    @FindBy(how = How.XPATH, using = "pricebreakup")
    private WebElement Pricebreakup;

    @FindBy(how = How.XPATH, using = "procurement")
    private WebElement Procurement;

    @FindBy(how = How.XPATH, using = "timeext")
    private WebElement Timeext;

    @FindBy(how = How.XPATH, using = "numberofstage")
    private WebElement Numberofstage;

    @FindBy(how = How.XPATH, using = "purcharsername")
    private WebElement Purcharsername;

    @FindBy(how = How.XPATH, using = "purcharserdegi")
    private WebElement Purcharserdegi;

    @FindBy(how = How.XPATH, using = "purcharseraddress")
    private WebElement Purcharseraddress;

    @FindBy(how = How.XPATH, using = "purcharserfax")
    private WebElement Purcharserfax;

    @FindBy(how = How.XPATH, using = "purcharsermobile")
    private WebElement Purcharsermobile;

    @FindBy(how = How.XPATH, using = "purcharseremail")
    private WebElement Purcharseremail;

    @FindBy(how = How.XPATH, using = "addauctionsubmit")
    private WebElement Addauctionsubmit;

    @FindBy(how = How.XPATH, using = "successCreation")
    private WebElement SuccessCreation;


    public static String d;
    public static String da;

    public boolean isAddAuctionNoticePageDisplayed(){

        return Addauctionnoticepage.isDisplayed();
    }

    public boolean isProcurementAreaDisplayed(){

       return Procurementarea.isDisplayed();
    }

    public void selectProcurementArea(String pa){
        System.out.println(Procurementarea);

        Select procarea = new Select(Procurementarea);
        System.out.println(procarea);
        procarea.selectByVisibleText(ConfigManager.getData(pa));
    }

    public void selectProductCategory(String pc){

        Select prodcat = new Select(Productcategory);
        prodcat.selectByVisibleText(ConfigManager.getData(pc));
    }

    public void selectProductSubCategory(String pc){

        Select prodcat1 = new Select(Productsubcategory);
        prodcat1.selectByVisibleText(ConfigManager.getData(pc));
    }

    public void enterRfqName(String name){
        Rfqname.clear();
        Rfqname.sendKeys(ConfigManager.getData(name));
    }

    public void selectClient(String cl){
        Select client = new Select(Client);
        client.selectByValue(ConfigManager.getData(cl));
    }

    public void enterNoticeDate(){
        d = DateAndTime.dateonly();
        Noticedate.clear();
        Noticedate.sendKeys(d);
    }

    public void enterEventDateAndTime(){
        da = DateAndTime.dateAndTime(10);
        Eventdate.sendKeys(da);
    }

    public void enterBiddingBasic(String basic){
        Biddingbasic.clear();
        Biddingbasic.sendKeys(ConfigManager.getData(basic));
    }

    public void enterSpecialInstruction(String spinst){
        Specialinsturaction.clear();
        Specialinsturaction.sendKeys(ConfigManager.getData(spinst));
    }

    public void enterPriceValidity(String price){
        Pricevalidity.clear();
        Pricevalidity.sendKeys(ConfigManager.getData(price));
    }

    public void enterPriceBreakUp(String breakup){
        Pricebreakup.clear();
        Pricebreakup.sendKeys(ConfigManager.getData(breakup));
    }

    public void enterProcurementDetails(String detail){
        Procurement.clear();
        Procurement.sendKeys(ConfigManager.getData(detail));
    }

    public void enterTimeExt(String time){
        Timeext.clear();
        Timeext.sendKeys(ConfigManager.getData(time));
    }

    public void enterNoOfStages(String stage){
        Numberofstage.clear();
        Numberofstage.sendKeys(ConfigManager.getData(stage));
    }

    public void enterPurchaserName(String pname){
        Purcharsername.clear();
        Purcharsername.sendKeys(ConfigManager.getData(pname));
    }

    public void enterPurchaserDesignation(String deg){
        Purcharserdegi.clear();
        Purcharserdegi.sendKeys(ConfigManager.getData(deg));
    }

    public void enterPurchaserAddress(String add){
        Purcharseraddress.clear();
        Purcharseraddress.sendKeys(ConfigManager.getData(add));
    }

    public void enterPurchaserFax(String fax){
        Purcharserfax.clear();
        Purcharserfax.sendKeys(ConfigManager.getData(fax));
    }

    public void enterPurchaserMobile(String mobile){
        Purcharsermobile.clear();
        Purcharsermobile.sendKeys(ConfigManager.getData(mobile));
    }

    public void enterPurchaserEmail(String email){
        Purcharseremail.clear();
        Purcharseremail.sendKeys(ConfigManager.getData(email));
    }

    public void clickOnSubmitButton(){

        Addauctionsubmit.click();
    }

    public boolean isAuctionCreatedSuccessfully(){
        String create = SuccessCreation.getText();
        Log.info(create);
        return SuccessCreation.isDisplayed();
    }
}
