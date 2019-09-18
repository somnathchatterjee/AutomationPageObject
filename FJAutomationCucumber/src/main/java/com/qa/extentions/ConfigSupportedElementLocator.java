package com.qa.extentions;

import com.qa.configuration.DriverManager;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;

import java.lang.reflect.Field;

public class ConfigSupportedElementLocator extends DefaultElementLocator {

    public ConfigSupportedElementLocator(Field field) throws Exception {

        super(DriverManager.getInstance(), new ConfigSupportedAnnotations(field));

    }

}
