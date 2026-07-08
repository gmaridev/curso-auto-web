package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;



public class CartPage extends PageObject {
    public static final Target LBL_PRODUCTO_TABLA = Target.the("Nombre del producto agregado")
            .locatedBy("//tbody[@id='tbodyid']/tr/td[2]");
}
