package ScenarioDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Features",
        glue = "ScenarioDefinitions"
)
public class Test_Runner {
}
