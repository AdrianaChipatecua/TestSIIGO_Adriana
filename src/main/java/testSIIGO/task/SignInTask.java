package testSIIGO.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testSIIGO.constants.Constants;
import testSIIGO.models.UserRegistrationData;
import testSIIGO.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SignInTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserRegistrationData userRegistrationData = actor.recall(Constants.REGISTER_DATA_KEY);
        actor.attemptsTo(
                Enter.theValue(userRegistrationData.getEmail()).into(LoginPage.INP_EMAIL_FIELD),
                Enter.theValue(userRegistrationData.getPassword()).into(LoginPage.INP_PASSWORD_FIELD),
                Click.on(LoginPage.BTN_LOGIN_BUTTON)
        );
    }

    public static SignInTask signInTask() {
        return instrumented(SignInTask.class);
    }
}

