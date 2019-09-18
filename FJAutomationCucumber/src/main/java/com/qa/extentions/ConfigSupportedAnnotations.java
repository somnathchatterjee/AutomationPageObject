package com.qa.extentions;

import com.qa.configuration.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;

public class ConfigSupportedAnnotations extends Annotations {

    public ConfigSupportedAnnotations(Field field) {
        super(field);
    }

    @Override
    public By buildBy() {
        FindBy findBy = this.getField().getAnnotation(FindBy.class);
        By by = ConfigManager.getBy(findBy.how(), findBy.using());
        return by == null ? super.buildBy() : by;
    }

}
