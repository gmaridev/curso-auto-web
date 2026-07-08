package org.example.stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.Pages.CartPage;
import org.example.Pages.ProductPage;
import org.example.Tasks.AgregarAlCarrito;
import org.example.Tasks.SeleccionarProducto;
import org.example.Tasks.VerCarrito;
import org.junit.Assert;

public class AgregarProductoStepDefinition {

    @When("selecciona un producto de la tienda")
    public void seleccionaUnProductoDeLaTienda() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarProducto.seleccionarProductoTienda()
        );
    }

    @Then("visualiza la informacion del producto")
    public void visualizaLaInformacionDelProducto() {
    String nombreEsperado = OnStage.theActorInTheSpotlight().recall("productoSeleccionado");
    String nombreObtenido = ProductPage.TITLE_PRODUCT.resolveFor(OnStage.theActorInTheSpotlight()).getText();
        Assert.assertEquals(nombreEsperado, nombreObtenido);
        //throw new PendingException();
    }

    @And("agrega el producto a su carrito de compras")
    public void agregaElProductoASuCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.agregarAlCarrito()
        );

    }

    @Then("se muestra el producto en la lista del carrito")
    public void seMuestraElProductoEnLaLista() {
        String nombreEsperado = OnStage.theActorInTheSpotlight().recall("productoSeleccionado");
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerCarrito.irAlCarrito()
        );
        boolean productoEncontrado = false;
        for (WebElementFacade elemento : CartPage.LBL_PRODUCTO_TABLA.resolveAllFor(OnStage.theActorInTheSpotlight())) {
            String nombreObtenido = elemento.getText().trim();
            if (nombreObtenido.contains(nombreEsperado)) {
                productoEncontrado = true;
                break;
            }
        }
        Assert.assertTrue(nombreEsperado,productoEncontrado);
    }
}
