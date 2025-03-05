package testSIIGO.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import testSIIGO.interactions.ClickShadowElementInteraction;
import testSIIGO.ui.DashboardPage;


import static net.serenitybdd.screenplay.Tasks.instrumented;
;

public class CreateAClientTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickShadowElementInteraction.on(DashboardPage.SHADOW_ROOT, DashboardPage.SHADOW_ROOT2, DashboardPage.BTN_CREATE),
                ClickShadowElementInteraction.onSingleShadow(DashboardPage.SHADOW_ROOT,DashboardPage.OPT_CLIENT)
        );
    }

    public static CreateAClientTask createAClient() {
        return instrumented(CreateAClientTask.class);
    }
}
