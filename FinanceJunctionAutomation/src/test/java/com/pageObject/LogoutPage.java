package com.pageObject;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPage extends TestBase {

    @FindBy(how = How.XPATH, using = "LogoutName")
    private WebElement Username;

    @FindBy(how = How.XPATH, using = "Logout")
    private WebElement Logout;

    @FindBy(how = How.XPATH, using = "LogoutButton")
    private WebElement LogoutButton;

    public void logout(){
        try{
            Username.click();
            Thread.sleep(2000);
            Logout.click();
            Thread.sleep(3000);
            LogoutButton.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
