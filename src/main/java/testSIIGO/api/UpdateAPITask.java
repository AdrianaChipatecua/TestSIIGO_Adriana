package testSIIGO.api;

import testSIIGO.constants.Constants;
import testSIIGO.models.UserRegistrationData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateAPITask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        UserRegistrationData userRegistrationData = actor.recall(Constants.REGISTER_DATA_KEY);
        actor.attemptsTo(
                Put.to("/api/users/" + userRegistrationData.getId())
                        .with(
                                requestSpecification ->
                                        requestSpecification
                                                .header("Accept", "application/json")
                        )
        );

        var response = SerenityRest.lastResponse().jsonPath().get("updatedAt");
        actor.remember(Constants.PRINCIPAL_DATA_RESPONSE, response);
    }

    public static UpdateAPITask update() {return instrumented(UpdateAPITask.class);}
}
