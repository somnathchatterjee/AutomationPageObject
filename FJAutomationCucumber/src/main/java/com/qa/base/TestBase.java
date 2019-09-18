package com.qa.base;

import com.qa.configuration.ConfigManager;
import com.qa.configuration.DriverManager;
import com.qa.extentions.ConfigSupportedElementLocatorFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestBase extends DriverManager {

   /*public static WebDriver driver = null;
   public static List<WebElement> setData;
   public static DriverManager driverManager = null;
   ConfigManager configManager = new ConfigManager();*/

    public TestBase() {
        PageFactory.initElements(new ConfigSupportedElementLocatorFactory(), this);
    }
  /*  public static void initilize() throws Exception{
        //driverManager = new DriverManager();
        //DriverManager.browserSelection();
        //driver = DriverManager.driver;
        System.out.println("Driver open");
    }*/

  /*  public static WebElement byXpath(String xpath){
        return driver.findElement(By.xpath(ConfigManager.get(xpath)));
    }

    public static WebElement byXpaths(String xpaths, int index){

        setData = driver.findElements(By.xpath(ConfigManager.get(xpaths)));
        return setData.get(index);
    }*/

/*    public static boolean isElementPresent(String xpath1){
        try {
            driver.findElement(By.xpath(ConfigManager.get(xpath1)));
            return true;
        }catch (Exception e){
            return false;
        }

    }*/

}
