package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LogInPage extends PageObject {
    public static final Target INPUT_USERNAME = Target.the("Campo username")
            .locatedBy("//input[@id = 'loginusername']");
    public static final Target INPUT_PASSWORD = Target.the("Campo password")
            .locatedBy("//input[@id = 'loginpassword']");
    public static final Target BTN_CONFIRMAR_LOGIN = Target.the("Botón para iniciar sesión")
            .locatedBy("//button[@onclick = 'logIn()' ]");
}
