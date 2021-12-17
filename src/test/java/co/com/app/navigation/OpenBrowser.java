package co.com.app.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class OpenBrowser implements Task {
    private final PageObject page;
//    private WebDriver driver;//Para la ejecución en el navegador remoto selenoid

    public OpenBrowser() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);//Para la ejecución en el navegador remoto selenoid
        page = new Application();

    }

    @Override
    @Step("{0} open browser")
    public <T extends Actor> void performAs(T actor) {
//        actor.can(BrowseTheWeb.with(driver));//Para la ejecución en el navegador remoto selenoid
        actor.attemptsTo(Open.browserOn(page));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static OpenBrowser inWebPage() {
        return instrumented(OpenBrowser.class);
    }
}
