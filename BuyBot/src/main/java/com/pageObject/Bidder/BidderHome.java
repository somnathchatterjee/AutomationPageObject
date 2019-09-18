package com.pageObject.Bidder;

import com.qa.base.TestBase;
import com.qa.utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BidderHome extends TestBase {

    @FindBy(how = How.XPATH, using = "termdropdown")
    private WebElement Termdropdown;

    @FindBy(how = How.XPATH, using = "viewterm")
    private WebElement Viewterm;

    @FindBy(how = How.XPATH, using = "bidsdropdown")
    private WebElement Bidsdropdown;

    @FindBy(how = How.XPATH, using = "liveauctionbutton")
    private WebElement Liveauctionbutton;



    public Actions actions = new Actions(driver);


    public boolean isTermdropdownDisplayed(){
        try {
            return Termdropdown.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void hoverOnTerm_And_Click_On_ViewTerm(){
        try{
            Thread.sleep(2000);
            actions.moveToElement(Termdropdown).build().perform();
            Log.info("Terms & Condition element found and hovered");
            Thread.sleep(2000);
            boolean a = Viewterm.isDisplayed();
            if(a){
                Viewterm.click();
                Thread.sleep(2000);
            }else {
                Log.error("View term element is not visible");
            }
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

    public void hoverOn_Bid_And_Click_On_Liveauction(){
        try{
            Thread.sleep(2000);
            actions.moveToElement(Bidsdropdown).build().perform();
            Log.info("Bid(s) element found and hovered");
            Thread.sleep(2000);
            boolean a = Liveauctionbutton.isDisplayed();
            if(a){
                Log.info("Yeppeee.....Live auction button is displaying....let's click");
                Liveauctionbutton.click();
                Thread.sleep(2000);
            }else {
                Log.error("Live auction element is not visible");
            }
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

}
