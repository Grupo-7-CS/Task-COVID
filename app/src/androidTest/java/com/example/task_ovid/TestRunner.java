package com.example.task_ovid;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "com.example.task_ovid",
        strict = true
)
public class TestRunner {

}