package pageobjects;

import org.openqa.selenium.By;
import static driver.DriverMethods.*;

public class SearchResults {
    private final By searchContainer = By.id("timetable");

    public boolean areSearchResultsShown() {
        return isDisplayed(searchContainer);
    }

    public void clickInfo(int number) {
        clickElement(By.xpath(String.format("//img[@id='binfo%s']", number)));
    }

    public boolean isInfoDisplayed(int number) {
        return isDisplayed(By.xpath(String.format("//div[@id='info%s']", number)));
    }

    public void bookTicket(Integer rowNumber) {
        clickElement(getBookButtonLocator(rowNumber));
    }

    private By getBookButtonLocator(Integer rowNumber) {
        return By.xpath(String.format("//td[descendant::img[@id='binfo%s']]/following-sibling::td[descendant::input[@name='seb']]", rowNumber.toString()));
    }
}
