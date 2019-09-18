package com.qa.base;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

public class MainRunner {

    public static void main(String[] arg){

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("TestNG.xml");//path to xml..
        testng.setTestSuites(suites);
        testng.run();

/*
        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("com.utilComponents.Hooks"));
        classes.add(new XmlClass("com.stepDefination.CheckTheLiveAuction"));
        test.setXmlClasses(classes) ;


        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();*/

    }
}
