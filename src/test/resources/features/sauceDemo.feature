Feature: Calculator verification

  @calculator
  Scenario: Total Area and Wastage verification
    When User is on main page of GoodCalculators.com
    Then User should fill empty field with numbers
    And  User should verify expected result matches with real result