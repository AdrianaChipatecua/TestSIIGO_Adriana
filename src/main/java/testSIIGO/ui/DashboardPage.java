package testSIIGO.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    private DashboardPage (){}

    public static Target TAB_OPTIONS = Target.the("Menu").located(By.cssSelector("tab-menu-atom"));
public static Target BTN_CREATE = Target.the("Create").located(By.id("header-create-button"));
public static Target LIST_CREATE_OPTIONS = Target.the("Create options list").located(By.cssSelector(".data-siigo-five9.hydrated"));

}
