package testSIIGO.api;

import testSIIGO.constants.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import testSIIGO.questions.CommonQuestions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ListUsersAPITask implements Task {

    private final String pageNum;

    public ListUsersAPITask(String pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users?page=" + pageNum)
        );
        actor.should(
                seeThatResponse("true",
                        response -> response.statusCode(200)
                )
        );
        var data = SerenityRest.lastResponse().jsonPath().getList("data");
        var page = SerenityRest.lastResponse().jsonPath().get("page").toString();
        var total = SerenityRest.lastResponse().jsonPath().get("total").toString();

        CommonQuestions.textEqualsText(pageNum, page);

        actor.remember(Constants.PRINCIPAL_DATA_RESPONSE, data);
        actor.remember(Constants.LIST_USERS_TOTAL, total);
    }

    public static ListUsersAPITask getListUsers(String pageNum) {
        return instrumented(ListUsersAPITask.class, pageNum);
    }
}
