package com.qa.base;

import com.qa.configuration.DriverManager;
import com.qa.extentions.ConfigSupportedElementLocatorFactory;
import org.openqa.selenium.support.PageFactory;


public class TestBase extends DriverManager {

    public TestBase() {
        PageFactory.initElements(new ConfigSupportedElementLocatorFactory(), this);
    }

}
