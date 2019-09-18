package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BankAccountAdd extends TestBase {

    @FindBy(how = How.XPATH, using = "Bankbusinessunit")
    private WebElement Bankbusinessunit;

    @FindBy(how = How.XPATH,using = "Bankclienttype")
    private WebElement Bankclienttype;

    @FindBy(how = How.XPATH, using = "Bankclientname")
    private WebElement Bankclientname;

    @FindBy(how = How.XPATH, using = "Bankname")
    private WebElement Bankname;

    @FindBy(how = How.XPATH, using = "Bankcurrentaccno")
    private WebElement Bankcurrentaccno;

    @FindBy(how = How.XPATH, using = "Bankloanaccno")
    private WebElement Bankloanaccno;

    @FindBy(how = How.XPATH,using = "Bankifsc")
    private WebElement Bankifsc;

    @FindBy(how = How.XPATH, using = "Bankbranchname")
    private WebElement Bankbranchname;

    @FindBy(how = How.XPATH, using = "Bankbranchcode")
    private WebElement Bankbranchcode;

    @FindBy(how = How.XPATH, using = "Banksmerchantcode")
    private WebElement Banksmerchantcode;

    @FindBy(how = How.XPATH, using = "Bankcreditdays")
    private WebElement Bankcreditdays;

    @FindBy(how = How.XPATH, using = "Bankcreditlimit")
    private WebElement Bankcreditlimit;

    @FindBy(how = How.XPATH, using = "Bankintrestrate")
    private WebElement Bankintrestrate;

    public boolean isBusinessUnitDisplayed(){
        return Bankbusinessunit.isDisplayed();
    }

    public boolean isClientTypeDisplayed(){
        return Bankclienttype.isDisplayed();
    }

    public boolean isClientNameDisplayed(){
        return Bankclientname.isDisplayed();
    }

    public boolean isBankNameDisplayed(){
        return Bankname.isDisplayed();
    }

    public boolean isCurrentAccountNumberDisplayed(){
        return Bankcurrentaccno.isDisplayed();
    }

    public boolean isLoanAccountNumberDisplayed(){
        return Bankloanaccno.isDisplayed();
    }

    public boolean isIfscDisplayed(){
        return Bankifsc.isDisplayed();
    }

    public boolean isBranchNameDisplayed(){
        return Bankbranchname.isDisplayed();
    }

    public boolean isBranchCodeDisplayed(){
        return Bankbranchcode.isDisplayed();
    }

    public boolean isMerchanteCodeDisplayed(){
        return Banksmerchantcode.isDisplayed();
    }

    public boolean isCreditDaysDisplayed(){
        return Bankcreditdays.isDisplayed();
    }

    public boolean isCreditLimitDisplayed(){
        return Bankcreditlimit.isDisplayed();
    }

    public boolean isIntrestRateDisplayed(){
        return Bankintrestrate.isDisplayed();
    }

    public void selectBusinessUnit(String biss){
        Select bu = new Select(Bankbusinessunit);
        bu.selectByVisibleText(ConfigManager.getData(biss));
    }

    public void selectClientType(String ct){
        Select ctype = new Select(Bankclienttype);
        ctype.selectByVisibleText(ConfigManager.getData(ct));
    }

    public void selectClientName(String clientname){
        Select cn = new Select(Bankclientname);
        cn.selectByVisibleText(ConfigManager.getData(clientname));
    }

    public void selectBankName(String bankname){
        Select bn = new Select(Bankname);
        bn.selectByVisibleText(ConfigManager.getData(bankname));
    }



}
