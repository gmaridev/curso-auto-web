package org.example.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.Pages.HomePage;
import org.example.Pages.MenuBarPage;

public class RegistrarUsuario implements Task {
    private final String username;
    private final String password;

    public RegistrarUsuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                //Abre el modal
                Click.on(MenuBarPage.BTN_SIGN_UP),
                Enter.theValue(username).into(HomePage.REGISTER),
                Enter.theValue(password).into(HomePage.PASS_WORD),

                // Hace clic en el botón verde "Sign up" para enviar los datos
                Click.on(HomePage.BTN_REGISTER)

        );

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {     e.printStackTrace(); }
    }
    public static Performable withData(String username, String password) {
        return new RegistrarUsuario(username,password);
    }
}

