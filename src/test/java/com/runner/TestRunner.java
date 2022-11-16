package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = "Feature"
				features = { "src/test/resourcs/features/GHCuncred.feature",
						},
						tags = "@fuctional",
							
						glue = {"com.steps" },
						plugin = { "pretty", "html:target/cucumber-html-report.html" },
				        monochrome = true
		)


public class TestRunner {
	//,tags = { },

}

