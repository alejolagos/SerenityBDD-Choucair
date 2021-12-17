package co.com.app.tasks.general;

import co.com.app.questions.TextFound;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.app.ui.organization.BusinessUnitsPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;

public class VerifyOperation implements Task {

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        //Verificacion del mensaje de estatus exitoso
        actor.should(
                seeThat(TextFound.in(SUCCESS_MESSAGE), equalTo("Save success"))
        );
        System.out.print(" -> "+ SUCCESS_MESSAGE.resolveFor(actor).getText()+"\n");
    }

    public static VerifyOperation statusMessage() {
        return instrumented(VerifyOperation.class);
    }
}
