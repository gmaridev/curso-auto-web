package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {
    public static final Target CRD_PRODUCTOS = Target.the("Lista de productos de la tienda")
            .locatedBy("//*[@class='hrefch']");
    public  static final Target TITLE_PRODUCT = Target.the("Título del producto seleccionado")
            .locatedBy("//h2[@class='name']");
    public static final Target BTN_ADD_TO_CART = Target.the("Botón para agregar producto al carrito")
            .locatedBy("//a[contains(@onclick, 'addToCart')]");
}
