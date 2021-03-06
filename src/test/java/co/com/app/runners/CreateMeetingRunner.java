package co.com.app.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/createMeeting.feature",
        glue = {"co.com.app"},
        snippets = SnippetType.CAMELCASE)
public class CreateMeetingRunner {
}
