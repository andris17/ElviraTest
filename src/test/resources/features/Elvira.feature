Feature: Elvira Search

  @Search
  Scenario: Search a normal ticket
    Given I navigate to Elvira
    When I search for a Teljesárú menetdíj ticket from Budapest to Szeged on 12 of 05
    Then the search results are shown