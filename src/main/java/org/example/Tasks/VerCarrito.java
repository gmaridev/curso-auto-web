package org.example.Tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.example.Pages.MenuBarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerCarrito implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        actor.attemptsTo(
                Click.on(MenuBarPage.LNK_CART)
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@id='tbodyid']/tr")));

    }
    public  static Performable irAlCarrito() {
        return Tasks.instrumented(VerCarrito.class);
    }
}
