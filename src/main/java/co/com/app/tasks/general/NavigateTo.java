package co.com.app.tasks.general;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static co.com.app.ui.home.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {

    private final String optionMenu;
    private final String optionSubMenu;

    public NavigateTo(String optionMenu, String optionSubMenu) {
        this.optionMenu = optionMenu;
        this.optionSubMenu = optionSubMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPTION_MENU.of(optionMenu)),
                Click.on(OPTION_SUBMENU.of(optionSubMenu))
        );
    }

    public static NavigateTo module(String optionMenu, String optionSubMenu) {
        return instrumented(NavigateTo.class, optionMenu, optionSubMenu);
    }
}
