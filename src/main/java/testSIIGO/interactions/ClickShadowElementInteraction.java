package testSIIGO.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickShadowElementInteraction implements Interaction {

    private final By shadowHost;
    private final By nestedShadowHost;
    private final By finalElement;

    public ClickShadowElementInteraction(By shadowHost, By nestedShadowHost, By finalElement) {
        this.shadowHost = shadowHost;
        this.nestedShadowHost = nestedShadowHost;
        this.finalElement = finalElement;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebElement shadowHostElement = driver.findElement(shadowHost);
        SearchContext shadowRoot1 = shadowHostElement.getShadowRoot();


        WebElement targetElement;

        if (nestedShadowHost != null) {
            WebElement nestedShadowHostElement = shadowRoot1.findElement(nestedShadowHost);
            SearchContext shadowRoot2 = nestedShadowHostElement.getShadowRoot();
            targetElement = shadowRoot2.findElement(finalElement);
        } else {
            targetElement = shadowRoot1.findElement(finalElement);
        }

        targetElement.click();
    }

    public static ClickShadowElementInteraction on(By shadowHost, By nestedShadowHost, By finalElement) {
        return new ClickShadowElementInteraction(shadowHost, nestedShadowHost, finalElement);
    }

    public static ClickShadowElementInteraction onSingleShadow(By shadowHost, By finalElement) {
        return new ClickShadowElementInteraction(shadowHost, null, finalElement);
    }
}
