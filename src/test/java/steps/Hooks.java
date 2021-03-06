package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;
import driver.DriverMethods;
import pageobjects.OrderPage;

public class Hooks {
    @Before
    public void beforeScenario() {
        DriverManager.deleteAllCookies();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {try {
            scenario.embed(DriverMethods.takeScreenShot(),"image/png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        OrderPage orderPage = new OrderPage();
        if (orderPage.isLogoutAvailable()) {
            orderPage.logout();
        }
    }
}
