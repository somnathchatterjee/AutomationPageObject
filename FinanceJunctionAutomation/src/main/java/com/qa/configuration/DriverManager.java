package com.qa.configuration;

import com.qa.Constants;
import com.qa.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Somnath.Chatterjee1
 * This class is use to create driver and quit driver
 */

public class DriverManager extends ConfigManager {

    public static WebDriver driver = null;
    public static ConfigManager configManager = null;
    public static String browser_name;

    public static WebDriver browserSelection() throws Exception {

        configManager = new ConfigManager();
        configManager.read_config();
        browser_name = Config.getProperty("browser");
        String url = Config.getProperty("URL");
        Log.info("******************************************************************");
        Log.info("The test should be performed at : " + browser_name + " Browser. ");
        Log.info("******************************************************************");

        if (browser_name.equalsIgnoreCase("CHROME")) {

            System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, path + "/Driver/chromedriver_new_2.exe");
            driver = new ChromeDriver();
            System.out.println("");
            System.out.println("The browser is opening...hold for a second");

        } else if (browser_name.equalsIgnoreCase("FIreFox")) {

            System.setProperty(Constants.SYSTEM_PROPERTY_GECKO_DRIVER, path + "/Driver/geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("");
            System.out.println("The browser is opening...hold for a second");

        } else {

            Log.error("The Browser is not found....Only chrome and firefox are present");
        }


        driver.manage().window().maximize();
        Log.info("*********************************************************************");
        Log.info("Navigating to the URL : " + url);
        Log.info("*********************************************************************");
        System.out.println("\n");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }

    public static WebDriver getInstance() throws Exception {
        if (driver == null) {
            driver = browserSelection();
        }
        return driver;
    }

    public static void cleanup() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            Logger.getLogger(Constants.LOG_CODE).log(Level.WARNING, "Driver already cleaned up");
        }
    }
}
