package pageobjects;

import driver.DriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static driver.DriverMethods.*;

public class HomePage {
    private final By advertisement = By.id("cboxOverlay");
    private final By advertisementClose = By.id("cboxClose");
    private final By languageSwitch = By.id("block-block-14");
    private final By stationFinderLink = By.xpath("//a[@href='/mav-start/belfoldi-utazas/allomaskereso']");

    public void goToElvira() {
        navigate("http://elvira.hu");
    }

    public void closeAdvertisement() {
        if (isDisplayed(advertisement)) {
            clickElement(advertisementClose);
            DriverWaits.waitForElementToDisappear(advertisement);
        }
    }

    public boolean isAdvertisementDisplayed() {
        return isDisplayed(advertisement);
    }

    public void switchLanguage(String language) {
        By languageLocator = null;
        switch (language) {
            case "EN": {
                languageLocator = By.xpath(".//li[contains(@class, 'en')]");
                break;
            }
            case "DE": {
                languageLocator = By.xpath(".//li[contains(@class, 'de')]");
                break;
            }
            default: {
                languageLocator = By.xpath(".//li[contains(@class, 'hu')]");
                break;
            }
        }

        clickElement(new ByChained(languageSwitch, languageLocator));
    }

    public void clickStationFinder(){
        clickElement(stationFinderLink);
    }
}
