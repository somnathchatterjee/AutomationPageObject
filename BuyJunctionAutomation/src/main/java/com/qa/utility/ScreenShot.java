package com.qa.utility;

import com.qa.configuration.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Somnath.Chatterjee1
 * This class is use to take screen shot
 */

public class ScreenShot {

    private static String path1 = System.getProperty("user.dir");
    private static String path = path1+"/ScreenShot/";
    public static File file = new File(path);

    private static String getScreenshot(String name) throws Exception {

        if (!file.exists()) {
            if (file.mkdir()) {
                Log.info("Screen Shot directory is created!");
            } else if(file.exists()) {
                    Log.info("Screen Shot directory is already created!");
            } else {
                Log.info("Failed to create Screen Shot directory!");
            }
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String current = formater.format(calendar.getTime());
        TakesScreenshot takesScreenshot = (TakesScreenshot)DriverManager.getInstance();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String dest = path+name+"_"+current+".png";
        File screenShotname = new File(dest);
        System.out.println(screenShotname);
        FileUtils.copyFile(src,screenShotname);

        return dest;
    }

    public static String takeScreenshot(String screenname) throws Exception {
       Log.info("Screen Shot taken.....Smile Please");
       return getScreenshot(screenname);

    }


}
