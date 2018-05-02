Feature: Elvira Search

  @Search
  Scenario: Search a normal ticket
    Given I open Elvira
    When I search for a Teljesárú menetdíj ticket from Budapest to Szeged on 17 of 05
    Then the search results are shown
    And the info panel is not open for the 1. result
    When I open the info panel of the 1. result
    Then the info panel is open for the 1. result
    When I book the 22. ticket
    And I log in with email andrisregek@gmail.com and password lvirA.11
    And I order the ticket
    Then I see the details of the trip as:
      | from | Budapest-Nyugati |
      | to   | Szeged           |
      | date | 2018.05.17       |

  @Advertisement
  Scenario: Advertisement works as expected
    Given I navigate to Elvira
    Then the advertisement is shown
    When I close the advertisement
    Then the advertisement is not shown