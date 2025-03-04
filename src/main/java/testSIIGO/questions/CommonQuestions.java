package testSIIGO.questions;

import testSIIGO.constants.Constants;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class CommonQuestions {

    private CommonQuestions() {
    }

    public static void textEqualsTarget(Target target, String label) {

        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(
                                seeThat(
                                        TheTarget.textOf(target), CoreMatchers.containsStringIgnoringCase(label)))
                                .waitingForNoLongerThan(10)
                                .seconds());
    }


    public static void textEqualsText(String valueA, String valueB) {
        Question<String> question = actor -> valueA;
        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(
                                seeThat(
                                        question, Matchers.equalToIgnoringCase(valueB)))
                                .waitingForNoLongerThan(10)
                                .seconds());
    }

    public static void lessThanOrEqualTo(int lowestValue , int comparisonValue) {
        Question<Integer> question = actor -> lowestValue;
        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(
                                seeThat(question, Matchers.lessThanOrEqualTo(comparisonValue)))
                                        .waitingForNoLongerThan(10)
                                        .seconds());
    }



    public static void elementIsPresent(Target target) {
        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(
                                seeThat(
                                        Visibility.of(target)))
                                .waitingForNoLongerThan(Constants.WAIT_TIME).seconds());
    }

    public static void validateDataContainsKeys(List<Map<String, Object>> data, List<String> expectedKeys) {
        for (Map<String, Object> item : data) {
            for (String key : expectedKeys) {
                if (!item.containsKey(key)) {
                    throw new AssertionError("Key " + key + " is missing in data item: " + item);
                }
            }
        }
    }

    public static void validateMessageResponse(String responseContent, String key ,String expectedMessage, int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse(responseContent,
                        response -> response.statusCode(statusCode)
                                .body(key, equalTo(expectedMessage)))
        );
    }

    public static void validateStatusCode(String responseContent,int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse(responseContent,
                        response -> response.statusCode(statusCode))
        );
    }
}
