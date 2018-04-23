package pageobjects;

import driver.DriverWaits;
import org.openqa.selenium.By;

import static driver.DriverMethods.*;

public class HomePage {
    private final By advertisement = By.id("cboxOverlay");
    private final By advertisementClose = By.id("cboxClose");

    public void goToElvire() {
        navigate("http://elvira.hu");
    }

    public void closeAdvertisement(){
        clickElement(advertisementClose);
        DriverWaits.waitForElementToDisappear(advertisement);
    }

    public boolean isAdvertisementDisplayed(){
        return isDisplayed(advertisement);
    }
}
