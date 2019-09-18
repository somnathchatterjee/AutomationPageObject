package com.qa.utility;

import com.qa.configuration.ConfigManager;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Somnath.Chatterjee1
 * This class is use to read excel
 */
public class ReadExcel {


    public static void readExcel(String exl,int first,int second) throws Exception {
        File excelsrc = new File(System.getProperty("user.dir")+"/src/main/resources/"+exl+".xls");
        FileInputStream excelinput = new FileInputStream(excelsrc);
        HSSFWorkbook wb = new HSSFWorkbook(excelinput);
        HSSFSheet sheet = wb.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        //HashMap<String, String> username = new HashMap<String, String>();
       // HashMap<String, String> Allusername = new HashMap<String, String>();

        String d = "("+DateAndTime.dateAndTime(first)+")";
        String e = "("+DateAndTime.dateAndTime(second)+")";
        String aucname = ConfigManager.getData("enterrfqname");
        System.out.println(d);
        System.out.println(e);
        System.out.println("Auction Name : "+aucname);


        for(int i=1;i<rowCount+1;i++){
            Row row = sheet.getRow(i);
            //for (int j=0;j<row.getLastCellNum();j++) {
                System.out.print(row.getCell(3).getStringCellValue()+"| ");
            System.out.print(row.getCell(4).getStringCellValue()+"| ");
            row.getCell(3).setCellValue(d);
            row.getCell(4).setCellValue(e);
            row.getCell(1).setCellValue(aucname);
            //}
            System.out.println();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(excelsrc);
       wb.write(fileOutputStream);
       wb.close();
    }

   /*public static void main(String []args) throws Exception {
       ReadExcel rx = new ReadExcel();
       HashMap users = rx.readExcel();
       Iterator it = users.keySet().iterator();
       while (it.hasNext()) {
           String key = (String) it.next();
           System.out.println(key + " : " + users.get(key));

       }
   }*/
}


