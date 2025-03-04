package testSIIGO.abilities;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseADevice extends BrowseTheWeb {
    protected UseADevice(WebDriver browser) {
        super(browser);
    }

    public static UseADevice likeActor(Actor actor) {
        UseADevice ability = actor.abilityTo(UseADevice.class);
        if (ability != null) {
            return ability.asActor(actor);
        } else {
            throw new IllegalArgumentException("The Actor doesn't have this ability");
        }
    }

    @Override
    public String toString() {
        return "Use a web page";
    }

    public static UseADevice with(WebDriverFacade browser) {return new UseADevice(browser);}






}