package com.github.qbek.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class UserActions {

    @Steps
    BrowserActions browser;

    private String something = "costam";

    @Step("User opens app")
    public void openApplication(String url) {
        browser.openBrowser();
        browser.gotoAppPage();
        System.out.println("User gotes to " + url);
    }

    @Step("User enter login: {0}")
    public void userEntersLogin(String login) {
        System.out.println("User enters login " + login);
    }

    @Step("User enters password: {0}")
    public void userEntersPassword(String password) {
        System.out.println("User enters login " + password);
    }
}
