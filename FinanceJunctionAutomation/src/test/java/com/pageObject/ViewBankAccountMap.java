package com.pageObject;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ViewBankAccountMap extends TestBase {

    @FindBy(how = How.XPATH, using = "bank.map.view.buniessunit")
    private WebElement Mapviewbuniessunit;

    @FindBy(how = How.XPATH, using = "bank.map.view.fromdate")
    private WebElement Mapviewfromdate;

    @FindBy(how = How.XPATH, using = "bank.map.view.todate")
    private WebElement Mapviewtodate;

    @FindBy(how = How.XPATH, using = "bank.map.view.prevmonth")
    private WebElement Mapviewprevmonth;

    @FindBy(how = How.XPATH, using = "bank.map.view.nextmonth")
    private WebElement Mapviewnextmonth;

    @FindBy(how = How.XPATH, using = "bank.map.view.monthfirstday")
    private WebElement Mapviewmonthfirstday;

    @FindBy(how = How.XPATH, using = "bank.map.view.todaydate")
    private WebElement Mapviewtodaydate;

    @FindBy(how = How.XPATH, using = "bank.map.view.buyerorganization")
    private WebElement Mapviewbuyerorganization;

    @FindBy(how = How.XPATH, using = "bank.map.view.supplierorganization")
    private WebElement Mapviewsupplierorganization;

    @FindBy(how = How.XPATH, using = "bank.map.view.submitbutton")
    private WebElement Mapviewsubmitbutton;

    @FindBy(how = How.XPATH, using = "bank.map.view.modifybutton")
    private List<WebElement> Bankmapviewmodifybutton;

    @FindBy(how = How.XPATH, using = "bank.map.view.commissiontext")
    private WebElement Bankmapviewcommissiontext;

    @FindBy(how = How.XPATH, using = "bank.map.view.close")
    private WebElement Bankmapviewclose;

    @FindBy(how = How.XPATH, using = "bank.map.view.save")
    private WebElement Bankmapviewsave;

    public boolean isMapviewBuniessUnitDisplay(){

        return Mapviewbuniessunit.isDisplayed();
    }

    public boolean isMapviewfromdateDisplay(){

        return Mapviewfromdate.isDisplayed();
    }

    public boolean isMapviewtodateDisplay(){

        return Mapviewtodate.isDisplayed();
    }

    public boolean isMapviewbuyerorganizationDisplay(){

        return Mapviewbuyerorganization.isDisplayed();
    }

    public boolean isMapviewsupplierorganizationDisplay(){

        return Mapviewsupplierorganization.isDisplayed();
    }

    public boolean isMapviewsubmitbuttonDisplay(){

        return Mapviewsubmitbutton.isDisplayed();
    }

    public void clickOnSubmitButton(){

        Mapviewsubmitbutton.click();
    }

    public void clickOnModifyButton(){
        List<WebElement> totalmodifybutton = Bankmapviewmodifybutton;
        int i = totalmodifybutton.size();
        totalmodifybutton.get(i-1).click();
    }

    public String checkTheCommissionValue(){

        return Bankmapviewcommissiontext.getText();
    }

    
}
