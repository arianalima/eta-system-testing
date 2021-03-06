package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        tags = "@eta",
        monochrome = false,
        plugin = "pretty",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}