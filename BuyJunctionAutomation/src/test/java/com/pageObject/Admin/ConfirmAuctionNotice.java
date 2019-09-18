package com.pageObject.Admin;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ConfirmAuctionNotice extends TestBase {

    @FindBy(how = How.XPATH, using = "selectconfirmauctionnotice")
    private WebElement selectconfirmauctionnotice;

    @FindBy(how = How.XPATH, using = "confirmsubmitbutton")
    private WebElement confirmsubmitbutton;


    public void selectConfirmAuctionNotice(){
        Select con = new Select(selectconfirmauctionnotice);
        con.selectByIndex(0);
    }
    public void clickOnSubmitButton(){

        confirmsubmitbutton.click();
    }
}
