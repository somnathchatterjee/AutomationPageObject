package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AddVesselDetail extends TestBase {

    @FindBy(how = How.XPATH, using = "auctionnoticevessel")
    private WebElement auctionnoticevessel;

    @FindBy(how = How.XPATH, using = "listofauction")
    private List<WebElement> listofauction;

    @FindBy(how = How.XPATH, using = "vesselsubmit")
    private WebElement vesselsubmit;

    @FindBy(how = How.XPATH, using = "cargo")
    private WebElement cargo;

    @FindBy(how = How.XPATH, using = "quantity")
    private WebElement quantity;

    @FindBy(how = How.XPATH, using = "quantitytolerance")
    private WebElement quantitytolerance;

    @FindBy(how = How.XPATH, using = "fromdatetextbox")
    private WebElement fromdatetextbox;

    @FindBy(how = How.XPATH, using = "nextmonth")
    private WebElement nextmonth;

    @FindBy(how = How.XPATH, using = "prevmonth")
    private WebElement prevmonth;

    @FindBy(how = How.XPATH, using = "firstdate")
    private List<WebElement> firstdate;

    @FindBy(how = How.XPATH, using = "todatetextbox")
    private WebElement todatetextbox;

    @FindBy(how = How.XPATH, using = "loadport")
    private WebElement loadport;

    @FindBy(how = How.XPATH, using = "loadrate")
    private WebElement loadrate;

    @FindBy(how = How.XPATH, using = "dischargeport")
    private WebElement dischargeport;

    @FindBy(how = How.XPATH, using = "dischargerate")
    private WebElement dischargerate;

    @FindBy(how = How.XPATH, using = "paymentterm")
    private WebElement paymentterm;

    @FindBy(how = How.XPATH, using = "otherterm")
    private WebElement otherterm;

    @FindBy(how = How.XPATH, using = "finalsumbit")
    private WebElement finalsumbit;

    @FindBy(how = How.XPATH, using = "sccessvessel")
    private WebElement sccessvessel;

    public void selectLastAuctionFromList(){
        try {
            auctionnoticevessel.click();
            List<WebElement> list = listofauction;
            int a = list.size();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_END);
            Thread.sleep(1000);
            list.get(a-1).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnSubmitButton(){

        vesselsubmit.click();
    }

    public void enterCargoDetail(String car){
        cargo.clear();
        cargo.sendKeys(ConfigManager.getData(car));
    }

    public void enterQuantityDetails(String qt){
        quantity.click();
        quantity.sendKeys(ConfigManager.getData(qt));
    }

    public void enterQualityTolerace(String qulT){
        quantitytolerance.clear();
        quantitytolerance.sendKeys(ConfigManager.getData(qulT));
    }

    public void selectFromDate(){
        fromdatetextbox.click();
        nextmonth.click();
        firstdate.get(1).click();
    }

    public void selectToDate(){
        todatetextbox.click();
        nextmonth.click();
        nextmonth.click();
        firstdate.get(1).click();
    }

    public void enterLoadPortDetail(String lp){
        loadport.clear();
        loadport.sendKeys(ConfigManager.getData(lp));
    }

    public void enterLoadRateDetail(String lr){
        loadrate.clear();
        loadrate.sendKeys(ConfigManager.getData(lr));
    }

    public void enterDischargePortDetail(String dp){
        dischargeport.clear();
        dischargeport.sendKeys(ConfigManager.getData(dp));
    }

    public void enterDischargeRateDetail(String dr){
        dischargerate.clear();
        dischargerate.sendKeys(ConfigManager.getData(dr));
    }

    public void enterPaymentTermDetail(String payment){
        paymentterm.clear();
        paymentterm.sendKeys(ConfigManager.getData(payment));

    }

    public void enterOtherTermDetail(String ot){
        otherterm.clear();
        otherterm.sendKeys(ConfigManager.getData(ot));
    }

    public void clickOnFinalSubmitButton(){

        finalsumbit.click();
    }

    public boolean isVesselSuccessfullyAdded(){

       return sccessvessel.isDisplayed();
    }

}
