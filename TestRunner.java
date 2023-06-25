package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/Registration.feature",
        glue = {"stepDefinitions"},tags ="@Login and @Registration",monochrome = true,plugin = { "pretty", "json:target/cucumber.json","html:target/cucumber.html" })
public class TestRunner {

    }
