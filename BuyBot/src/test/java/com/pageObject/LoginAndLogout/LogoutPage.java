package com.pageObject.LoginAndLogout;

import com.qa.base.TestBase;
import com.qa.utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPage extends TestBase {

    @FindBy(how = How.XPATH, using = "Logout")
    private WebElement LogoutButton;


    public void logout(){
        try{
            LogoutButton.click();
            Thread.sleep(2000);
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }
}
