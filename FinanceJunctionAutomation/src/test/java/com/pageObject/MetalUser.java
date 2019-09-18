package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.List;

public class MetalUser extends TestBase {

    private static String parent;

    @FindBy(how = How.XPATH, using = "metalloginname")
    private WebElement metalloginname;

    @FindBy(how = How.XPATH, using = "metalpassword")
    private WebElement metalpassword;

    @FindBy(how = How.XPATH, using = "metalloginbutton")
    private WebElement metalloginbutton;

    @FindBy(how = How.XPATH, using = "metalloginradiobutton")
    private WebElement metalloginradiobutton;

    @FindBy(how = How.XPATH, using = "metalacceptbutton")
    private WebElement metalacceptbutton;

    @FindBy(how = How.XPATH, using = "metalgeneralbutton")
    private WebElement metalgeneralbutton;

    @FindBy(how = How.XPATH, using = "metalfinancejunction")
    private WebElement metalfinancejunction;

    @FindBy(how = How.XPATH, using = "metalfinancerequest")
    private WebElement metalfinancerequest;

    @FindBy(how = How.XPATH, using = "metaladdrequest")
    private WebElement metaladdrequest;

    @FindBy(how = How.XPATH, using = "metalclientorg")
    private WebElement metalclientorg;

    @FindBy(how = How.XPATH, using = "metaldatapoint")
    private WebElement metaldatapoint;

    @FindBy(how = How.XPATH, using = "metaldatapointnumber")
    private WebElement metaldatapointnumber;

    @FindBy(how = How.XPATH, using = "metaltotalamount")
    private WebElement metaltotalamount;

    @FindBy(how = How.XPATH, using = "metalremainingamt")
    private WebElement metalremainingamt;

    @FindBy(how = How.XPATH, using = "metalbankaccount")
    private WebElement metalbankaccount;

    @FindBy(how = How.XPATH, using = "metalcredittenure")
    private WebElement metalcredittenure;

    @FindBy(how = How.XPATH, using = "metalfinancerequestamt")
    private WebElement metalfinancerequestamt;

    @FindBy(how = How.XPATH, using = "metalrequestsubmit")
    private WebElement metalrequestsubmit;

    @FindBy(how = How.XPATH, using = "metallogoutone")
    private WebElement metallogoutone;

    @FindBy(how = How.XPATH, using = "transanctionhistory")
    private WebElement transanctionhistory;

    @FindBy(how = How.XPATH, using = "nooftransactiondata")
    private List<WebElement> nooftransactiondata;

    @FindBy(how = How.XPATH, using = "historyclose")
    private WebElement historyclose;

    @FindBy(how = How.XPATH, using = "metalfinreqview")
    private WebElement metalfinreqview;

    @FindBy(how = How.XPATH, using = "metalfromdate")
    private WebElement metalfromdate;

    @FindBy(how = How.XPATH, using = "metaltodate")
    private WebElement metaltodate;

    @FindBy(how = How.XPATH, using = "metalprevmonth")
    private WebElement metalprevmonth;

    @FindBy(how = How.XPATH, using = "metalnextmonth")
    private WebElement metalnextmonth;

    @FindBy(how = How.XPATH, using = "metalmonthfirstday")
    private WebElement metalmonthfirstday;

    @FindBy(how = How.XPATH, using = "metaltodaydate")
    private WebElement metaltodaydate;

    @FindBy(how = How.XPATH, using = "metalsubmit")
    private WebElement metalsubmit;

    @FindBy(how = How.XPATH, using = "details")
    private List<WebElement> details;


