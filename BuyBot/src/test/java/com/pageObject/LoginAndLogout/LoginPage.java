package com.pageObject.LoginAndLogout;

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

    @FindBy(how = How.XPATH, using = "invalidErrorMessage")
    private WebElement InvalidErrorMessage;

    @FindBy(how = How.XPATH, using = "radiobutton")
    private WebElement Radiobutton;

    @FindBy(how = How.XPATH, using = "enterbutton")
    private WebElement Enterbutton;

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

  public void clickSignInButton(){

      Login_Button.click();
  }

  public void clickRadioButton(){

        Radiobutton.click();
  }

  public boolean isRadioButtondisplayed(){
      try {
          return Radiobutton.isDisplayed();
      }catch (Exception e){
          return false;
      }
  }

  public void clickEnterButton(){

        Enterbutton.click();
  }

  public boolean errorMessage(){

      return InvalidErrorMessage.isDisplayed();
  }

}
