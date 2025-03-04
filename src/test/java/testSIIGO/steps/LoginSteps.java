package testSIIGO.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;


public class LoginSteps {


    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;

    @Given("{word} is on the login page")
    public void isOnTheLoginPage(String actorName) {
        OnStage
                .theActorCalled(actorName)
                .describedAs(actorName + " is on the login page");
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url("https://github.com"));
    }
}
