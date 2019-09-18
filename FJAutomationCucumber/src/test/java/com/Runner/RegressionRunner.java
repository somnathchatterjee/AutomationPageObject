package com.Runner;

import com.qa.configuration.ConfigManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/Resource/Feature/",
        glue = {
                "com.utilComponents",
                "com.stepDefination"
        },
        plugin = {"pretty", "html:target/Destination"})
public class RegressionRunner extends AbstractTestNGCucumberTests {

static {
    init();
}

    public static void init(){
        ConfigManager.read_config();
    }

}
