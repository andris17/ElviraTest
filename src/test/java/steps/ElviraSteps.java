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

    @When("I search for a (.*) ticket from (.*) to (.*) on (\\d+) of (\\d+)")
    public void searchTrain(String type, String from, String to, int day, int month) {
        searchDialog.setFrom(from);
        searchDialog.setTo(to);
        searchDialog.setDate(month, day);
        searchDialog.selectType(type);
        searchDialog.search();
    }

    @Then("the search results are shown")
    public void verifySearchResultsShown(){
        Assert.assertTrue("Search results are not shown, they should be!", searchResults.areSearchResultsShown());
    }
}