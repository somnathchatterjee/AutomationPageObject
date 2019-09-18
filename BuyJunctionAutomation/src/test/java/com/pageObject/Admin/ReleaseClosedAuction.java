package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.utility.DateAndTime;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Collections;
import java.util.List;

public class ReleaseClosedAuction extends TestBase {

    @FindBy(how=How.XPATH, using = "closedstartdate")
    private WebElement closedstartdate;

    @FindBy(how = How.XPATH, using = "closedenddate")
    private WebElement closedenddate;

    @FindBy(how = How.XPATH, using = "closedclient")
    private WebElement closedclient;

    @FindBy(how = How.XPATH, using = "closedenterbutton")
    private WebElement closedenterbutton;

    @FindBy(how = How.XPATH, using = "closedcheckbox")
    private List<WebElement> closedcheckbox;

    @FindBy(how = How.XPATH, using = "closedbulkmodify")
    private WebElement closedbulkmodify;

    @FindBy(how = How.XPATH, using = "closedreleasedradio")
    private WebElement closedreleasedradio;

    @FindBy(how = How.XPATH, using = "closedmodify")
    private WebElement closedmodify;


    public void enterStartDate(){
       String  d = DateAndTime.dateAndTime(-25);
       closedstartdate.clear();
       closedstartdate.sendKeys(d);
      // Collections.sort();
    }

    public void enterEndDate(){
        String da = DateAndTime.dateAndTime(15);
        closedenddate.clear();
        closedenddate.sendKeys(da);
    }

    public void clickOnEnterButton(){

        closedenterbutton.click();
    }

    public void selectCheckBox(){
        int total = closedcheckbox.size();
        for (int i=0;i<total;i++) {
            closedcheckbox.get(i).click();
        }
    }

    public void clickOnBulkModifyButton(){

        closedbulkmodify.click();
    }

    public void selectReleaseAuctionRadioButton(){

        closedreleasedradio.click();
    }

    public void clickOnModifyButton(){

        closedmodify.click();
    }

}
