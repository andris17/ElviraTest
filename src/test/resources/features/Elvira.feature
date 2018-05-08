Feature: Elvira Search

  @Search
  Scenario Outline: Search a normal ticket
    Given I open Elvira
    When I search for a <ticket_type> ticket from Budapest to Szeged on 17 of 05
    Then the search results are shown
    And the ticket type is <ticket_type> on the search results page
    And the info panel is not open for the 1. result
    When I open the info panel of the 1. result
    Then the info panel is open for the 1. result
    When I book the 22. ticket
    And I log in with email andrisregek@gmail.com and password lvirA.11
    Then the ticket type is <ticket_type> on the order page
    And I order the ticket
    Then I see the details of the trip as:
      | from | Budapest-Nyugati |
      | to   | Szeged           |
      | date | 2018.05.17       |
    Examples:
      | ticket_type              |
      | Teljesárú menetdíj       |
      | Természetjáró kedvezmény |


  @Advertisement
  Scenario: Advertisement works as expected
    Given I navigate to Elvira
    Then the advertisement is shown
    When I close the advertisement
    Then the advertisement is not shown

  @Stations
  Scenario Outline: Search train stations
    Given I open Elvira
    When I go to the station finder page
    And I search for a station with criteria <search_criteria>
    Then all the station results contain the search criteria <search_criteria>
    Examples:
      | search_criteria |
      | Szeged          |
      | Budapest        |

  @Stations @Negative
  Scenario Outline: Search train stations abroad
    Given I open Elvira
    When I go to the station finder page
    And I search for a station with criteria <search_criteria>
    Then the station result list has 0 elements
    Examples:
      | search_criteria |
      | Zurich          |
      | New York        |