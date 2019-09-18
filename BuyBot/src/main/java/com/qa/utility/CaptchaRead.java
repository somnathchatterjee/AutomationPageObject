package com.qa.utility;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class CaptchaRead {
    static String a;

    public String readTextFromCaptcha(File src){

        try {
            //File scr = driver.findElement(By.id("")).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(""));

            ITesseract img = new Tesseract();
            a = img.doOCR(new File(""));
            //a.split("below")[1].replaceAll("[^a-zA-Z0-9]", "");

        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
}
