package co.com.app.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    //localizadores inicio de sesion
    public static final Target INPUT_USERNAME = Target.the("Input user name").located(By.id("StartSharp_Membership_LoginPanel0_Username"));
    public static final Target INPUT_PASSWORD = Target.the("Input password").located(By.id("StartSharp_Membership_LoginPanel0_Password"));
    public static final Target BTN_LOGIN = Target.the("Btn Login").located(By.id("StartSharp_Membership_LoginPanel0_LoginButton"));

}
