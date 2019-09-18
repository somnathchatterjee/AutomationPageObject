package com.pageObject.Admin;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class CheckAuctionNotice extends TestBase {

    @FindBy(how = How.XPATH, using = "auctionnoticedropdown")
    private WebElement auctionnoticedropdown;

    @FindBy(how = How.XPATH, using = "noOfauction")
    private List<WebElement> noOfauction;

    @FindBy(how = How.XPATH, using = "checksubmit")
    private WebElement checksubmit;

    @FindBy(how = How.XPATH, using = "notreadytosubmit")
    private WebElement notreadytosubmit;

    @FindBy(how = How.XPATH, using = "readytosubmit")
    private WebElement readytosubmit;

    public void clickOnAuctionDropDownAndSelectLastAuction(){
        auctionnoticedropdown.click();
        List<WebElement> list = noOfauction;
        int a = list.size();
        list.get(a-1).click();
    }

    public void clickOnSubmitButton(){

        checksubmit.click();
    }

    public boolean verifyTheNotReadyStatement(){

        return notreadytosubmit.isDisplayed();
    }

    public boolean verifyTheReadyStatement(){

        return readytosubmit.isDisplayed();
    }

}
