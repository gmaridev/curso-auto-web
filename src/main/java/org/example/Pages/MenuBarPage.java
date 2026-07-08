package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MenuBarPage extends PageObject {
    public static final Target BTN_SIGN_UP = Target.the("Botón para hacer el registro")
            .located(By.id("signin2"));
    public static final Target BTN_SIGN_IN = Target.the("Btón para abrir el modal LogIn")
            .located(By.id("login2"));

    public static final Target USERNAME_WELCOME_MESSAGE = Target.the("Mensaje de bienvenida para el usuario")
            .located(By.id("nameofuser"));
    public static final Target LNK_CART = Target.the("Menú item para ver el carrito de compras")
            .located(By.id("cartur"));
}

