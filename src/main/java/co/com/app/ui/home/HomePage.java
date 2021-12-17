package co.com.app.ui.home;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    //localizadores panel superior
    public static final Target LBL_USERNAME = Target.the("").locatedBy("//span[@class='hidden-xs']");

    //localizadores panel izquierdo
    public static final Target OPTION_MENU = Target.the("").locatedBy("//ul[@id='SidebarMenu']//span[contains(text(),'{0}')]");
    public static final Target OPTION_SUBMENU = Target.the("").locatedBy("//ul[@class='treeview-menu menu-open']//span[contains(text(),'{0}')]");
}
