package co.com.app.steps;

import co.com.app.factories.UsersFactory;
import co.com.app.models.UserModel;
import co.com.app.navigation.OpenBrowser;
import co.com.app.questions.TextFound;
import co.com.app.tasks.login.LoginToApp;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.SneakyThrows;
import static co.com.app.ui.home.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginSteps {
    private UserModel user;

    @SneakyThrows
    @Given("^(.*) wants to access the demo website$")
    public void accessToApp(String name) {
        user = UsersFactory.withName(name);
        theActorCalled(name)
                .wasAbleTo(
                        OpenBrowser.inWebPage()
                );
    }

    @When("^user enter the credentials$")
    public void userFillCredentials() {
        theActorInTheSpotlight()
                .attemptsTo(
                        LoginToApp.withCredentials(user)
                );
    }

    @Then("^user verify access to system$")
    public void userVerifyAccess() {

        theActorInTheSpotlight()
                .should(
                        seeThat("Verify logged in user", TextFound.in(LBL_USERNAME), containsString(user.getLogin()))
                );
        System.out.println("\n> El usuario '"+user.getLogin()+"' se logueo correctamente.");
    }
}
