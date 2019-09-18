package com.pageObject.Bidder;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddBidderVesselDetails extends TestBase {

    @FindBy(how = How.XPATH, using = "vesselname")
    private WebElement vesselname;

    @FindBy(how = How.XPATH, using = "imono")
    private WebElement imono;

    @FindBy(how = How.XPATH, using = "built")
    private WebElement built;

    @FindBy(how = How.XPATH, using = "vclass")
    private WebElement vclass;

    @FindBy(how = How.XPATH, using = "piclube")
    private WebElement piclube;

    @FindBy(how = How.XPATH, using = "deadweight")
    private WebElement deadweight;

    @FindBy(how = How.XPATH, using = "grt")
    private WebElement grt;

    @FindBy(how = How.XPATH, using = "nrt")
    private WebElement nrt;

    @FindBy(how = How.XPATH, using = "draft")
    private WebElement draft;

    @FindBy(how = How.XPATH, using = "airdraft")
    private WebElement airdraft;

    @FindBy(how = How.XPATH, using = "lengthoverall")
    private WebElement lengthoverall;

    @FindBy(how = How.XPATH, using = "beam")
    private WebElement beam;

    @FindBy(how = How.XPATH, using = "grearless")
    private WebElement grearless;

    @FindBy(how = How.XPATH, using = "geared")
    private WebElement geared;

    @FindBy(how = How.XPATH, using = "noofcrane")
    private WebElement noofcrane;

    @FindBy(how = How.XPATH, using = "cranecapacity")
    private WebElement cranecapacity;

    @FindBy(how = How.XPATH, using = "noofgrab")
    private WebElement noofgrab;

    @FindBy(how = How.XPATH, using = "grabscapacity")
    private WebElement grabscapacity;

    @FindBy(how = How.XPATH, using = "noofholds")
    private WebElement noofholds;

    @FindBy(how = How.XPATH, using = "owned")
    private WebElement owned;

    @FindBy(how = How.XPATH, using = "yes")
    private WebElement yes;

    @FindBy(how = How.XPATH, using = "nataionalindian")
    private WebElement nataionalindian;

    @FindBy(how = How.XPATH, using = "nameoftheowner")
    private WebElement nameoftheowner;

    @FindBy(how = How.XPATH, using = "headowner")
    private WebElement headowner;

    @FindBy(how = How.XPATH, using = "flagindian")
    private WebElement flagindian;

    @FindBy(how = How.XPATH, using = "presentposition")
    private WebElement presentposition;

    @FindBy(how = How.XPATH, using = "etaloadport")
    private WebElement etaloadport;

    @FindBy(how = How.XPATH, using = "docyes")
    private WebElement docyes;

    @FindBy(how = How.XPATH, using = "ismcertificate")
    private WebElement ismcertificate;

    @FindBy(how = How.XPATH, using = "smcceritficate")
    private WebElement smcceritficate;

    @FindBy(how = How.XPATH, using = "doccertificate")
    private WebElement doccertificate;

    @FindBy(how = How.XPATH, using = "vesseldetailssubmitbutton")
    private WebElement vesseldetailssubmitbutton;



    public void enterVessel_Name(String vname){
        vesselname.clear();
        vesselname.sendKeys(ConfigManager.getData(vname));
    }

    public void enterImo_Number(String imo){
        imono.clear();
        imono.sendKeys(ConfigManager.getData(imo));
    }

    public void selectBuilt(){
        Select select = new Select(built);
        select.selectByValue("2019");
    }

    public void enterClass(String cls){
        vclass.clear();
        vclass.sendKeys(ConfigManager.getData(cls));
    }

    public void enterP_IClub(String pi){
        piclube.clear();
        piclube.sendKeys(ConfigManager.getData(pi));
    }

    public void enterDeadWeight(String dw){
        deadweight.clear();
        deadweight.sendKeys(ConfigManager.getData(dw));
    }

    public void enterGrt(String gt){
        grt.clear();
        grt.sendKeys(ConfigManager.getData(gt));
    }

    public void enterNrt(String nt){
        nrt.clear();
        nrt.sendKeys(ConfigManager.getData(nt));
    }

    public void enterDraft(String dr){
        draft.clear();
        draft.sendKeys(ConfigManager.getData(dr));
    }

    public void enterAirDraft(String adr){
        airdraft.clear();
        airdraft.sendKeys(ConfigManager.getData(adr));
    }

    public void enterLengthOverall(String lo){
        lengthoverall.clear();
        lengthoverall.sendKeys(ConfigManager.getData(lo));
    }

    public void enterBeam(String bm){
        beam.clear();
        beam.sendKeys(ConfigManager.getData(bm));
    }

    public void selectGearlessAndEnterHolds(String hold){
        grearless.click();
        noofholds.clear();
        noofholds.sendKeys(ConfigManager.getData(hold));
    }

    public void selectOwnerShip(){

        owned.click();
    }

    public void selectRightToRefusal(){

        yes.click();
    }

    public void selectTheNationality(String own, String Hown){
        nataionalindian.click();
        nameoftheowner.sendKeys(ConfigManager.getData(own));
        headowner.sendKeys(ConfigManager.getData(Hown));
    }

    public void selectVesselFlag(String country, String city){
        flagindian.click();
        presentposition.sendKeys(ConfigManager.getData(country));
        etaloadport.sendKeys(ConfigManager.getData(city));
    }

    public void selectValidDocumentRequired(){
        docyes.click();
        ismcertificate.sendKeys("1SD23");
        smcceritficate.sendKeys("AUTO9876");
        doccertificate.sendKeys("THR5436");
    }

    public void clickOnSubmitbutton(){

        vesseldetailssubmitbutton.click();
    }
}
