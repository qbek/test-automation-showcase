package com.github.qbek.testdata;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

@DefaultUrl("http://localhost:3000")
public class SingInPage extends PageObject {


    public void enterUsername(String username) {
        element(By.cssSelector("#login")).type(username);
    }

    public void enterPassword(String pass) {
        element(By.cssSelector("#password")).type(pass);
    }

    public void singIn() {
        element(By.cssSelector(".btn")).click();
    }
}
