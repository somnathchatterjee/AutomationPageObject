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

    public static String path = "D:\\FJAutomation\\ScreenShot\\";
    public static File file = new File(path);
    public static File getScreenshot(WebDriver driver) throws IOException {

        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String current = formater.format(calendar.getTime());

        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File screenShotname = new File(path+current+".png");
        System.out.println(screenShotname);
        FileUtils.copyFile(src,screenShotname);

        return src;
    }

    public static File takeScreenshot() throws Exception {
        return getScreenshot(DriverManager.getInstance());
    }


}
