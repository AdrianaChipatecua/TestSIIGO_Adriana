package testSIIGO.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testSIIGO.constants.Constants;
import testSIIGO.questions.CommonQuestions;
import testSIIGO.task.CreateAClientTask;
import testSIIGO.task.SignInTask;
import testSIIGO.ui.CreateClientPage;
import testSIIGO.ui.DashboardPage;
import testSIIGO.ui.LoginPage;
import testSIIGO.utils.DataManager;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginSteps {

    @Given("{word} is on the login page")
    public void isOnTheLoginPage(String actorName) {
        OnStage
                .theActorCalled(actorName)
                .describedAs(actorName + " is on the login page");
        DataManager.initActorWithName(actorName);
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url(Constants.WEB_TEST));
    }

    @When("he/He/she/She enters valid credentials")
    public void entersValidCredentials() {
        OnStage
                .withCurrentActor(
                        WaitUntil.the(LoginPage.INP_PASSWORD_FIELD, isVisible())
                                .forNoMoreThan(Constants.WAIT_TIME).seconds());

        OnStage.withCurrentActor(SignInTask.signInTask());
    }

    @When("she goes to the create client form")
    public void goToClients() {
        OnStage
                .withCurrentActor(
                        WaitUntil.the(DashboardPage.TAB_OPTIONS, isVisible())
                                .forNoMoreThan(Constants.WAIT_TIME).seconds());
        OnStage.withCurrentActor(CreateAClientTask.createAClient());
    }


    @Then("the user is redirected to the home page")
    public void theUserIsRedirectedToTheHomePage() {
        OnStage
                .withCurrentActor(
                        WaitUntil.the(DashboardPage.TAB_OPTIONS, isVisible())
                                .forNoMoreThan(Constants.WAIT_TIME).seconds());
        CommonQuestions.elementIsPresent(DashboardPage.TAB_OPTIONS);
        CommonQuestions.elementIsPresent(DashboardPage.LBL_MENU_TAB);
    }

    @Then("the user is redirected to the create client page")
    public void validateCreateClient() {
        OnStage
                .withCurrentActor(
                        WaitUntil.the(CreateClientPage.LBL_CREATE_CLIENT, isVisible())
                                .forNoMoreThan(Constants.WAIT_TIME).seconds());
        CommonQuestions.elementIsPresent(CreateClientPage.LBL_CREATE_CLIENT);
        CommonQuestions.elementIsPresent(CreateClientPage.BTN_SAVE);
    }
}
