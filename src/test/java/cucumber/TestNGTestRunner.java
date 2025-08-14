package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "inarAcademy.stepDefinitions",
        monochrome = true, tags = "@Regression", plugin = {"html:target/cucumber.html"})
//monochrome = true -> readable format
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}
