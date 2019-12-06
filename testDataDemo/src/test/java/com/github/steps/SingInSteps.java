package com.github.steps;

import com.github.pages.SingInPage;
import net.thucydides.core.annotations.Step;

public class SingInSteps {

    private String test = "some string";

    private SingInPage page = new SingInPage();

    @Step("Open my super page: #test")
    public void openPage() {
        page.openAnotherWay();
    }

    @Step("Enter login: {0}, password: {1}")
    public void enterCredentials(String login, String password) {
        page.enterLogin(login);
        page.enterPassword(password);
        page.clickSingIn();
    }

    @Step
    public void verifyResults() {
    }
}
