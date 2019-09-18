package com.qa.utility;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadExcel {

    public void readExcel() throws Exception {
        File excelsrc = new File("");
        FileInputStream excelinput = new FileInputStream(excelsrc);
        XSSFWorkbook wb = new XSSFWorkbook(excelinput);
        XSSFSheet sheet = wb.getSheetAt(1);
        XSSFRow row = sheet.getRow(1);

        for(int i=1;i<=sheet.getLastRowNum();i++){
            for (int j=1;j<=row.getLastCellNum();j++){
                sheet.getRow(i).getCell(j).getStringCellValue();
                sheet.createRow(9).createCell(j).setCellValue("Pass");
            }
        }


        }
    }

