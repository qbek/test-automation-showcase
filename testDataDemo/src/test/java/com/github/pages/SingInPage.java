package com.github.pages;

import com.github.SingInInteface;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://localhost:3000/")
public class SingInPage extends PageObject implements SingInInteface {

    private final static String loginInput = "[testid=\"login\"]";
    private final static String passwordInput = "[testid=\"password\"]";
    private final static String singInButton = "[testid=\"singInButton\"]";

    @Override
    public void openAnotherWay() {
        getDriver().get("http://localhost:3000/");
    }

    @Override
    public void enterLogin(String login) {
        element(By.cssSelector(loginInput)).type(login);
    }

    @Override
    public void enterPassword(String password) {
        element(By.cssSelector(passwordInput)).type(password);
    }

    @Override
    public void clickSingIn() {
        element(By.cssSelector(singInButton)).click();
    }

    @Override
    public void verifyResult() {

    }
}
