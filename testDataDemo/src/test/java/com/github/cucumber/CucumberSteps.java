package com.github.cucumber;

import com.github.ExecuteCucumberTest;
import com.github.data.User;
import com.github.steps.PreconditionSteps;
import com.github.steps.SingInSteps;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

public class CucumberSteps {

    @Managed
    WebDriver driver;

    @Steps
    SingInSteps steps;

    @Steps
    PreconditionSteps preconditions;

    private User myUser;


    @When("^(\\w+) has active account$")
    public void user_has_active_account(
            @Transform(ExampleTransform.class) Example test
    ) {
        myUser = preconditions.thereIsAUserInSystem("myLogin", "myPassword");
    }

    @Given("^user opens login page$")
    public void user_opens_login_page() {
        steps.openPage();
    }

    @When("^he enters valid credentials$")
    public void he_enters_valid_credentials() {
        steps.enterCredentials(myUser.getLogin(), myUser.getPassword());
    }

    @Then("^he is logged in$")
    public void he_is_logged_in() {
        steps.verifyResults();
    }
}
