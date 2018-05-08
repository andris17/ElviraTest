package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static driver.DriverMethods.*;

public class SearchResults {
    private final By searchContainer = By.id("timetable");
    private final By ticketType = new ByChained(searchContainer, By.xpath(".//th[@class='t']"));


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

    public String getTicketType() {
        return getText(ticketType);
    }

    private By getBookButtonLocator(Integer rowNumber) {
        return By.xpath(String.format("//td[descendant::img[@id='binfo%s']]/following-sibling::td[descendant::input[@name='seb']]", rowNumber.toString()));
    }
}
