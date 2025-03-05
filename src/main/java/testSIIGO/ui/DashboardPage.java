package testSIIGO.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    private DashboardPage() {
    }

    public static Target TAB_OPTIONS = Target.the("Menu").located(By.xpath("//div[@class='bg-white menu-tab-header']"));
    public static Target LBL_MENU_TAB = Target.the("Menu tab title").located(By.cssSelector(".menu-tab-title"));


    public static By SHADOW_ROOT = By.cssSelector(".data-siigo-five9.hydrated");
    public static By SHADOW_ROOT2 = By.cssSelector("siigo-button-atom[data-id='header-create-button']");
    public static By BTN_CREATE = By.cssSelector(".btn-element.size-m");
    public static By OPT_CLIENT = By.cssSelector("div:nth-child(1) > header:nth-child(3) > nav:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(5) > siigo-header-create-button-dropdown:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > li:nth-child(4)");



    public static Target OPT_MENU_SIIGO = Target.the("siigo dashboard").locatedByFirstMatching("Crear");
}