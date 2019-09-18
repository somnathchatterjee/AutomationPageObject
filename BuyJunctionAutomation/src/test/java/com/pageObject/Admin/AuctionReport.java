package com.pageObject.Admin;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import net.sourceforge.lept4j.Sel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AuctionReport extends TestBase {

    @FindBy(how = How.XPATH, using = "value1")
    private WebElement value1;

    @FindBy(how = How.XPATH, using = "auctionrulereport")
    private WebElement auctionrulereport;

    @FindBy(how = How.XPATH, using = "auctionreporttype")
    private WebElement auctionreporttype;

    @FindBy(how = How.XPATH, using = "auctionreportsubmit")
    private WebElement auctionreportsubmit;

    public void enterValueOfAucIdOne(){
        value1.click();
        value1.sendKeys(ConfigManager.getAucId("AucId1"));
    }

    public void enterValueOfAucIdTwo(){
        value1.click();
        value1.sendKeys(ConfigManager.getAucId2("AucId2"));
    }

    public void selectAuctionRuleEnglishNoTies(){
        Select select = new Select(auctionrulereport);
        select.selectByVisibleText("RA-ENGLISH_NO_TIES-ENGLISH_NO_TIES");
    }

    public void selectAuctionRuleMultiSealedBid(){
        Select select = new Select(auctionrulereport);
        select.selectByVisibleText("RA-MULTI_BID_SEALED_BID-MULTI_BID_SEALED_BID");
    }

    public void selectAuctionReportType(){
        Select sel = new Select(auctionreporttype);
        sel.selectByVisibleText("Bid Trail");
    }

    public void clickOnEnterButton(){

        auctionreportsubmit.click();
    }

    public void back(){

        driver.navigate().back();
    }

}
