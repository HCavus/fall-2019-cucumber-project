package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                plugin={"pretty", //this report on the console
                        "html:target/default-cucumber-reports", //this goes in the html report in target, this is official reporting
                        "rerun:target/rerun.txt",//this works when something fails, rerun it with FailedTestRunner/dependency is in pom file
                        "json:target/cucumber.json" //report goes in the json file
                },
                features="src/test/resources/features",
                glue="com/cybertek/library/step_definitions",
                dryRun=false,
                tags="@wip"

)
public class CukesRunner {
}





// tags = "librarian" // run if librarian applies to it
// tags = "@login and @staff" // run if @login and @staff both applies to it
// tags = "@admin or @staff" // run if either @admin or @staff applies to it
//tags="not @staff" //will ignore the tag staff