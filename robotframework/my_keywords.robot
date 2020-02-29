*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${FIRSTNAME-CHECK} =    css:#firstname-check

*** Keywords ***
Start test application
    Open browser    https://qbek.github.io/selenium-exercises/basic_form.html    ${BROWSER}   remote_url=http://localhost:4444/wd/hub

Fill user form
    Input text   css:#firstname    Jakub
    Input text   css:#lastname    Szewczyk
    Input text   css:#email     wp@wp.pl
    Capture Page Screenshot

Submit form
    Click element    css:[type="submit"]
    Wait Until Element Is Visible    ${FIRSTNAME-CHECK}

Perform asserts
    Capture Page Screenshot
    Element Text Should Be    ${FIRSTNAME-CHECK}    Kuba


Close application
    Capture Page Screenshot
    Close browser