package testSIIGO.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "rerun:target/rerun.txt"},
        features = {"classpath:features"},
        tags = "@testAPI",
        glue = {"testSIIGO.steps", "testSIIGO.common"}
)

public class APIRunner {
}
