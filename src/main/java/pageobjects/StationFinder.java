package pageobjects;

import static driver.DriverMethods.*;
import static driver.DriverManager.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StationFinder {

    private final By stationResults = By.xpath("//div[@class='view-content']//h3[@class='field-content']");
    private final By searchField = By.id("edit-title");
    private final By searchButton = By.id("edit-submit-ticket-office-station-search");

    public int getNumberOfResults() {
        return getElements(stationResults).size();
    }

    public void search(String searchCriteria){
        setText(searchField, searchCriteria);
        clickElement(searchButton);
    }

    public List<String> getResults() {
        List<String> returnList = new ArrayList<>();
        List<WebElement> actualList = getElements(stationResults);

        actualList
                .stream()
                .forEach(e -> returnList.add(e.getText()));

        return returnList;
    }
}
