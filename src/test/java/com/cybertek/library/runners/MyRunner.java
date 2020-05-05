package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/myfeatures",
        glue="com/cybertek/library/my_step_definitions",
        dryRun=false,
        tags="@hi"
)
public class MyRunner {
}
