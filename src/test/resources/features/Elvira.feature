Feature: Elvira Search

  @Search
  Scenario: Search a normal ticket
    Given I open Elvira
    When I search for a Teljesárú menetdíj ticket from Budapest to Szeged on 12 of 05
    Then the search results are shown

  @Advertisement
  Scenario: Advertisement works as expected
    Given I navigate to Elvira
    Then the advertisement is shown
    When I close the advertisement
    Then the advertisement is not shown