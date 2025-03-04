package testSIIGO.common;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import testSIIGO.screenplay.TestCast;

public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStageWebPlay() {
        OnStage.setTheStage(new TestCast(environmentVariables));

    }

}