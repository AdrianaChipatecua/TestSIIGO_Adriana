package testSIIGO.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class CreateClientPage {
    private CreateClientPage(){}

    public static Target LBL_CREATE_CLIENT = Target.the("Label create a client").located(By.xpath("//h2[normalize-space()='Crear un tercero']"));
    public static Target BTN_SAVE = Target.the("Button save").located(By.xpath("//button[normalize-space()='Guardar']"));
}
