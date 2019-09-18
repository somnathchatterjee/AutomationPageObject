package com.pageObject;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminFinanceadd extends TestBase {


    @FindBy(how = How.XPATH, using = "fromdate")
    private WebElement FromDate;

    @FindBy(how = How.XPATH, using = "todate")
    private WebElement ToDate;

    @FindBy(how = How.XPATH, using = "prevmonth")
    private WebElement Prevmonth;

    @FindBy(how = How.XPATH, using = "nextmonth")
    private WebElement Nextmonth;

    @FindBy(how = How.XPATH, using = "monthfirstday")
    private WebElement Monthfirstday;

    @FindBy(how = How.XPATH, using = "todaydate")
    private WebElement Todaydate;

    @FindBy(how = How.XPATH, using = "submitbutton")
    private WebElement Submitbutton;

    @FindBy(how = How.XPATH, using = "search")
    private WebElement Search;

    @FindBy( how = How.XPATH, using = "lastrowsmodifybutton")
    private List<WebElement> Lastrowsmodifybutton;

    @FindBy(how = How.XPATH, using = "statusdd")
    private WebElement StatusDropDown;

    @FindBy(how = How.XPATH, using = "confermationno")
    private WebElement ConfermationNo;

    @FindBy(how = How.XPATH, using = "savechanges")
    private WebElement SaveChanges;



    public void selectFromDate(){
        try {
            FromDate.click();
            Thread.sleep(1000);
            Prevmonth.click();
            Thread.sleep(1000);
            Monthfirstday.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectToDate(){
        try {
            ToDate.click();
            Thread.sleep(1000);
            Todaydate.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnSubmitButton(){

        try {
            Submitbutton.click();
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnLatestModifyButton(){
        List<WebElement> totalmodifybutton = Lastrowsmodifybutton;
        int i = totalmodifybutton.size();
        totalmodifybutton.get(i-1).click();
    }

    public void modifyThestatus(){
        Select statusdd = new Select(StatusDropDown);
        statusdd.selectByValue("S");
    }
    public void enterConfermationNumber(){
        ConfermationNo.sendKeys("CON123");
    }

    public void clickOnSaveButton(){
        SaveChanges.click();
    }
}
