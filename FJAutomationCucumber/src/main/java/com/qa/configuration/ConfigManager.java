package com.qa.configuration;

import com.qa.Constants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Somnath Chatterjee
 *
 * @ConfigManager class is use to read data from
 *            config.properties
 *            Properties files form TestData directory
 *            Properties files from Locators directory
 *
 */

public class ConfigManager {


    public static Properties Config = null;
    private static final Properties locators = new Properties();
    private static final Properties Testdata = new Properties();
    public static String path = System.getProperty("user.dir");

    /**
     *
     * @throws Exception
     *
     */

    public static void read_config(){

        try {
            File con_src = new File(path + "/src/main/resources/Config.properties");
            FileInputStream read_config = new FileInputStream(con_src);
            Config = new Properties();
            Config.load(read_config);
            System.out.println("\033[0;1m" + "The Configuration file is loaded.");
            System.out.println("***********************************************************************");
            init();
            testData();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void init() {
        try {
            File locatorFiles = new File("D:\\FJAutomation\\src\\test\\Locator");
            File[] lst = locatorFiles.listFiles();
            if (locatorFiles.exists()) {
                if (locatorFiles.isDirectory()) {
                    Files.walk(locatorFiles.toPath())
                            .filter(path -> path.toString().endsWith(".properties"))
                            .forEach(path -> {
                                Properties properties = new Properties();
                                try {
                                    properties.load(new FileInputStream(path.toFile()));
                                    locators.putAll(properties);
                                        System.out.println("The " + path.getFileName() + " files are read from Locators directory");
                                        System.out.println("");


                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                } else {
                    locators.load(new FileInputStream(locatorFiles));
                }
            } else {
                Logger.getLogger(Constants.LOG_CODE).log(Level.WARNING, "Please specify locators");
            }
        } catch (Exception e) {
            Logger.getLogger(Constants.LOG_CODE).log(Level.SEVERE, "Error in initializing locators", e);
        }
    }

    private static void testData() {
        try {
            File dataFiles = new File("D:\\FJAutomation\\src\\test\\TestData");
            if (dataFiles.exists()) {
                if (dataFiles.isDirectory()) {
                    Files.walk(dataFiles.toPath())
                            .filter(path -> path.toString().endsWith(".properties"))
                            .forEach(path -> {
                                Properties properties = new Properties();
                                try {
                                    properties.load(new FileInputStream(path.toFile()));
                                    Testdata.putAll(properties);
                                    System.out.println("The " + path.getFileName() +" files are read from TestData directory");
                                    System.out.println(" ");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                } else {
                    Testdata.load(new FileInputStream(dataFiles));
                }
            } else {
                Logger.getLogger(Constants.LOG_CODE).log(Level.WARNING, "Please specify Testdata");
            }
        } catch (Exception e) {
            Logger.getLogger(Constants.LOG_CODE).log(Level.SEVERE, "Error in initializing Testdata", e);
        }
    }

    /**
     * Returns relevant By instance for specified parameters.
     *
     * @param how       Locator type to find the web element
     * @param key       Locator key (specified in locator property file)
     * @param arguments Additional arguments
     * @return Appropriate By instance
     */
    public static By getBy(How how, String key, Object... arguments) {
        String locator = get(key);
        if (!StringUtils.isEmpty(locator)) {
            if (arguments != null && arguments.length > 0) {
                locator = MessageFormat.format(locator, arguments);
            }
            switch (how) {
                case CLASS_NAME: {
                    return By.className(locator);
                }
                case CSS: {
                    return By.cssSelector(locator);
                }
                case ID: {
                    return By.id(locator);
                }
                case LINK_TEXT: {
                    return By.linkText(locator);
                }
                case NAME: {
                    return By.name(locator);
                }
                case PARTIAL_LINK_TEXT: {
                    return By.partialLinkText(locator);
                }
                case TAG_NAME: {
                    return By.tagName(locator);
                }
                case XPATH: {
                    return By.xpath(locator);
                }
            }
        }
        return null;
    }

    /**
     * Returns locator for a given element.
     *
     * @param key Element in String format
     * @return Element locator in String format
     */
    public static String get(String key) {
        return locators.getProperty(key);
    }

    /**
     * Returns testdata for a given element.
     *
     * @param data Element in String format
     * @return Element locator in String format
     */
    public static String getData(String data){
        return Testdata.getProperty(data);
    }

}
