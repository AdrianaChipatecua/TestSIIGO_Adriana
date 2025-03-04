package testSIIGO.screenplay;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import testSIIGO.abilities.UseADevice;
import testSIIGO.constants.Constants;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;



public class TestCast extends Cast {
    public EnvironmentVariables environmentVariables;

    public TestCast(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        return super.actorNamed(actorName,
                BrowseTheWeb.with(theDefaultDriverFor(actorName)),
                CallAnApi.at(Constants.BASE_PATH)
        );
    }

    private WebDriver theDefaultDriverFor(String actorName) {
        return ThucydidesWebDriverSupport.getWebdriverManager().getWebdriverByName(actorName);
    }
}
