package com.github;

import static org.junit.Assert.assertTrue;

import com.github.data.User;
import com.github.steps.PreconditionSteps;
import com.github.steps.SingInSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.openqa.selenium.WebDriver;

/**
 * Unit test for simple App.
 */
@RunWith(SerenityRunner.class)
public class AppTest 
{
    @Managed
    WebDriver driver;

    @Steps
    SingInSteps steps;

    @Steps
    PreconditionSteps preconditions;

    @Test
    public void userCanSingIn() {
        User myUser = preconditions.thereIsAUserInSystem("myLogin", "myPassword");
        steps.openPage();
        steps.enterCredentials(myUser.getLogin(), myUser.getPassword());
        steps.verifyResults();
    }
}
