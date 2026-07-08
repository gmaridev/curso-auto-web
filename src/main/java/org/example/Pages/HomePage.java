package org.example.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By; // Usamos el By estándar de Selenium

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    // Se remueve el punto y coma intermedio para que sea una sola instrucción continua
    public static final Target REGISTER = Target.the("Campo de registro")
            .located(By.id("sign-username"));

    public static final Target PASS_WORD = Target.the("Campo de contraseña")
            .located(By.id("sign-password"));

    // Aquí agregamos las comillas dobles que faltaban en el XPath
    public static final Target BTN_REGISTER = Target.the("Boton para registrar")
            .locatedBy("//button[text()='Sign up']");
}