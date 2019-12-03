package com.github.qbek.testdata;

import net.thucydides.core.annotations.Step;

public class SingIn {

    private SingInPage page;

    @Step
    public void open() {
        page.open();
    }

    @Step
    public void singIn() {
        page.singIn();
    }

    @Step
    public void enterUsername(String test) {
        page.enterUsername(test);
    }

    @Step
    public void enterPassword(String pass) {
        page.enterPassword(pass);
    }
}
