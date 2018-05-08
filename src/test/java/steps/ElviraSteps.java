package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverWaits;
import org.junit.Assert;
import pageobjects.*;

import java.util.List;
import java.util.Map;

public class ElviraSteps {
    ElviraSearch searchDialog = null;
    HomePage homePage = null;
    SearchResults searchResults = null;
    LoginForm loginForm = null;
    OrderPage orderPage = null;
    StationFinder stationFinder = null;

    public ElviraSteps() {
        searchDialog = new ElviraSearch();
        homePage = new HomePage();
        searchResults = new SearchResults();
        loginForm = new LoginForm();
        orderPage = new OrderPage();
        stationFinder = new StationFinder();
    }

    @Given("I navigate to Elvira")
    public void goToElvira() {
        homePage.goToElvira();
    }

    @Given("I open Elvira")
    public void openToElvira() {
        homePage.goToElvira();
        homePage.closeAdvertisement();
    }

    @Then("the advertisement (is|is not) shown")
    public void verifyAdvertisementShown(String expect) {
        if ("is".equals(expect)) {
            Assert.assertTrue("Advertisement is not shown, it should be!", homePage.isAdvertisementDisplayed());
        } else {
            Assert.assertFalse("Advertisement is shown, it should not be!", homePage.isAdvertisementDisplayed());
        }
    }

    @When("I close the advertisement")
    public void closeAdvertisement() {
        homePage.closeAdvertisement();
    }

    @When("I search for a (.*) ticket from (.*) to (.*) on (\\d+) of (\\d+)")
    public void searchTrain(String type, String from, String to, int day, int month) {
        searchDialog.setFrom(from);
        searchDialog.setTo(to);
        searchDialog.setDate(month, day);
        searchDialog.selectType(type);
        searchDialog.search();
    }

    @Then("the search results are shown")
    public void verifySearchResultsShown() {
        Assert.assertTrue("Search results are not shown, they should be!", searchResults.areSearchResultsShown());
    }

    @When("I open the info panel of the (\\d+). result")
    public void openDetails(int number) {
        searchResults.clickInfo(number);
    }

    @Then("the info panel (is|is not) open for the (\\d+). result")
    public void verifyDetailsOpen(String status, int number) {
        if ("is".equals(status)) {
            Assert.assertTrue("Info panel is not shown, it should be!", searchResults.isInfoDisplayed(number));
        } else {
            Assert.assertFalse("Info panel is shown, it should not be!", searchResults.isInfoDisplayed(number));
        }
    }

    @When("I change the language to (\\s\\s)")
    public void changeLanguage(String language) {
        homePage.switchLanguage(language);
    }

    @When("I book the (\\d+). ticket")
    public void bookTicket(Integer rowNumber) {
        searchResults.bookTicket(rowNumber);
    }

    @When("I log in with email (.*) and password (.*)")
    public void login(String email, String password) {
        loginForm.enterEmail(email);
        loginForm.enterPassword(password);
        loginForm.login();
    }

    @When("I order the ticket")
    public void orderTicket() {
        orderPage.orderTicket();
    }

    @Then("I see the details of the trip as:")
    public void verifyTripDetails(Map<String, String> details) {
        orderPage.openTripDetails();
        Assert.assertEquals("The origin station is not as expected!", orderPage.getFromStation(), details.get("from"));
        Assert.assertEquals("The destination station is not as expected!", orderPage.getToStation(), details.get("to"));
        Assert.assertEquals("The date is not as expected!", orderPage.getDate(), details.get("date"));
    }

    @Then("the ticket type is (.*) on the search results page")
    public void verifyTicketTypeSearchResults(String expectedType) {
        Assert.assertEquals("The ticket type is not as expected!", expectedType, searchResults.getTicketType());
    }

    @Then("the ticket type is (.*) on the order page")
    public void verifyTicketTypeOrderPage(String expectedType) {
        Assert.assertTrue("The ticket type is not as expected!", orderPage.getTicketTpye().contains(expectedType));
    }

    @Then("all the station results contain the search criteria (.*)")
    public void verifyStationSearchResults(String searchCriteria) {
        List<String> stationResults = stationFinder.getResults();

        stationResults
                .stream()
                .map(String::toLowerCase)
                .forEach(e -> Assert.assertTrue("Not all search result contains the search criteria!", e.contains(searchCriteria.toLowerCase())));
    }

    @Then("the station result list has (\\d+) elements")
    public void verifyStationResultsListCount(int expectedAmount) {
        Assert.assertEquals("The station results does not have the expected amount of elements!", expectedAmount, stationFinder.getNumberOfResults());
    }

    @When("I go to the station finder page")
    public void goToStationFinder() {
        homePage.clickStationFinder();
    }

    @When("I search for a station with criteria (.*)")
    public void searchStation(String searchCriteria) {
        stationFinder.search(searchCriteria);
    }

}