package pageobjects;

import org.openqa.selenium.By;
import static driver.DriverMethods.*;

public class SearchResults {
    private final By searchContainer = By.id("timetable");

    public boolean areSearchResultsShown(){
        return isDisplayed(searchContainer);
    }
}
