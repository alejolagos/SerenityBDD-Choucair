package co.com.app.tasks.businessUnit;

import co.com.app.factories.BusinessUnitsFactory;
import co.com.app.models.BusinessUnitsModel;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.app.ui.organization.BusinessUnitsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBusinessUnit implements Task {
    private BusinessUnitsModel businessUnit;

    public void CreateBusinessUnit(BusinessUnitsModel businessUnit)
    {
        this.businessUnit=businessUnit;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        businessUnit = BusinessUnitsFactory.getParameters();

        //Crea la unidad principal
        actor.attemptsTo(
                Click.on(NEW_BUSINESS_UNIT),
                Enter.theValue(businessUnit.getParentUnit()).into(INPUT_NAME),
                Click.on(BUTTON_SAVE),
                Click.on(CLOSE_WINDOW)
        );
        //Crea la unidad secundaria
        actor.attemptsTo(
                Click.on(NEW_BUSINESS_UNIT),
                Enter.theValue(businessUnit.getUnit()).into(INPUT_NAME),
                Click.on(SELECT_PARENT_UNIT),
                Click.on(LIST_PARENT_UNIT.of(businessUnit.getParentUnit())),
                Click.on(BUTTON_SAVE),
                Click.on(CLOSE_WINDOW)
        );
    }

    public static CreateBusinessUnit withParent(BusinessUnitsModel businessUnit) {
        return instrumented(CreateBusinessUnit.class, businessUnit);
    }
}
