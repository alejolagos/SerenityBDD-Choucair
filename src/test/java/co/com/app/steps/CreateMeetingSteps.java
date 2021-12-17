package co.com.app.steps;

import co.com.app.enums.Menu;
import co.com.app.enums.SubMenu;
import co.com.app.factories.BusinessUnitsFactory;
import co.com.app.factories.UsersFactory;
import co.com.app.models.BusinessUnitsModel;
import co.com.app.models.UserModel;
import co.com.app.navigation.OpenBrowser;
import co.com.app.tasks.businessUnit.CreateBusinessUnit;
import co.com.app.tasks.general.VerifyOperation;
import co.com.app.tasks.general.NavigateTo;
import co.com.app.tasks.login.LoginToApp;
import co.com.app.tasks.meeting.FillMeetingContacts;
import co.com.app.tasks.meeting.FillMeetingData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.app.ui.meeting.MeetingsPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateMeetingSteps {
    private UserModel user;
    private BusinessUnitsModel businessUnit;

    @SneakyThrows
    @Given("^a (.*) log in to the website$")
    public void user_enter_to_website(String name) {
        user = UsersFactory.withName(name);
        theActorCalled(name)
                .wasAbleTo(
                        OpenBrowser.inWebPage(),
                        LoginToApp.withCredentials(user)
                );
    }

    @SneakyThrows
    @When("^create a business unit$")
    public void create_business_unit() {
        businessUnit = BusinessUnitsFactory.getParameters();
        theActorInTheSpotlight().wasAbleTo(
                NavigateTo.module(
                        Menu.ORGANIZATION.getOption(),
                        SubMenu.BUSINESS_UNITS.getOption()
                ),
                CreateBusinessUnit.withParent(businessUnit)
        );

        System.out.print("\n> Verificacion de 'BusinessUnit' creada ");
        theActorInTheSpotlight().attemptsTo(
                VerifyOperation.statusMessage()
        );
    }

    @And("^create a new meeting$")
    public void create_meeting(){
        theActorInTheSpotlight().wasAbleTo(
                NavigateTo.module(
                        Menu.MEETING.getOption(),
                        SubMenu.MEETINGS.getOption()
                ),
                Click.on(NEW_MEETING),
                FillMeetingData.withUnit(businessUnit.getUnit()),
                FillMeetingContacts.registerContacts(),
                Click.on(BUTTON_SAVE)
        );
    }

    @SneakyThrows
    @Then("^verify that the operation was successful$")
    public void verify_successful_operation() {
        System.out.print("\n> Verificacion de 'Meeting' creada ");
        theActorInTheSpotlight().attemptsTo(
                VerifyOperation.statusMessage()
        );
    }

}
