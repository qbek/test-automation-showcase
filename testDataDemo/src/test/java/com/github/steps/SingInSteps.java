package com.github.steps;

import com.github.SingInInteface;
import com.github.pages.SingInPage;
import com.github.rest.SignInRest;
import net.thucydides.core.annotations.Step;
import org.apache.xerces.util.SynchronizedSymbolTable;

public class SingInSteps {

    private String test = "some string";

    private SingInPage page = new SingInPage();

    private SingInInteface singIn = getSingInInterface();

    private SingInInteface getSingInInterface() {
        String type = System.getProperty("type", "gui");
        if (type.equals("rest")) {
            return new SignInRest();
        } else return page;
    }

    @Step("Open my super singIn: #test")
    public void openPage() {
        singIn.openAnotherWay();
    }

    @Step("Enter login: {0}, password: {1}")
    public void enterCredentials(String login, String password) {
        singIn.enterLogin(login);
        singIn.enterPassword(password);
        singIn.clickSingIn();
    }

    @Step
    public void verifyResults() {
        singIn.verifyResult();
    }
}
