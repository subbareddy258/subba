package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue = {"stepDefinitions"},tags= "@searchLivingProducts",monochrome = true,plugin = { "pretty", "json:target/cucumber.json","html:target/cucumber.html" })

public class TestRunner2 extends AbstractTestNGCucumberTests {

}
