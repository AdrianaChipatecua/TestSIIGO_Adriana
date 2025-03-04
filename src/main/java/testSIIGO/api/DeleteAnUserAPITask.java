package testSIIGO.api;

import testSIIGO.constants.Constants;
import testSIIGO.models.UserRegistrationData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteAnUserAPITask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        UserRegistrationData userRegistrationData = actor.recall(Constants.REGISTER_DATA_KEY);
        actor.attemptsTo(
                Delete.from("/api/users/" + userRegistrationData.getId())
                        .with(
                                requestSpecification ->
                                        requestSpecification
                                                .header("Accept", "application/json")
                        )
        );

        var response = SerenityRest.lastResponse().asString();
        actor.remember(Constants.PRINCIPAL_DATA_RESPONSE, response);
    }

    public static DeleteAnUserAPITask delete() {return instrumented(DeleteAnUserAPITask.class);}
}
