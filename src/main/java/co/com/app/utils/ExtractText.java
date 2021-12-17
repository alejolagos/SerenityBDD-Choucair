package co.com.app.utils;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ExtractText {

    private static String string = "";

    public static String of(Target element) {
        List<WebElement> btn = getDriver().findElements(By.xpath(element.getCssOrXPathSelector()));
        for (WebElement webElement : btn) {
            if (webElement.isDisplayed()) {
                string = webElement.getText();
                break;
            }
        }
        return string;
    }
}
