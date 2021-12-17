package co.com.app.tasks.meeting;

import co.com.app.factories.ContactsFactory;
import co.com.app.models.ContactsModel;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.app.ui.meeting.MeetingsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillMeetingContacts implements Task {
    private List<ContactsModel> contacts;

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
    contacts = ContactsFactory.getInformation();

    //Crea los contactos segun su tipo "organized", "reporter" o "attendee"
    for (int i=0;i< contacts.size();i++)
    {
        if(contacts.get(i).getContactType().equals("organized"))
        {
            actor.attemptsTo(
                    Click.on(NEW_ORGANIZED_BY),
                    FillPersonData.register(contacts.get(i)),
                    Click.on(WINDOW_BUTTON_SAVE)
            );
        }else{
            if (contacts.get(i).getContactType().equals("reporter"))
            {
                actor.attemptsTo(
                        Click.on(NEW_REPORTER),
                        FillPersonData.register(contacts.get(i)),
                        Click.on(WINDOW_BUTTON_SAVE)
                );
            }else{
                if (contacts.get(i).getContactType().equals("attendee"))
                {
                    actor.attemptsTo(
                            Click.on(NEW_ATTENDEE),
                            FillPersonData.register(contacts.get(i)),
                            Click.on(WINDOW_BUTTON_SAVE),
                            Click.on(CLOSE_ELEMENT)
                    );
                }else{
                    System.out.println("Tipo de contacto desconocido...");
                }
            }
        }
    }

    //Agrega todos los contactos a la lista de asistencia
    for (int i = 0; i < contacts.size() ; i++)
    {
        actor.attemptsTo(
                Click.on(CLICKABLE_ATTENDEE_LIST),
                Click.on(ELEMENTS_LIST.of(contacts.get(i).getFirstName()))
        );
    }

    }

    public static FillMeetingContacts registerContacts() {
        return instrumented(FillMeetingContacts.class);
    }

}
