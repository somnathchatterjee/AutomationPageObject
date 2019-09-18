package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OrganizationAdd extends TestBase {

    @FindBy(how = How.XPATH, using = "Business_Unit")
    private WebElement BusinessUnitDropDown;

    @FindBy(how = How.XPATH, using = "Organization_Type")
    private WebElement OrganizationTypeDropDown;

    @FindBy(how = How.XPATH, using = "Organization_Name")
    private WebElement OrganizationName;

    @FindBy(how = How.XPATH, using = "Country_org")
    private WebElement OrganizationCountry;

    @FindBy(how = How.XPATH, using = "State_org")
    private WebElement OrganizationState;

    @FindBy(how = How.XPATH, using = "City_org")
    private WebElement OrganizationCity;

    @FindBy(how = How.XPATH, using = "Address_org")
    private WebElement OrganizationAddress;

    @FindBy(how = How.XPATH, using = "Email_org")
    private WebElement OrganizationEmail;

    @FindBy(how = How.XPATH, using = "Pan_org")
    private WebElement OrganizationPan;

    @FindBy(how = How.XPATH, using = "Gstin_org")
    private WebElement OrganizationGstin;

    @FindBy(how = How.XPATH, using = "Cin_org")
    private WebElement OrganizationCin;

    @FindBy(how = How.XPATH, using = "Org_Submit")
    private WebElement OrganizationSubmitButton;



    public boolean businessUnitDisplayed(){
        return BusinessUnitDropDown.isDisplayed();
    }

    public boolean OrganizationTypeDisplayed(){
        return OrganizationTypeDropDown.isDisplayed();
    }

    public void selectBusinessUnit(String bu){
        Select budd = new Select(BusinessUnitDropDown);
        budd.selectByVisibleText(ConfigManager.getData(bu));
    }

    public void selectOrganizationType(String ot){
        Select otdd = new Select(OrganizationTypeDropDown);
        otdd.selectByVisibleText(ConfigManager.getData(ot));
    }

    public void enterOrganizationName(String on){
        OrganizationName.sendKeys(ConfigManager.getData(on));
    }

    public void selectCountry(String country){
        Select countrydd = new Select(OrganizationCountry);
        countrydd.selectByVisibleText(ConfigManager.getData(country));
    }

    public void selectState(String state){
        Select statedd = new Select(OrganizationState);
        statedd.selectByVisibleText(ConfigManager.getData(state));
    }

   public void enterCity(String city){
        OrganizationCity.sendKeys(ConfigManager.getData(city));
   }

   public void enterAddress(String address){
        OrganizationAddress.sendKeys(ConfigManager.getData(address));
   }

   public void enterEmail(String email){
        OrganizationEmail.sendKeys(ConfigManager.getData(email));
   }

   public void enterPan(String pan){
        OrganizationPan.sendKeys(ConfigManager.getData(pan));
   }

   public void enterGstin(String gstin){
        OrganizationGstin.sendKeys(ConfigManager.getData(gstin));
   }

   public void enterCin(String cin){
        OrganizationCin.sendKeys(ConfigManager.getData(cin));
   }

   public void clickSubmitButton(){
        OrganizationSubmitButton.click();
   }
}
