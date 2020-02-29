package com.github.qbek.steps;

import net.thucydides.core.annotations.Step;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class MockPupetter {

    private MockServerClient client = new MockServerClient("localhost", 8888);

    @Step("Injecting user to auth server: {0} : {1}")
    public void injectUser(String username, String password) {
        String expectedBody = String.format("%s:%s", username, password);
        client.when(
                HttpRequest.request().withPath("/sign").withBody(expectedBody),
                Times.exactly(1)
        ).respond(
                HttpResponse.response()
                        .withStatusCode(200)
                        .withHeader("Access-Control-Allow-Origin", "*")


        );
    }
}
