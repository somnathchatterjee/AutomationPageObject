package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import com.utilComponents.Copy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DownloadHistoryReport extends TestBase {

    @FindBy(how = How.XPATH, using = "reporthistoryorgtype")
    private WebElement reporthistoryorgtype;

    @FindBy(how = How.XPATH, using = "reporthistorybu")
    private WebElement reporthistorybu;

    @FindBy(how = How.XPATH, using = "reporttype")
    private WebElement reporttype;

    @FindBy(how = How.XPATH, using = "reportorganization")
    private WebElement reportorganization;

    @FindBy(how = How.XPATH, using = "reportdownloadbutton")
    private WebElement reportdownloadbutton;

    public void selectOrganizationType(String orgtype){
        Select ot = new Select(reporthistoryorgtype);
        ot.selectByVisibleText(ConfigManager.getData(orgtype));
    }

    public void selectBusinessUnit(String bussi){
        Select bu = new Select(reporthistorybu);
        bu.selectByVisibleText(ConfigManager.getData(bussi));
    }

    public void selectReportType(String rpt){
        Select rt = new Select(reporttype);
        rt.selectByVisibleText(ConfigManager.getData(rpt));
    }

    public void selectOrganization(String org){
        Select orga = new Select(reportorganization);
        orga.selectByVisibleText(ConfigManager.getData(org));
    }

    public void clickOnDownloadButton(){
        reportdownloadbutton.click();
    }

    public void downloadTheFile(){
        try {
            Copy.copypath("D:/DownloadTest");
            Thread.sleep(500);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            Runtime.getRuntime().exec("D:/AutoItScripts/TransactionHistory.exe");
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
