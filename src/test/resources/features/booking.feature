Feature: Booking cucumber

  As a user,
  I want to test the CRUD operations for the booking system.

  @smoke
  Scenario Outline: Verify CRUD operations for booking
    Given I am on Home Page
    When I create a new booking with firstname "<firstname>" lastname "<lastname>" totalprice "<totalprice>" depositpaid "<depositpaid>" checkin "<checkin>" checkout "<checkout>" additionalNeeds "<additionalNeeds>"
    Then I verify that the booking with firstname "<firstname>" is created successfully
    And I update the booking with firstname "<firstname>" lastname "<lastname>" totalprice "<totalprice>" depositpaid "<depositpaid>" checkin "<checkin>" checkout "<checkout>", additionalNeeds "<additionalNeeds>"
    Then I verify that the booking with firstname "<firstname>" is updated successfully
    And I delete the booking with firstname "<firstname>"
    Then The booking is deleted successfully from the API

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalNeeds |
      | Test     | Test     | 200        | true        | 2025-01-25 | 2025-01-30 | Breakfast       |
      | Test1     | Testing  | 250        | true       | 2025-04-08 | 2025-02-22 | Lunch          |