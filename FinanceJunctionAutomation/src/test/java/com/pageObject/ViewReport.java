package com.pageObject;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ViewReport extends TestBase {

    @FindBy(how = How.XPATH, using = "reportbusinessunit")
    private WebElement reportbusinessunit;

    @FindBy(how = How.XPATH, using = "reportdatapoint")
    private WebElement reportdatapoint;

    @FindBy(how = How.XPATH, using = "reportfromdate")
    private WebElement reportfromdate;

    @FindBy(how = How.XPATH, using = "reporttodate")
    private WebElement reporttodate;

    @FindBy(how = How.XPATH, using = "reportprevmonth")
    private WebElement reportprevmonth;

    @FindBy(how = How.XPATH, using = "reportnextmonth")
    private WebElement reportnextmonth;

    @FindBy(how = How.XPATH, using = "reportmonthfirstday")
    private WebElement reportmonthfirstday;

    @FindBy(how = How.XPATH, using = "reporttodaydate")
    private WebElement reporttodaydate;

    @FindBy(how = How.XPATH, using = "reportbuyerorg")
    private WebElement reportbuyerorg;

    @FindBy(how = How.XPATH, using = "reportsellerorg")
    private WebElement reportsellerorg;

    @FindBy(how = How.XPATH, using = "reportfirstdata")
    private WebElement reportfirstdata;

    @FindBy(how = How.XPATH, using = "reportbufristdata")
    private WebElement reportbufristdata;

    @FindBy(how = How.XPATH, using = "reportsubmit")
    private WebElement reportsubmit;

    public void selectReportBusinessUnit(String rbu){
        Select reportbu = new Select(reportbusinessunit);
        reportbu.selectByVisibleText(ConfigManager.getData(rbu));
    }

    public void selectReportDataPoint(String rdp){
        Select reportdp = new Select(reportdatapoint);
        reportdp.selectByVisibleText(ConfigManager.getData(rdp));
    }

    public void selectFromDateBranch() {
        try {

            reportfromdate.click();
            Thread.sleep(1000);
            reportprevmonth.click();
            Thread.sleep(1000);
            reportmonthfirstday.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectToDateBranch() {
        try {
            reporttodate.click();
            Thread.sleep(1000);
            reporttodaydate.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectBuyerOrganization(String borg){
        Select bo = new Select(reportbuyerorg);
        bo.selectByVisibleText(ConfigManager.getData(borg));
    }

    public void selectSellerOrganization(String sorg){
        Select so = new Select(reportsellerorg);
        so.selectByVisibleText(ConfigManager.getData(sorg));
    }

    public void clickOnSubmitButton(){
        reportsubmit.click();
    }
}
