package testSIIGO.steps;

import testSIIGO.api.DeleteAnUserAPITask;
import testSIIGO.api.RegisterUserAPITask;
import testSIIGO.api.UpdateAPITask;
import testSIIGO.constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import testSIIGO.questions.CommonQuestions;
import testSIIGO.api.ListUsersAPITask;
import testSIIGO.utils.DataManager;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ApiTestSteps {


    @Given("{word} starts the test")
    public void initApp(String actorName) {
        OnStage
                .theActorCalled(actorName)
                .describedAs("The user starts the test");
        DataManager.initActorWithName(actorName);

    }

    @When("he/He/she/She consults the list of users on page {string}")
    public void listUsers(String pageNum) {
        OnStage.withCurrentActor(
                ListUsersAPITask.getListUsers(pageNum)
        );

    }

    @When("he/He/she/She tries to log in without sending the password")
    public void registerUser() {
        OnStage.withCurrentActor(
                RegisterUserAPITask.register()
        );
    }

    @When("he/He/she/She makes a change to the system")
    public void updateUser() {
        OnStage.withCurrentActor(
                UpdateAPITask.update()
        );
    }

    @When("he/He/she/She tries to delete a user with a non-existent id")
    public void deleteUser() {
        OnStage.withCurrentActor(
                DeleteAnUserAPITask.delete()
        );
    }

    @Then("the list of users will be displayed")
    public void questionsListUsersResponse() {
        int totalUsers = Integer.parseInt(theActorInTheSpotlight().recall(Constants.LIST_USERS_TOTAL));
        List<Map<String, Object>> data = theActorInTheSpotlight().recall(Constants.PRINCIPAL_DATA_RESPONSE);
        List<String> expectedKeys = List.of("id", "email", "first_name", "last_name", "avatar");

        CommonQuestions.lessThanOrEqualTo(totalUsers, 12);
        CommonQuestions.validateDataContainsKeys(data, expectedKeys);

    }

    @Then("the error message {string} will be displayed")
    public void questionsRegisterUserResponse(String errorMessage) {
        String response = theActorInTheSpotlight().recall(Constants.PRINCIPAL_DATA_RESPONSE);
        CommonQuestions.validateMessageResponse(response, "error",errorMessage,400);
    }

    @Then("the date of the change should be recorded")
    public void questionsUpdateUserResponse() {
        String updatedAt = theActorInTheSpotlight().recall(Constants.PRINCIPAL_DATA_RESPONSE);
        String[] dateTimeParts = updatedAt.split("T");
        String datePart = dateTimeParts[0];

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(formatter);

        CommonQuestions.textEqualsText(datePart, formattedDate);
    }

    @Then("the response code {int} will be generated")
    public void questionsDeleteUserResponse(int statusCode) {
        String response = theActorInTheSpotlight().recall(Constants.PRINCIPAL_DATA_RESPONSE);
        CommonQuestions.validateStatusCode(response,statusCode);
    }

}
