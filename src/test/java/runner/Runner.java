package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions
(
		features = {"src/test/java/features/"},
		glue = {"steps"},
		monochrome = true,
		tags = {},
		plugin = {"pretty","html:target/report","json:target/reports.json",
				  "com.cucumber.listener.ExtentCucumberFormatter:target/extentreport.html"}
		
		)


public class Runner extends AbstractTestNGCucumberTests{

}
