package com.gabi;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        plugin = "pretty",
        tags = "@d"
)
@RunWith(CucumberWithSerenity.class)
public class Runner {
}
