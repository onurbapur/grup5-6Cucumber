package com.demoqa.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report.html"},
        features = "@target/rerun.txt",
        glue = "com/demoqa/step_definitions"

)
public class FailedTestRunner {
}
// If there is NO rerun.txt file, we will have;
// CucumberException: Failed to parse 'target\rerun.txt'