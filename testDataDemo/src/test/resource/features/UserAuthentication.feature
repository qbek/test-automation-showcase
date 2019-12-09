Feature: User authentication

  Scenario: User can log in
    Given user has active account
    And user opens login page
    When he enters valid credentials
    Then he is logged in

