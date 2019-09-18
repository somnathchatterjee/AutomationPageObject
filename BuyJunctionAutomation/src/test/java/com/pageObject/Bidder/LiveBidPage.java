package com.pageObject.Bidder;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.utilComponents.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.math.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LiveBidPage extends TestBase {

    public static Scroll scroll=new Scroll();


    @FindBy(how = How.XPATH, using = "transctionpass")
    private WebElement Transctionpass;

    @FindBy(how = How.XPATH, using = "enterbuttontran")
    private WebElement Enterbuttontran;

    @FindBy(how = How.XPATH, using = "transpagetext")
    private WebElement Transpagetext;

    @FindBy(how = How.XPATH, using = "auctioncheckbox")
    private List<WebElement> Auctioncheckbox;

    @FindBy(how = How.XPATH, using = "addtowatchlist")
    private WebElement Addtowatchlist;

    @FindBy(how = How.XPATH, using = "liveauctioncheckbox")
    private List<WebElement> Liveauctioncheckbox;

    @FindBy(how = How.XPATH, using = "bidacceped")
    private WebElement Bidacceped;

    @FindBy(how = How.XPATH, using = "bidrejected")
    private WebElement Bidrejected;

    @FindBy(how = How.XPATH, using = "minusbutton")
    private List<WebElement> Minusbutton;

    @FindBy(how = How.XPATH, using = "submitbutton")
    private WebElement Submitbutton;

    @FindBy(how = How.XPATH, using = "hammerimg")
    private WebElement Hammerimg;

    @FindBy(how = How.XPATH, using = "efficativeBidprice")
    private WebElement efficativeBidprice;

    @FindBy(how = How.XPATH, using = "bidAmountInput")
    private WebElement bidAmountInput;

    @FindBy(how = How.XPATH, using = "currentMarketPrice")
    private WebElement currentMarketPrice;


    public void enterPassword(String transpasswrd){
        Transctionpass.clear();
        Transctionpass.sendKeys(ConfigManager.getData(transpasswrd));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    public void clickTransSignInButton(){

        Enterbuttontran.click();
    }

    public String transText(){

        return Transpagetext.getText();
    }

    public void selectAuctions(){
        for(WebElement auctionlist : Auctioncheckbox){
            String text = auctionlist.getAttribute("value");
            if(text.contentEquals(ConfigManager.getData("AuctionNo1"))) {
                auctionlist.click();
                break;
            }
        }
    }

    public void selectAuctionsNew(){
        for(WebElement auctionlist : Auctioncheckbox){
            String text = auctionlist.getAttribute("value");
            if(text.contentEquals(ConfigManager.getAucId("AucId1"))) {
                auctionlist.click();
                break;
            }
        }
    }

    public void selectAuctionsNew2(){
        for(WebElement auctionlist : Auctioncheckbox){
            String text = auctionlist.getAttribute("value");
            if(text.contentEquals(ConfigManager.getAucId2("AucId2"))) {
                auctionlist.click();
                break;
            }
        }
    }

    public void click(){
        System.out.println("Auc id: "+ Auctioncheckbox.size());
        for (WebElement auc : Auctioncheckbox){
            String t = auc.getAttribute("value");
            if(t.contentEquals(ConfigManager.getAucId("AucId1"))||t.contentEquals(ConfigManager.getAucId2("AucId2"))){
                auc.click();
                //break;
            }
        }
    }

/*    public boolean isCheckBoxIsSelected() {
        List<WebElement> auction1 = Auctioncheckbox;
            for (WebElement ele : auction1) {
                try {
                   return ele.isSelected();
                }catch (Exception e){
                    return false;
                }
            }
            return true;
        }*/



    public void deselectAuctionCheckBoxIfSelected(){
        List<WebElement> auction = Auctioncheckbox;
        for(WebElement auctionlist : auction) {

            if(auctionlist.isSelected()) {
                auctionlist.click();
            }
        }
    }

    public void clickOnWatchListButton(){

        Addtowatchlist.click();
    }

    public void selectFirstCheckBox(){

        Liveauctioncheckbox.get(0).click();
    }

    public void clickOnMinusButton(){
        int getSize = Minusbutton.size();
        Minusbutton.get(getSize-1).click();
    }

    public void clickOnSubmitButton(){

        Submitbutton.click();
    }

    public boolean isBidAcceptedDisplayed(){
        try {
            return Bidacceped.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isBidRejectedDisplayed(){
        try {
            return Bidrejected.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isHammerDisplayed(){
        try {
            scroll.highlightTheVisibleElement(Hammerimg);

            return Hammerimg.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public String takeEffectedBidPrice(){
        try{
            return efficativeBidprice.getText();
        }catch (Exception e){
            return "The amount is not displaying";
        }
    }

    public void enterBidAmoutn(String amt){

        bidAmountInput.clear();
        bidAmountInput.sendKeys(amt);
    }

    public String currentPrice(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,10);
            scroll.highlightTheVisibleElement(currentMarketPrice);

            String price = wait.until(ExpectedConditions.visibilityOf(currentMarketPrice)).getAttribute("outerText");
           return price;
        }catch (Exception e){
            return "No current amount found";
        }
    }

    public BigDecimal valueOfUserBidAmount(){
        BigDecimal userBid = new BigDecimal(bidAmountInput.getAttribute("value"));
        return userBid;


    }

    public BigDecimal valueOfCurrentMarketAmount(){
        BigDecimal currentBid=null;
        currentBid = new BigDecimal(currentMarketPrice.getAttribute("outerText"));
        return currentBid;

    }
}
