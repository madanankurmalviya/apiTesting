package com.seleniumEasy.myTestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\ANKUR MALVIYA\\eclipse\\BDD\\FameWork\\src"
		                        + "\\main\\java\\com\\seleniumEasy\\Features\\SecondPage.feature", 
		         glue = {"com.seleniumEasy.stepDefinition" }, 
		         dryRun = false,
		         monochrome = true, 
		         format = { "pretty", "html:test-output","junit:junit_xml/cucumber.xml" })

public class TestRunner {

}
