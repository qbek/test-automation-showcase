*** Settings ***
Resource   my_keywords.robot
Test Teardown     Close application


*** Test Cases ***
From test
    Given Start test application
    And Fill user form
    When Submit form
    Then Perform asserts




