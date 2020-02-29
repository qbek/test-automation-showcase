Feature: User can sign in

  @mock
  Scenario: Positive case

    Given Adam is a user
    And Adam opens the App
    When Adam enters his credentials
    Then Adam is logged in