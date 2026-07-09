package org.example.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.MenuBarPage;
import org.example.Tasks.LoguearUsuario;
import org.example.Tasks.NavigateTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class LoginStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("el {actor} se encuentra en la pagina de inicio")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicio(Actor actor) {
        OnStage.setTheStage(new net.serenitybdd.screenplay.actors.OnlineCast());
        OnStage.theActorCalled(actor.getName()).attemptsTo(
                NavigateTo.theHomePage()
        );
    }

    @When("ingresa su nombre de usuario {string} y contrasenia {string}")
    public void ingresaSuNombreDeUsuarioYContrasenia(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(LoguearUsuario.withData(username,password));
    }

    @Then("visualiza un mensaje de bienvenida para el usuario {string} en el menu")
    public void visualizaUnMensajeDeBienvenidaParaElUsuarioEnElMenu(String username) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MenuBarPage.USERNAME_WELCOME_MESSAGE,
                        WebElementStateMatchers.containsText("Welcome " + username)).forNoMoreThan(5).seconds()
        );
        theActorInTheSpotlight().should(net.serenitybdd.screenplay.GivenWhenThen.seeThat(
                net.serenitybdd.screenplay.questions.Text.of(MenuBarPage.USERNAME_WELCOME_MESSAGE),
                org.hamcrest.Matchers.containsString("Welcome " + username)
        ));

    }
}
