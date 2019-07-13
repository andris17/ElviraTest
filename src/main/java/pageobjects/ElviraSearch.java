package pageobjects;


import static driver.DriverMethods.*;

import driver.DriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.Set;

public class ElviraSearch {
    private final By fromField = By.id("from_station");
    private final By toField = By.id("to_station");
    private final By dateField = By.id("d");
    private final By typeDropDown = By.id("u");
    private final By searchButton = By.id("go");
    private final By datePickerContainer = By.id("ui-datepicker-div");
    private final By nextMonthButton = By.xpath("//div[@id='ui-datepicker-div']//a[@data-handler='next']");
    private final By prevMonthButton = By.xpath("//div[@id='ui-datepicker-div']//a[@data-handler='prev']");
    private final By currentMonthDay = By.xpath("//div[@id='ui-datepicker-div']//td[@data-handler='selectDay']");

    public void setFrom(String inputText) {
        clearAndSetText(fromField, inputText);
    }

    public void setTo(String inputText) {
        clearAndSetText(toField, inputText);
    }

    public void setDate(int month, int day) {
        clickElement(dateField);
        if (month > currentMonth() + 1) {
            do {
                clickElement(nextMonthButton);
            } while (month == currentMonth());
        }

        clickElement(By.xpath(String.format("//div[@id='ui-datepicker-div']//td[@data-handler='selectDay']/a[text()='%s']", day)));
        DriverWaits.waitForElementToDisappear(datePickerContainer);
    }

    public void selectType(String type) {
        selectItemFromDropdown(typeDropDown, type);
    }

    public void search() {
        Set<String> oldTitles = getTabs();
        clickElement(searchButton);
        Set<String> newTitles = getTabs();

        switchToTab(getNewestWindowTitle(oldTitles, newTitles));
    }

    private int currentMonth() {
        return Integer.parseInt(getAttribute(currentMonthDay, "data-month"));
    }
}




