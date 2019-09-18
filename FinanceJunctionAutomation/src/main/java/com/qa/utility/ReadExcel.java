package com.qa.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Somnath.Chatterjee1
 * This class is use to read excel
 */
public class ReadExcel {

    @Test
    public void readExcel() throws Exception {
        File excelsrc = new File(System.getProperty("user.dir")+"/src/main/resources/TestData.xlsx");
        FileInputStream excelinput = new FileInputStream(excelsrc);
        XSSFWorkbook wb = new XSSFWorkbook(excelinput);
        XSSFSheet sheet = wb.getSheetAt(0);


        //HashMap<String, String> username = new HashMap<String, String>();
       // HashMap<String, String> Allusername = new HashMap<String, String>();

        for(int i=0;i<sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++) {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"| ");
                //username.put("Username1"+ i + j ,name);

                //Allusername.putAll(username);
            }
        }
        //return username ;
    }

 /*   public static void main(String []args) throws Exception {
        ReadExcel rx = new ReadExcel();
        HashMap users = rx.readExcel();
        Iterator it = users.keySet().iterator();
        while(it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key + " : " + users.get(key));
        }
    }*/
}

