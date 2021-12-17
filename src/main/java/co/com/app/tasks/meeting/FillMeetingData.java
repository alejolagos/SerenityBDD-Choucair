package co.com.app.tasks.meeting;

import co.com.app.factories.MeetingsFactory;
import co.com.app.models.MeetingsModel;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.Keys;

import static co.com.app.ui.meeting.MeetingsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillMeetingData implements Task {
    private MeetingsModel meeting;
    private String unit;

    public FillMeetingData (String unit){this.unit=unit;}

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        meeting = MeetingsFactory.getParameters();

        //llenando los campos de la reunion Nombre, Numero, fecha inicio y fin
        actor.attemptsTo(
                Enter.theValue(meeting.getMeetingName()).into(INPUT_MEETING_NAME),
                Enter.theValue(meeting.getMeetingNumber()).into(INPUT_MEETING_NUMBER),
                Click.on(START_DATE),
                Click.on(END_DATE),
                Click.on(CLICKABLE_MEETING_TYPE),
                Enter.theValue(meeting.getMeetingType()).into(TYPING_NEW_ELEMENT).thenHit(Keys.ENTER)
        );

        //si el tipo de reunion no existe entra al if y la crea
        if (Visibility.of(INPUT_MEETING_TYPE).viewedBy(actor).asBoolean())
        {
            actor.attemptsTo(
                    Enter.theValue(meeting.getMeetingType()).into(INPUT_MEETING_TYPE),
                    Click.on(WINDOW_BUTTON_SAVE)
            );
        }else{System.out.println(">>> La Reunion '"+meeting.getMeetingType()+"' ya existe...");}

        //se registra la ubicacion de la reunion
        actor.attemptsTo(
                Click.on(NEW_LOCATION),
                Enter.theValue(meeting.getLocation()).into(INPUT_LOCATION_NAME),
                Click.on(WINDOW_BUTTON_SAVE),
                Click.on(CLICKABLE_UNIT),
                Click.on(ELEMENTS_LIST.of(unit))
        );
    }

    public static FillMeetingData withUnit(String unit) {
        return instrumented(FillMeetingData.class, unit);
    }
}
