package com.qa.configuration;

import com.qa.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverManager extends ConfigManager {

    public static WebDriver driver = null;
    public static ConfigManager configManager = null;

    public static WebDriver browserSelection() throws Exception {

        configManager = new ConfigManager();
        configManager.read_config();
        String browser_name = Config.getProperty("browser");
        String url = Config.getProperty("URL");
        System.out.println("\033[0;1m"+"******************************************************************");
        System.out.println("The test should be performed at : " + browser_name + " Browser. ");
        System.out.println("******************************************************************");

        if (browser_name.equalsIgnoreCase("CHROME")) {

            System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, path + "/Driver/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("");
            System.out.println("The browser is opening...hold for a second");

        } else if (browser_name.equalsIgnoreCase("FIreFox")) {

            System.setProperty(Constants.SYSTEM_PROPERTY_GECKO_DRIVER, path + "/Driver/geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("");
            System.out.println("The browser is opening...hold for a second");

        } else {

            System.out.println("The Browser is not found....Only chrome and firefox are present");
        }


        driver.manage().window().maximize();
        System.out.println("*********************************************************************");
        System.out.println("Navigating to the URL : " + url);
        System.out.println("*********************************************************************");
        driver.get(url);
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
