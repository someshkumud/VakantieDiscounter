package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * This class is created to support running cucumber features
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */


@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json"},
        glue = "steps")


public class TestRunner {

}

