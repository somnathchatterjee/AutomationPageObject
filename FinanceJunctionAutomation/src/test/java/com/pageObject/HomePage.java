package com.pageObject;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends TestBase {

    @FindBy(how = How.XPATH, using = "welcomenote")
    private WebElement Welcomenote;

    @FindBy(how = How.XPATH, using = "homebutton")
    private WebElement HomeLogo;

    @FindBy(how = How.XPATH, using = "Register")
    private WebElement Register;

    @FindBy(how = How.XPATH, using = "Organizatio_add")
    private WebElement AddOrganization;

    @FindBy(how = How.XPATH, using = "Organization_view")
    private WebElement ViewOrganization;

    @FindBy(how = How.XPATH, using = "Branch_add")
    private WebElement AddBranch;

    @FindBy(how = How.XPATH, using = "Branch_view")
    private WebElement ViewBranch;

    @FindBy(how = How.XPATH, using = "User_add")
    private WebElement AddUser;

    @FindBy(how = How.XPATH, using = "User_view")
    private WebElement ViewUser;

    @FindBy(how = How.XPATH, using = "reports")
    private WebElement ReportDropDown;

    @FindBy(how = How.XPATH, using = "reportsview")
    private WebElement Reportsview;

    @FindBy(how = How.XPATH, using = "reportshistory")
    private WebElement Reportshistory;

    @FindBy(how = How.XPATH, using = "customerOnboard")
    private WebElement CustomerOnboardDropDown;

    @FindBy(how = How.XPATH, using = "pendingrequest")
    private WebElement Pendingrequest;

    @FindBy(how = How.XPATH, using = "addbankaccount")
    private WebElement Addbankaccount;

    @FindBy(how = How.XPATH, using = "viewbankaccount")
    private WebElement Viewbankaccount;

    @FindBy(how = How.XPATH, using = "addmapbankaccount")
    private WebElement Addmapbankaccount;

    @FindBy(how = How.XPATH, using = "viewmapbankaccount")
    private WebElement Viewmapbankaccount;

    @FindBy(how = How.XPATH, using = "financerequestdd")
    private WebElement FinanceDropDown;

    @FindBy(how = How.XPATH, using = "financerequestview")
    private WebElement FinanceAdd;


    public boolean welcomename() {

        return Welcomenote.isDisplayed();
    }

    public boolean homelogo() {

        return HomeLogo.isDisplayed();
    }

    public boolean registerButtonDisplaye() {

        return Register.isDisplayed();
    }

    public void clickOnRegisterButton() {

        Register.click();
    }

    public boolean addOrganizaionButtonDisplaye() {

        return AddOrganization.isDisplayed();
    }

    public OrganizationAdd clickOnAddOrganization() {
        AddOrganization.click();
        return new OrganizationAdd();
    }

    public OrganizationView clickOnViewOrganization(){
        ViewOrganization.click();
        return new OrganizationView();
    }

    public BranchAdd clickOnAddBranch(){
        AddBranch.click();
        return new BranchAdd();
    }

    public BranchView clickOnViewBranch(){
        ViewBranch.click();
        return new BranchView();
    }

    public UserAdd clickOnAddUser(){
        AddUser.click();
        return new UserAdd();
    }

    public UserView clickOnViewUser(){
        ViewUser.click();
        return new UserView();
    }

    public void clickOnReport(){

        ReportDropDown.click();
    }

    public ViewReport clickOnViewReport(){
        Reportsview.click();
        return new ViewReport();
    }

    public DownloadHistoryReport clickOnReportHistory(){
        Reportshistory.click();
        return new DownloadHistoryReport();
    }

    public void clickOnCustomerOnBoard(){

        CustomerOnboardDropDown.click();
    }

    public PendingRequest clickOnPendingRequest(){
        Pendingrequest.click();
        return new PendingRequest();
    }

    public BankAccountAdd clickOnAddBankAccount(){
        Addbankaccount.click();
        return new BankAccountAdd();
    }

    public BankAccountView clickOnViewBankAccount(){
        Viewbankaccount.click();
        return new BankAccountView();
    }

    public AddBankAccountMap clickOnAddankAccountMap(){
        Addmapbankaccount.click();
        return new AddBankAccountMap();
    }

    public ViewBankAccountMap clickOnViewBankAccountMap(){
        Viewmapbankaccount.click();
        return new ViewBankAccountMap();
    }


    public void clickFinanceRequest(){

        FinanceDropDown.click();
    }

    public AdminFinanceadd clickFinanceAdd(){
        FinanceAdd.click();
        return new AdminFinanceadd();
    }
}
