package co.com.app.ui.organization;

import net.serenitybdd.screenplay.targets.Target;

public class BusinessUnitsPage {

    //localizadores de la seccion Business Unit
    public static final Target NEW_BUSINESS_UNIT = Target.the("").locatedBy("//i[@class='fa fa-plus-circle text-green']");
    public static final Target INPUT_NAME = Target.the("").locatedBy("//input[@name='Name' and @type='text']");
    public static final Target SELECT_PARENT_UNIT = Target.the("").locatedBy("//a[@class='select2-choice select2-default']");
    public static final Target LIST_PARENT_UNIT = Target.the("").locatedBy("//div[@class='select2-result-label' and contains(text(), '{0}')]"); // and text()='{0}'

    //Localizadores de uso general
    public static final Target BUTTON_SAVE = Target.the("").locatedBy("//div[@class='tool-button apply-changes-button icon-tool-button']/div/span");
    public static final Target CLOSE_WINDOW = Target.the("").locatedBy("//button[@class='ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close']");
    public static final Target SUCCESS_MESSAGE = Target.the("").locatedBy("//div[@class='toast-message']");
}