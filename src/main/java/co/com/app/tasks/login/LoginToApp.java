package co.com.app.tasks.login;

import co.com.app.models.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.app.ui.login.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginToApp implements Task {

    private final UserModel user;

    public LoginToApp(UserModel user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getLogin()).into(INPUT_USERNAME),
                Enter.theValue(user.getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_LOGIN)
        );
    }

    public static LoginToApp withCredentials(UserModel user) {
        return instrumented(LoginToApp.class, user);
    }
}
