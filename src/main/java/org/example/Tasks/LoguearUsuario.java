package org.example.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.Pages.LogInPage;
import org.example.Pages.MenuBarPage;

public class LoguearUsuario implements Task {
    private final String username;
    private final String password;

    public LoguearUsuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor > void performAs(T actor) {
        actor.attemptsTo(
                //abrir el modal "Log In"
                Click.on(MenuBarPage.BTN_SIGN_IN),
                //Registrar credenciales válidas
                Enter.theValue(username).into(LogInPage.INPUT_USERNAME),
                Enter.theValue(password).into(LogInPage.INPUT_PASSWORD),

                //Finalizar el logueo
                Click.on(LogInPage.BTN_CONFIRMAR_LOGIN)
        );
    }

    public static Performable withData(String username, String password) {
         return Tasks.instrumented(LoguearUsuario.class, username,password);
    }
 }
