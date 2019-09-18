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

    public void seletUserOrganization(){
        Select userorg = new Select(Userorganization);
        userorg.selectByVisibleText(ConfigManager.getData("UserOrganization"));
    }

    public void seletUserBranch(){
        Select userbranch = new Select(Userbranch);
        userbranch.selectByVisibleText(ConfigManager.getData("UserBranch"));
    }

    public void seletUserType(){
        Select usertype = new Select(Usertype);
        usertype.selectByVisibleText(ConfigManager.getData("UserType"));
    }

    public void enterFirstName(){

        Firstname.sendKeys(ConfigManager.getData("FirstName"));
    }

    public void enterLastName(){

        Lastname.sendKeys(ConfigManager.getData("LastName"));
    }

    public void enterUserLoginId(){

        Userid.sendKeys(ConfigManager.getData("UserLogin"));
    }

    public boolean verifyTheAvaibilityOfUserId(){

        return Available.isDisplayed();
    }

    public boolean verifyTheNotAvailableOfUserId(){

        return Notavailable.isDisplayed();
    }

    public void selectCountry(){
        Select coun = new Select(Usercountry);
        coun.selectByVisibleText(ConfigManager.getData("UserCountry"));
    }

    public void selectState(){
        Select coun = new Select(Userstate);
        coun.selectByVisibleText(ConfigManager.getData("UserState"));
    }

    public void enterCity(){

        Usercity.sendKeys(ConfigManager.getData("UserCity"));
    }

    public void enterAddress(){

        Useraddress.sendKeys(ConfigManager.getData("UserAddress"));
    }

    public void enterPostalCode(){

        Userpostalcode.sendKeys(ConfigManager.getData("PostalCode"));
    }

    public void enterPrimaryEmail(){

        Userprimaryemail.sendKeys(ConfigManager.getData("PrimaryEmail"));
    }

    public void enterPrimaryMobile(){

        Userprimarymobile.sendKeys(ConfigManager.getData("PrimaryMobile"));
    }

    public void enterPanNo(){

        Userpan.sendKeys(ConfigManager.getData("PAN"));
    }

    public void enterPhone(){

        Userphone.sendKeys(ConfigManager.getData("Phonenumber"));
    }

    public void enterFax(){

        Userfax.sendKeys(ConfigManager.getData("FAX"));
    }

    public void enterSecondryEmail(){

        Usersecondryemail.sendKeys(ConfigManager.getData("SecondaryEmail"));
    }

    public void enterSecondryMobile(){

        Usersecondrymobile.sendKeys(ConfigManager.getData("SecondaryMobile"));
    }

    public void clickOnSubmitButton(){

        Usersubmitbutton.click();
    }
}
