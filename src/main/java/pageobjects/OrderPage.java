package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static driver.DriverMethods.*;

public class OrderPage {
    private final By orderContainer = By.id("utazas");
    private final ByChained orderButton = new ByChained(orderContainer, By.xpath(".//input[@type='submit']"));
    private final By cartContent = By.xpath("//div[@class='navigation']//div[@class='boxbody']");
    private final By tripDetailsButton = By.xpath("//div[@id='e0']/a");
    private final By tripDetails = By.id("e1");
    private final By ticketDetailsButton = By.xpath("//div[@id='e2']/a");
    private final By ticketDetails = By.id("e3");
    private final ByChained fromStation = new ByChained(tripDetails, By.xpath(".//tr[1]/td[2]"));
    private final ByChained toStation = new ByChained(tripDetails, By.xpath(".//tr[2]/td[2]"));
    private final ByChained date = new ByChained(tripDetails, By.xpath(".//tr[3]/td[2]"));
    private final By logout = By.xpath("//form[@id='kijelentkezes']/input[@type='submit']");

    public void orderTicket() {
        clickElement(orderButton);
    }

    public void openTripDetails() {
        clickElement(tripDetailsButton);
    }

    public void openTicketDetails() {
        clickElement(ticketDetailsButton);
    }

    public String getFromStation(){
        return getText(fromStation);
    }

    public String getToStation(){
        return getText(toStation);
    }

    public String getDate(){
        return getText(date);
    }

    public void logout(){
        clickElement(logout);
    }
}
