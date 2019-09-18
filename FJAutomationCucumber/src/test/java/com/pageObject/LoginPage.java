package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.qa.utility.ScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {

    @FindBy(how = How.XPATH, using = "username")
    private WebElement Username;

    @FindBy(how = How.XPATH,using = "password")
    private WebElement Password;

    @FindBy(how = How.XPATH, using = "submit")
    private WebElement Login_Button;

    @FindBy(how = How.XPATH, using = "BUDropdown")
    private WebElement BusinessUnit;

    @FindBy(how = How.XPATH, using = "invalidErrorMessage")
    private WebElement InvalidErrorMessage;

  public void enterUsername(String uname){
      Username.clear();
      Username.sendKeys(ConfigManager.getData(uname));
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
  }

  public void enterPassword(String passwrd){
      Password.clear();
      Password.sendKeys(ConfigManager.getData(passwrd));
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
  }

  public void selectBusinessUnit(String businessunit){
      Select businessunitdd = new Select(BusinessUnit);
      businessunitdd.selectByVisibleText(ConfigManager.getData(businessunit));
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
  }

  public boolean errorMessage(){

      return InvalidErrorMessage.isDisplayed();
  }

  public HomePage clickSignInButton(){
      Login_Button.click();
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
      return new HomePage();
  }
}
