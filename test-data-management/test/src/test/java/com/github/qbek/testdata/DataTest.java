package com.github.qbek.testdata;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.openqa.selenium.WebDriver;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * Unit test for simple App.
 */
@RunWith(SerenityRunner.class)
public class DataTest {


    private MockServerClient mockServerClient = new MockServerClient("localhost", 8888);

    @Managed
    WebDriver driver;

    @Steps
    SingIn singIn;


    @Before
    public void setup() throws JSONException {
        mockServerClient.reset();
    }

    @Test
    public void configure() {
        mockServerClient.when(request("/sign")).respond(response().withHeader("Access-Control-Allow-Origin", "*").withStatusCode(201));
        singIn.open();
        singIn.enterUsername("test");
        singIn.enterPassword("pass");
        singIn.singIn();
    }
}
