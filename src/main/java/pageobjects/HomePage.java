package pageobjects;

import org.openqa.selenium.By;

import static driver.DriverMethods.*;

public class HomePage {
    private final By advertisement = By.id("cboxClose");

    public void goToElvire() {
        navigate("http://elvira.hu");
        clickElement(advertisement);
    }
}
