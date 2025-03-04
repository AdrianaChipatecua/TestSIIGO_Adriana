package testSIIGO.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    private LoginPage() {}

    public static Target INP_EMAIL_FIELD = Target.the("Username field")
            .located(By.id("siigoSignInName"));
    public static Target INP_PASSWORD_FIELD = Target.the("Password field")
            .located(By.id("siigoPassword"));
    public static Target BTN_LOGIN_BUTTON = Target.the("Login button")
            .located(By.id("siigoNext"));
    public static Target OPT_FORGOT_PASSWORD_LINK = Target.the("Forgot password link")
            .located(By.id("forgotPassword"));
    public static Target LBL_SIGN_IN = Target.the("Title login page")
            .located(By.linkText("Inicio de sesión"));
}