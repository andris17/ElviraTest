package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.ElviraSearch;
import pageobjects.HomePage;
import pageobjects.SearchResults;

public class ElviraSteps {
    ElviraSearch searchDialog = null;
    HomePage homePage = null;
    SearchResults searchResults = null;

    public ElviraSteps() {
        searchDialog = new ElviraSearch();
        homePage = new HomePage();
        searchResults = new SearchResults();
    }

    @Given("I navigate to Elvira")
    public void goToElvira() {
        homePage.goToElvire();
    }

    @Given("I open Elvira")
    public void openToElvira() {
        homePage.goToElvire();
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
}