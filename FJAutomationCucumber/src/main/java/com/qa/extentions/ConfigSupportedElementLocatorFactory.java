package com.qa.extentions;

import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class ConfigSupportedElementLocatorFactory implements ElementLocatorFactory {

    @Override
    public ElementLocator createLocator(Field field) {
        ConfigSupportedElementLocator configSupportedElementLocator = null;
        try {
            configSupportedElementLocator = new ConfigSupportedElementLocator(field);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return configSupportedElementLocator;
    }

}
