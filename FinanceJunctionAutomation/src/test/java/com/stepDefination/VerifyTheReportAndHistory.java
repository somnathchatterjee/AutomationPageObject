package com.stepDefination;

import com.pageObject.DownloadHistoryReport;
import com.pageObject.HomePage;
import com.pageObject.ViewReport;
import org.testng.annotations.Test;

public class VerifyTheReportAndHistory {

    private HomePage homePage = new HomePage();
    private ViewReport report = new ViewReport();
    private DownloadHistoryReport historyReport = new DownloadHistoryReport();

    @Test(priority = 14)
    public void navigateToReportDetails(){
        homePage.clickOnReport();
        homePage.clickOnViewReport();
    }

    @Test(priority = 15)
    public void verifyTheReportDetails(){
        try {
            report.selectReportBusinessUnit("ReportBUName");
            Thread.sleep(1000);
            report.selectReportDataPoint("ReportASNName");
            Thread.sleep(1000);
            //report.selectFromDateBranch();
            //report.selectToDateBranch();
            report.selectBuyerOrganization("ReportBuyerData");
            Thread.sleep(1000);
            report.selectSellerOrganization("ReportSellerData");
            Thread.sleep(1000);
            report.clickOnSubmitButton();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 16)
    public void navigateToReportHistory(){
        homePage.clickOnReport();
        homePage.clickOnReportHistory();
    }

    @Test(priority = 17)
    public void verifyTheReportHistory(){
        try{
            historyReport.selectOrganizationType("OrgTypename");
            Thread.sleep(1000);
            historyReport.selectBusinessUnit("BunitType");
            Thread.sleep(1000);
            historyReport.selectReportType("ReportType");
            Thread.sleep(1000);
            historyReport.selectOrganization("OrganizationName");
            Thread.sleep(1000);
            historyReport.clickOnDownloadButton();
            historyReport.downloadTheFile();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
