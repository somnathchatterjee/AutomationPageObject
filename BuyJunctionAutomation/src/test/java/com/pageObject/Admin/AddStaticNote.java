package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class AddStaticNote extends TestBase {

    @FindBy(how = How.XPATH, using = "selectuploadedauctionnotice")
    private WebElement Selectuploadedauctionnotice;

    @FindBy(how = How.XPATH, using = "singlecurrency")
    private WebElement Singlecurrency;

    @FindBy(how = How.XPATH, using = "currency")
    private WebElement Currency;

    @FindBy(how = How.XPATH, using = "searchbidder")
    private WebElement Searchbidder;

    @FindBy(how = How.XPATH, using = "usercode")
    private WebElement Usercode;

    @FindBy(how = How.XPATH, using = "searchbidder")
    private WebElement searchbidder;

    @FindBy(how = How.XPATH, using = "enter")
    private WebElement Enter;

    @FindBy(how = How.XPATH, using = "marketname")
    private List<WebElement> Marketname;

    @FindBy(how = How.XPATH, using = "checkboxfirst")
    private List<WebElement> Checkboxfirst;

    @FindBy(how = How.XPATH, using = "submitbidder")
    private WebElement Submitbidder;

    @FindBy(how = How.XPATH, using = "successmsg")
    private WebElement Successmsg;



    public void selectUploadedAuctionNotice(){
        try {
            Select up = new Select(Selectuploadedauctionnotice);
            up.selectByIndex(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectSingleCurrency(){

        Singlecurrency.click();
    }

    public void selectCurrency(){
        Select curr = new Select(Currency);
        curr.selectByValue("171");
    }

    public void selectBidderSearchMode(){

        Searchbidder.click();
    }

    public void enterUserCode(String code){
        Usercode.clear();
        Usercode.sendKeys(ConfigManager.getData(code));
    }

    public void clickOnEnterButton(){

        Enter.click();
    }

    public void enterMarketName(String mkt){
        Marketname.clear();
        Marketname.get(0).sendKeys(mkt);

    }

    public void selectTheFirstCheckbox(){

        Checkboxfirst.get(0).click();
    }

    public void clickOnSubmitButton(){

        Submitbidder.click();
    }

}
