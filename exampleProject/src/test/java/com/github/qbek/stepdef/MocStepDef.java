package com.github.qbek.stepdef;

import com.github.javafaker.Faker;
import com.github.qbek.steps.MockPupetter;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MocStepDef {

    @Steps
    MockPupetter mock;

    @Managed
    WebDriver driver;

    private String username;
    private String password;

    @Before
    public void testSetup() {
        Faker faker = new Faker();
        username = faker.name().firstName();
        password = faker.funnyName().name();
    }


    @Given("^Adam is a user$")
    public void adam_is_a_user() {
        mock.injectUser(username, password);
    }

    @And("^Adam opens the App$")
    public void adamOpensTheApp() {
        driver.get("http://localhost:3000");
    }

    @When("^Adam enters his credentials$")
    public void adam_enters_his_credentials() {
        driver.findElement(By.cssSelector("#login"))
                .sendKeys(username);
        driver.findElement(By.cssSelector("#password"))
                .sendKeys(password);
        driver.findElement(By.cssSelector("[testid=\"singInButton\"]"))
                .click();
    }

    @Then("^Adam is logged in$")
    public void adam_is_logged_in() {
    }


}