    public boolean isUserNameFieldDisplayed(){

        return metalloginname.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed(){

        return metalpassword.isDisplayed();
    }

    public boolean isLoginButtonDisplayed(){

        return metalloginbutton.isDisplayed();
    }

    public void metalLogin(String uname, String pass){
        try{
            Thread.sleep(1000);
            metalloginname.clear();
            metalloginname.sendKeys(ConfigManager.getData(uname));
            metalpassword.sendKeys(ConfigManager.getData(pass));
            Thread.sleep(2000);
            metalloginbutton.click();
            Thread.sleep(10000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void clickRadioButton(){

        metalloginradiobutton.click();
    }

    public boolean isRadioButtondisplayed(){
        try {
            return metalloginradiobutton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickAcceptButton(){

        metalacceptbutton.click();
    }

    public void navigateToMetal(){

        try {
            parent = driver.getWindowHandle();
            System.out.println("");
            System.out.println(parent);
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            Thread.sleep(2000);
            Set<String> allwindows = driver.getWindowHandles();
            Thread.sleep(1500);
            for(String child : allwindows){
                System.out.println(child);
                if(!parent.contentEquals(child)){
                    driver.switchTo().window(child);
                    Thread.sleep(2000);
                    driver.navigate().to(ConfigManager.getData("metalurl"));
                    Thread.sleep(2000);
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isFinanceButtonDisplayed(){

        return metalfinancejunction.isDisplayed();
    }

    public void navigateToFinanceModule(){
        try {
            Thread.sleep(1000);
            metalgeneralbutton.click();
            Thread.sleep(1000);
            boolean fbutton = isFinanceButtonDisplayed();
            Assert.assertTrue(fbutton,"The finance button is not displayed");
            metalfinancejunction.click();
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public String getTitleOfPage(){

        return driver.getTitle();
    }
    public void navigateToAddFinanceRequest(){
        try {
            Thread.sleep(1000);
            metalfinancerequest.click();
            Thread.sleep(1000);
            metaladdrequest.click();
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }

    public void selectOrganization(){
        Select sel = new Select(metalclientorg);
        sel.selectByVisibleText(ConfigManager.getData("clientorg"));
    }

    public void selectDataPoint(){
        Select sel = new Select(metaldatapoint);
        sel.selectByVisibleText(ConfigManager.getData("datapoint"));
    }

    public void selectSoNumber(){
        Select select = new Select(metaldatapointnumber);
        select.selectByValue(ConfigManager.getData("sonumber"));
    }

    public void selectBankAccount(){
        Select bank = new Select(metalbankaccount);
        bank.selectByVisibleText(ConfigManager.getData("bankaccount"));
    }

    public void enterCreditTenure(){
        metalcredittenure.clear();
        metalcredittenure.sendKeys(ConfigManager.getData("credittenure"));
    }

    public void enterFinanceAmount(){
        metalfinancerequestamt.clear();
        metalfinancerequestamt.sendKeys(ConfigManager.getData("financeamt"));
    }

    public void enterFinanceAmount2(){

        int remain = getRemainamt();
        int increase = remain+100;
        String value = Integer.toString(increase);
        metalfinancerequestamt.clear();
        metalfinancerequestamt.sendKeys(value);
        String actual = driver.switchTo().alert().getText();
        String expected = "Finance amount greater than remaining amount.";
        Assert.assertEquals(actual,expected,"The value is not equal");
        driver.switchTo().alert().accept();
    }

    public int getTotalamt(){
        String tamt = metaltotalamount.getAttribute("value");
        int amt = Integer.parseInt(tamt);
        return amt;
    }

    public int getRemainamt(){
        String ramt = metalremainingamt.getAttribute("value");
        System.out.println(ramt);
        int rmamt = Integer.parseInt(ramt);
        System.out.println(rmamt);
        return rmamt;
    }

    public void clickOnSubmitButton(){
        metalrequestsubmit.click();
        driver.switchTo().alert().accept();
    }


    public void backToMainWindow(){
        driver.close();
        driver.switchTo().window(parent);
    }

    public boolean isHistoryLinkDisplayed(){

       return transanctionhistory.isDisplayed();
    }

    public void clickOnHistoryLink(){

        transanctionhistory.click();
    }

    public int sizeOfDataInTable(){

        return nooftransactiondata.size();
    }

    public void closeHistory(){

        historyclose.click();
    }

    public void navigateToRequestView(){
        try {
            Thread.sleep(1000);
            metalfinancerequest.click();
            Thread.sleep(1000);
            metalfinreqview.click();
        }catch (Exception e){
            Log.info(e.getMessage());
        }
    }
    public void selectFromDate(){
        try {
            metalfromdate.click();
            Thread.sleep(1000);
            metalprevmonth.click();
            Thread.sleep(1000);
            metalmonthfirstday.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectToDate(){
        try {
            metaltodate.click();
            Thread.sleep(1000);
            metaltodaydate.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnSubmitButtonToView(){

        metalsubmit.click();
    }

    public String statusOfTheRequest(){
        int a = details.size();
        return details.get(a-1).getText();
    }

}
