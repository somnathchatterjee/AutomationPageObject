package com.pageObject.Bidder;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.utilComponents.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LiveBidPage extends TestBase {

    public static Utility scroll = new Utility();


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
    private List<WebElement> Hammerimg;

    @FindBy(how = How.XPATH, using = "efficativeBidprice")
    private WebElement efficativeBidprice;

    @FindBy(how = How.XPATH, using = "bidAmountInput")
    private List<WebElement> bidAmountInput;

    @FindBy(how = How.XPATH, using = "currentMarketPrice")
    private List<WebElement> currentMarketPrice;


    public void enterPassword(String transpasswrd) {
        Transctionpass.clear();
        Transctionpass.sendKeys(ConfigManager.getData(transpasswrd));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    public void clickTransSignInButton() {

        Enterbuttontran.click();
    }

    public void selectAuctions() {
        for (WebElement auctionlist : Auctioncheckbox) {
            String text = auctionlist.getAttribute("value");
            if (text.contentEquals(ConfigManager.getData("AuctionNo1"))) {
                auctionlist.click();
                break;
            }
        }
    }

    public void selectAllAuctions() {
        for (WebElement auctionalllist : Auctioncheckbox) {
           auctionalllist.click();
        }
    }

    public void deselectAuctionCheckBoxIfSelected() {
        List<WebElement> auction = Auctioncheckbox;
        for (WebElement auctionlist : auction) {
            if (auctionlist.isSelected()) {
                auctionlist.click();
            }
        }
    }

    public void clickOnWatchListButton() {

        Addtowatchlist.click();
    }

    public void selectAuctionCheckBox() {
        for(WebElement livecheck : Liveauctioncheckbox) {
            livecheck.click();
        }
    }

    public void clickOnMinusButton() {
        System.out.println("No of Minus button"+Minusbutton.size());
        for (WebElement min:Minusbutton) {
            min.click();
        }
    }

    public void clickOnSubmitButton() {

        Submitbutton.click();
    }

    public boolean isBidAcceptedDisplayed() {
        try {
            return Bidacceped.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBidRejectedDisplayed() {
        try {
            return Bidrejected.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHammersDisplayed() {
        try {
            System.out.println("Hammer Size"+Hammerimg.size());
            for(WebElement hammer : Hammerimg) {
                scroll.highlightTheVisibleElement(hammer);
                return hammer.isDisplayed();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String takeEffectedBidPrice() {
        try {
            return efficativeBidprice.getText();
        } catch (Exception e) {
            return "The amount is not displaying";
        }
    }

   /* public void enterBidAmoutn(String amt) {
        bidAmountInput.clear();
        bidAmountInput.sendKeys(amt);
    }*/

    public String currentPrice() {
        String price="";
        try {
            System.out.println("No of market price"+currentMarketPrice.size());
            for(WebElement curr:currentMarketPrice) {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                scroll.highlightTheVisibleElement(curr);
                price = wait.until(ExpectedConditions.visibilityOf(curr)).getAttribute("outerText");
                return price;
            }
        } catch (Exception e) {
            return "No current amount found";
        }
        return price;
    }

    public List<BigDecimal> valueOfUserBidAmount() {
       List <BigDecimal> userBid=null;
        System.out.println("No of bid amount"+bidAmountInput.size());
        for(WebElement user:bidAmountInput) {
            userBid = Collections.singletonList(new BigDecimal(user.getAttribute("value")));

            return userBid;
        }
        return userBid;
    }

    public List<BigDecimal> valueOfCurrentMarketAmount() {
        List<BigDecimal> currentBid = null;
        System.out.println("No of current bid"+currentMarketPrice.size());
        for(int i=0;i<=currentMarketPrice.size();i++) {
            currentBid = Collections.singletonList(new BigDecimal(currentMarketPrice.get(i).getAttribute("outerText")));
            return currentBid;
        }
        return currentBid;
    }

    public int sizeOfCurrentMarket(){

        return currentMarketPrice.size();
    }

    public int sizeOfUserValue(){

        return bidAmountInput.size();
    }




}
