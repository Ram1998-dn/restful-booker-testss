package com.restful.booker.cucumber;

import com.restful.booker.testbase.TestBase;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com/restful/booker/cucumber/steps",
        tags = "@smoke"
)

public class CucumberRunner extends TestBase {
}
