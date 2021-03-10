package Runners;

import Steps.Steps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "Steps",
        plugin = {"pretty"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
