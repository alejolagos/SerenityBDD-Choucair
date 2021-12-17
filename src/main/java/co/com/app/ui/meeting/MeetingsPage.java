package co.com.app.ui.meeting;

import net.serenitybdd.screenplay.targets.Target;

public class MeetingsPage {

    //Localizadores para fijar el Tipo de reunion
    public static final Target NEW_MEETING = Target.the("").locatedBy("//*[@class='tool-button add-button icon-tool-button']/div/span");
    public static final Target CLICKABLE_MEETING_TYPE = Target.the("").locatedBy("//div[@class='field MeetingTypeId col-sm-6']/div/a");
    public static final Target INPUT_MEETING_TYPE = Target.the("").locatedBy("//div[@class='field Name']/input");

    //Localizadores para fijar el Nombre, Numero, Fecha y Hora de la reunion
    public static final Target INPUT_MEETING_NAME = Target.the("").locatedBy("//input[@name='MeetingName' and @type='text']");
    public static final Target INPUT_MEETING_NUMBER = Target.the("").locatedBy("//input[@name='MeetingNumber' and @type='text']");
    public static final Target START_DATE = Target.the("").locatedBy("(//i[@class='inplace-button inplace-now'])[1]");
    public static final Target END_DATE = Target.the("").locatedBy("(//i[@class='inplace-button inplace-now'])[2]");

    //Localizadores para fijar la ubicacion
    public static final Target CLICKABLE_NEW_LOCATION = Target.the("").locatedBy("//div[@class='field LocationId col-sm-6']/div/a");
    public static final Target NEW_LOCATION = Target.the("").locatedBy("//div[@class='field LocationId col-sm-6']//a[@class='inplace-button inplace-create']");
    public static final Target INPUT_LOCATION_NAME = Target.the("").locatedBy("//div[@class='field Name']/input");

    //Localizadores para agregar nuevos elementos de quien asiste, reporta y organiza la reunion
    public static final Target NEW_ORGANIZED_BY = Target.the("").locatedBy("//div[@class='field OrganizerContactId col-sm-6']//a[@class='inplace-button inplace-create']");
    public static final Target NEW_ATTENDEE = Target.the("").locatedBy("//div[@class='field AttendeeList']//a[@class='inplace-button inplace-create']");
    public static final Target NEW_REPORTER = Target.the("").locatedBy("//div[@class='field ReporterContactId col-sm-6']//a[@class='inplace-button inplace-create']");

    //Localizadores para fijar Nombre,  Apellido y Correo de los asistentes
    public static final Target INPUT_FIRST_NAME = Target.the("").locatedBy("//div[@class='field FirstName']/input");
    public static final Target INPUT_LAST_NAME = Target.the("").locatedBy("//div[@class='field LastName']/input");
    public static final Target INPUT_EMAIL_NAME = Target.the("").locatedBy("//div[@class='field Email']/input[1]");
    public static final Target INPUT_EMAIL_DOMAIN = Target.the("").locatedBy("//div[@class='field Email']/input[2]");

    //localizadores de la seccion asisteentes
    public static final Target CLICKABLE_UNIT = Target.the("").locatedBy("//div[@class='field UnitId col-sm-6']/div/a");
    public static final Target CLICKABLE_ATTENDEE_LIST = Target.the("").locatedBy("//div[@class='field AttendeeList']//a[@class='select2-choice select2-default']");
    public static final Target ELEMENTS_LIST = Target.the("").locatedBy("//div[@class='select2-result-label' and contains(text(), '{0}')]");
    public static final Target ALL_ELEMENTS_LIST = Target.the("").locatedBy("//div[@class='select2-result-label']");

    //localizadores con opciones de uso general
    public static final Target TYPING_NEW_ELEMENT = Target.the("").locatedBy("//input[@class='select2-input select2-focused']");
    public static final Target WINDOW_BUTTON_SAVE = Target.the("").locatedBy("//div[@class='s-DialogContent']//i[@class='fa fa-floppy-o text-purple']");
    public static final Target CLOSE_ELEMENT = Target.the("").locatedBy("//div[@class='field AttendeeList']//abbr[@class='select2-search-choice-close']");
    public static final Target BUTTON_SAVE = Target.the("").locatedBy("//div[@class='buttons-inner']//i[@class='fa fa-check-circle text-purple']");

}