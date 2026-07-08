package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.Pages.HomePage;

public class NavigateTo {
    public static Performable theHomePage() {
        return Task.where("{0} opens the Home Page", Open.browserOn().the(HomePage.class));
    }
}
