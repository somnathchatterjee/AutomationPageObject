package com.pageObject.Bidder;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Set;

public class ViewTerm extends TestBase {

    @FindBy(how = How.XPATH, using = "noauctionmsg")
    private WebElement Noauctionmsg;

    @FindBy(how = How.XPATH, using = "TermradioButton")
    private List<WebElement> TermradioButton;

    @FindBy(how = How.XPATH, using = "noOfacceptedNotice")
    private List<WebElement> noOfacceptedNotice;

    @FindBy(how = How.XPATH, using = "pendingauctioncheckbox")
    private List<WebElement> pendingauctioncheckbox;

    @FindBy(how = How.XPATH, using = "acceptradio")
    private List<WebElement> acceptradio;

    @FindBy(how = How.XPATH, using = "pendingsubmit")
    private WebElement pendingsubmit;


    public String noPendingNoticeFound(){
        try {
            return Noauctionmsg.getText();
        }catch (Exception e){
            return "There is some Term need to accept";
        }
    }

    public int numberOfAcceptedNotice(){

        try {
            return noOfacceptedNotice.size();
        }catch (Exception e){
            return 0;
        }

    }

    public void selectPendingCheckBox(){
        for(WebElement pending : TermradioButton){
            String text = pending.getAttribute("value");
            if(text.contentEquals(ConfigManager.getData("Pending"))) {
                pending.click();
                break;
            }
        }
    }

    public void selectAccepedCheckBox(){
        for(WebElement accepted : TermradioButton){
            String text = accepted.getAttribute("value");
            if(text.contentEquals(ConfigManager.getData("Accepted"))) {
                accepted.click();
                break;
            }
        }
    }

    public void selectRejectedCheckBox(){
        for(WebElement rejected : TermradioButton){
            String text = rejected.getAttribute("value");
            if(text.contentEquals(ConfigManager.getData("Rejected"))) {
                rejected.click();
                break;
            }
        }
    }

    public void selectThePendingAuction(){

        pendingauctioncheckbox.get(0).click();
    }


    public void selectTheAcceptButton(){

        acceptradio.get(0).click();
    }

    public void clickOnPendingSubmitButton(){

        pendingsubmit.click();
    }


}
