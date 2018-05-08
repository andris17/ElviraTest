package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;
import pageobjects.OrderPage;

public class Hooks {
    @Before
    public void beforeScenario() {
        DriverManager.deleteAllCookies();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
        }
        OrderPage orderPage = new OrderPage();
        orderPage.logout();
    }
}
