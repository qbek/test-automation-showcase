Feature: Cucumber Example

  Tutaj opisujemy detale ficzera
  i to moeze byc duzo linijek

  @backend
  Scenario: User can log in

    a to są
    detale scenariusza

    Given User opens "http://myloginpage.com"
    And User enters "myLogin" as login
    And User enters "myPassword" as password
    When User clicks submit button
    Then User is logged in
    And "Johny Rambo" is display as user name

    @frontend
  Scenario Outline: User can login multiple cases
    Given User opens "http://myloginpage.com"
    And User enters "<login>" as login
    And User enters "<password>" as password
      And user fils the form with <data>
    When User clicks submit button
    Then User is logged in
    And "<name>" is display as user name

    Examples:
      | login | password | name | data |
      | aaa   | bbb | Jakub | 1, dksgjf, 45235, 3232, 33443
      | bbb   | ccc | Stefan |

    @test
    Scenario: data examples
      And User enters his as login
      And Admin enters his as login
      And Moderator enters his as login
