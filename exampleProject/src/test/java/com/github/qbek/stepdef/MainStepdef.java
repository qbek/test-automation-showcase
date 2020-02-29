package com.github.qbek.stepdef;

import com.github.qbek.steps.UserActions;
import com.github.qbek.transforms.UserTransform;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.User;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class MainStepdef {

    @Steps(shared = true)
    UserActions actions;


    @Given("^User opens \"([^\"]*)\"$")
    public void user_opens(String url) {
        actions.openApplication(url);
    }


    @And("^User enters \"([^\"]*)\" as login$")
    public void userEntersAsLogin(String login) throws Throwable {
        actions.userEntersLogin(login);

    }


    @And("^User enters \"([^\"]*)\" as password$")
    public void userEntersAsPassword(String password) throws Throwable {
        actions.userEntersPassword(password);
    }

    @When("^User clicks submit button$")
    public void userClicksSubmitButton() {
        System.out.println("User clicks button");
    }

    @Then("^User is logged in$")
    public void userIsLoggedIn() {
        System.out.println("User is logged in");
    }

    @And("^\"([^\"]*)\" is display as user name$")
    public void isDisplayAsUserName(String username) throws Throwable {
        System.out.println("User displayed name is " + username);

        if (username.equals("Jakub")) {
            Assert.assertTrue(false);
        }
    }

    @Given("^Admin go to page \"([^\"]*)\"$")
    public void adminGoToPage(String arg0) throws Throwable {
        Integer.getInteger("3");
    }

    @Given("^this is integer (\\d+)$")
    public void thisIsInteger(int arg0) {
    }


    @And("^this is a float \"([^\"]*)\"$")
    public void thisIsAFloat(boolean bool) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^(User|Admin|Moderator) enters his as login$")
    public void userEntersHisAsLogin(
            @Transform(UserTransform.class) User myUser
    )
    {
        String log = String.format("User details %s:%s", myUser.login, myUser.password);
        System.out.println(log);
    }
}
