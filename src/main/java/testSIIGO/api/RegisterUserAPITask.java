package testSIIGO.api;

import testSIIGO.constants.Constants;
import testSIIGO.models.UserRegistrationData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class RegisterUserAPITask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserRegistrationData userRegistrationData = actor.recall(Constants.REGISTER_DATA_KEY);
        String requestBody = String.format(
                "{\"username\":\"%s\", \"email\":\"%s\", \"password\":\"%s\"}",
                userRegistrationData.getUsername(),
                userRegistrationData.getEmail(),
                userRegistrationData.getPassword()
        );

        actor.attemptsTo(
                Post.to("/api/register")
                        .with(
                                requestSpecification ->
                                        requestSpecification
                                                .header("Content-Type", "application/json")
                                                .header("Accept", "application/json")
                                                .body( requestBody)
                        )
        );
        var response = SerenityRest.lastResponse().asString();
        actor.remember(Constants.PRINCIPAL_DATA_RESPONSE, response);

    }

    public static RegisterUserAPITask register() {
        return instrumented(RegisterUserAPITask.class);
    }
}
