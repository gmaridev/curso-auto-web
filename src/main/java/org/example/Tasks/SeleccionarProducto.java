package org.example.Tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.example.Pages.HomePage;
import org.example.Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SeleccionarProducto implements Task {

    @Override
    public <T extends Actor> void performAs (T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//*[@class='hrefch']")));
        List<WebElementFacade> listaProductos = ProductPage.CRD_PRODUCTOS.resolveAllFor(actor);
        if (listaProductos.isEmpty()) {
            throw new IllegalStateException("No hay productos disponibles en la tienda.");
        }
        Random random = new Random();
        int prodAleatorio = random.nextInt(listaProductos.size());
        WebElementFacade productoSeleccionado = listaProductos.get(prodAleatorio);

        String nombreProducto = productoSeleccionado.getText().trim();
        actor.remember("productoSeleccionado", nombreProducto);

        wait.until(ExpectedConditions.elementToBeClickable(productoSeleccionado));
        productoSeleccionado.click();
    }


    public static Performable seleccionarProductoTienda() {
        return Tasks.instrumented(SeleccionarProducto.class);
    }
}
