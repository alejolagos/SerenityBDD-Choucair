package co.com.app.tasks.meeting;

import co.com.app.factories.ContactsFactory;
import co.com.app.models.ContactsModel;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.com.app.ui.meeting.MeetingsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillPersonData implements Task {
    private ContactsModel contact;

    public FillPersonData(ContactsModel contact)
    {
        this.contact=contact;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        //se registra los campos en común de la persona
        actor.attemptsTo(
                Enter.theValue(contact.getFirstName()).into(INPUT_FIRST_NAME),
                Enter.theValue(contact.getLastName()).into(INPUT_LAST_NAME),
                Enter.theValue(contact.getEmailName()).into(INPUT_EMAIL_NAME),
                Enter.theValue(contact.getEmailDomain()).into(INPUT_EMAIL_DOMAIN)
        );
    }

    public static FillPersonData register(ContactsModel contact) {
        return instrumented(FillPersonData.class, contact);
    }

}
