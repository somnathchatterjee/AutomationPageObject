package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class UserAdd extends TestBase {

    @FindBy(how = How.XPATH, using = "userorganization")
    private WebElement Userorganization;

    @FindBy(how = How.XPATH, using = "userbranch")
    private WebElement Userbranch;

    @FindBy(how = How.XPATH, using = "usertype")
    private WebElement Usertype;

    @FindBy(how = How.XPATH, using = "firstname")
    private WebElement Firstname;

    @FindBy(how = How.XPATH, using = "lastname")
    private WebElement Lastname;

    @FindBy(how = How.XPATH, using = "userid")
    private WebElement Userid;

    @FindBy(how = How.XPATH, using = "usercountry")
    private WebElement Usercountry;

    @FindBy(how = How.XPATH, using = "userstate")
    private WebElement Userstate;

    @FindBy(how = How.XPATH, using = "usercity")
    private WebElement Usercity;

    @FindBy(how = How.XPATH, using = "useraddress")
    private WebElement Useraddress;

    @FindBy(how = How.XPATH, using = "userpostalcode")
    private WebElement Userpostalcode;

    @FindBy(how = How.XPATH, using = "userpan")
    private WebElement Userpan;

    @FindBy(how = How.XPATH, using = "userphone")
    private WebElement Userphone;

    @FindBy(how = How.XPATH, using = "userfax")
    private WebElement Userfax;

    @FindBy(how = How.XPATH, using = "userprimaryemail")
    private WebElement Userprimaryemail;

    @FindBy(how = How.XPATH, using = "usersecondryemail")
    private WebElement Usersecondryemail;

    @FindBy(how = How.XPATH, using = "userprimarymobile")
    private WebElement Userprimarymobile;

    @FindBy(how = How.XPATH, using = "usersecondrymobile")
    private WebElement Usersecondrymobile;

    @FindBy(how = How.XPATH, using = "available")
    private WebElement Available;

    @FindBy(how = How.XPATH, using = "notavailable")
    private WebElement Notavailable;

    @FindBy(how = How.XPATH, using = "usersubmitbutton")
    private WebElement Usersubmitbutton;

    public void seletUserOrganization(String organization){
        Select userorg = new Select(Userorganization);
        userorg.selectByVisibleText(ConfigManager.getData(organization));
    }

    public void seletUserBranch(String branch){
        Select userbranch = new Select(Userbranch);
        userbranch.selectByVisibleText(ConfigManager.getData(branch));
    }

    public void seletUserType(String userType){
        Select usertype = new Select(Usertype);
        usertype.selectByVisibleText(ConfigManager.getData(userType));
    }

    public void enterFirstName(String firstname){

        Firstname.sendKeys(ConfigManager.getData(firstname));
    }

    public void enterLastName(String lastname){

        Lastname.sendKeys(ConfigManager.getData(lastname));
    }

    public void enterUserLoginId(String userid){

        Userid.sendKeys(ConfigManager.getData(userid));
    }

    public boolean verifyTheAvaibilityOfUserId(){

        return Available.isDisplayed();
    }

    public boolean verifyTheNotAvailableOfUserId(){

        return Notavailable.isDisplayed();
    }

    public void selectCountry(String country){
        Select coun = new Select(Usercountry);
        coun.selectByVisibleText(ConfigManager.getData(country));
    }

    public void selectState(String state){
        Select coun = new Select(Userstate);
        coun.selectByVisibleText(ConfigManager.getData(state));
    }

    public void enterCity(String city){

        Usercity.sendKeys(ConfigManager.getData(city));
    }

    public void enterAddress(String address){

        Useraddress.sendKeys(ConfigManager.getData(address));
    }

    public void enterPostalCode(String pin){

        Userpostalcode.sendKeys(ConfigManager.getData(pin));
    }

    public void enterPrimaryEmail(String pemail){

        Userprimaryemail.sendKeys(ConfigManager.getData(pemail));
    }

    public void enterPrimaryMobile(String pmobile){

        Userprimarymobile.sendKeys(ConfigManager.getData(pmobile));
    }

    public void enterPanNo(String pan){

        Userpan.sendKeys(ConfigManager.getData(pan));
    }

    public void enterPhone(String phone){

        Userphone.sendKeys(ConfigManager.getData(phone));
    }

    public void enterFax(String fax){

        Userfax.sendKeys(ConfigManager.getData(fax));
    }

    public void enterSecondryEmail(String semail){

        Usersecondryemail.sendKeys(ConfigManager.getData(semail));
    }

    public void enterSecondryMobile(String smobile){

        Usersecondrymobile.sendKeys(ConfigManager.getData(smobile));
    }

    public void clickOnSubmitButton(){

        Usersubmitbutton.click();
    }
}
