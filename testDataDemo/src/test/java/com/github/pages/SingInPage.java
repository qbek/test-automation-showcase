package com.github.pages;

import com.github.SignInInteface;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://localhost:3000/")
public class SingInPage extends PageObject {

    private final static String loginInput = "[testid=\"login\"]";
    private final static String passwordInput = "[testid=\"password\"]";
    private final static String singInButton = "[testid=\"singInButton\"]";


    public void openAnotherWay() {
        getDriver().get("http://localhost:3000/");
    }

    public void enterLogin(String login) {
        element(By.cssSelector(loginInput)).type(login);
    }

    public void enterPassword(String password) {
        element(By.cssSelector(passwordInput)).type(password);
    }

    public void clickSingIn() {
        element(By.cssSelector(singInButton)).click();
    }
}
