package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

public class EpsUser extends TestBase {

    public static String parent;

    @FindBy(how = How.XPATH, using = "epsloginbutton")
    private WebElement Epsloginbutton;

    @FindBy(how = How.XPATH, using = "epsusername")
    private WebElement Epsusername;

    @FindBy(how = How.XPATH, using = "epspassword")
    private WebElement Epspassword;

    @FindBy(how = How.XPATH, using = "epssigninbtn")
    private WebElement Epssigninbtn;

    @FindBy(how = How.XPATH, using = "epsselectorg")
    private WebElement Epsselectorg;

    @FindBy(how = How.XPATH, using = "epsokbutton")
    private WebElement Epsokbutton;

    @FindBy(how = How.XPATH, using = "epsdashboard")
    private WebElement Epsdashboard;

    @FindBy(how = How.XPATH, using = "epsavailfinance")
    private WebElement Epsavailfinance;

    @FindBy(how = How.XPATH, using = "epsfinancerequest")
    private WebElement Epsfinancerequest;

    @FindBy(how = How.XPATH, using = "epsfinanceadd")
    private WebElement Epsfinanceadd;

    @FindBy(how = How.XPATH, using = "epsclientorg")
    private WebElement Epsclientorg;

    @FindBy(how = How.XPATH, using = "epsdatapoint")
    private WebElement Epsdatapoint;

    @FindBy(how = How.XPATH, using = "epsdatapointnumber")
    private WebElement Epsdatapointnumber;

    @FindBy(how = How.XPATH, using = "epstotalamount")
    private WebElement Epstotalamount;

    @FindBy(how = How.XPATH, using = "epsremainingamt")
    private WebElement Epsremainingamt;

    @FindBy(how = How.XPATH, using = "epsbankaccount")
    private WebElement Epsbankaccount;

    @FindBy(how = How.XPATH, using = "epscredittenure")
    private WebElement Epscredittenure;

    @FindBy(how = How.XPATH, using = "epsfinancerequestamt")
    private WebElement Epsfinancerequestamt;

    @FindBy(how = How.XPATH, using = "epsrequestsubmit")
    private WebElement Epsrequestsubmit;

    @FindBy(how = How.XPATH, using = "epslogoutone")
    private WebElement Epslogoutone;

    @FindBy(how = How.XPATH, using = "epslogout")
    private WebElement Epslogout;

    @FindBy(how = How.XPATH, using = "epslogoutpopup")
    private WebElement Epslogoutpopup;

    @FindBy(how = How.XPATH, using = "epshoverdashboard")
    private WebElement Epshoverdashboard;

    public void epsLogin(String uname, String pass){
        try{
        Epsloginbutton.click();
        Thread.sleep(2000);
        Epsusername.clear();
        Epsusername.sendKeys(ConfigManager.getData(uname));
        Epspassword.sendKeys(ConfigManager.getData(pass));
        Thread.sleep(2000);
        Epssigninbtn.click();
        Thread.sleep(10000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void epsSelectorganization(String org){
        Select epsdd = new Select(Epsselectorg);
        epsdd.selectByVisibleText(ConfigManager.getData(org));
    }

    public void clickOnOk(){
        try {
            Thread.sleep(2000);
            Epsokbutton.click();
            Thread.sleep(10000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void workOnDashboard(){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(Epshoverdashboard).perform();
            Epsdashboard.click();
            Thread.sleep(15000);
            Epsavailfinance.click();
            Thread.sleep(25000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addFinanceReqest(){
        Epsfinancerequest.click();
        Epsfinanceadd.click();
    }
    public void selectClientOrg(String orga){
        Select clientorg = new Select(Epsclientorg);
        clientorg.selectByVisibleText(ConfigManager.getData(orga));
    }

    public void selectClientDataPoint(String datapoint){
        Select datapointdd = new Select(Epsdatapoint);
        datapointdd.selectByVisibleText(ConfigManager.getData(datapoint));
    }

    public void selectDataPointno(String datano){
        Select datapno = new Select(Epsdatapointnumber);
        datapno.selectByVisibleText(ConfigManager.getData(datano));

    }

    public void selectBankAccount(String bankacc){
        Select bankdd = new Select(Epsbankaccount);
        bankdd.selectByValue(ConfigManager.getData(bankacc));
    }

    public void enterCreditTenure(){

        Epscredittenure.sendKeys("45");
    }

    public void enterFinanceAmount(){

        Epsfinancerequestamt.sendKeys("1000");
        String reqamt = Epsfinancerequestamt.getText();
    }

    public void clickUserSubmit(){

        Epsrequestsubmit.click();
    }

    public void navigateToEps(){

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
                    driver.navigate().to("http://epsnewprod.mjunction.in:8080/EPSV2Web/");
                    Thread.sleep(2000);
                }
                else {
                    System.out.println("No windows found");
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public int getTotalamt(){
        String tamt = Epstotalamount.getText();
        int amt = Integer.parseInt(tamt);
        return amt;
    }

    public int getRemainamt(){
        String ramt = Epsremainingamt.getText();
        int rmamt = Integer.parseInt(ramt);
        return rmamt;
    }

    public void backTomainWindow(){
        driver.close();
        driver.switchTo().window(parent);
    }

    public void selectAlert(){
        driver.switchTo().alert().accept();
    }

}
