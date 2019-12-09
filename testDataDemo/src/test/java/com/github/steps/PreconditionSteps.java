package com.github.steps;

import com.github.data.User;
import net.thucydides.core.annotations.Step;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class PreconditionSteps {

    MockServerClient client = new MockServerClient("localhost", 8888);

    @Step
    public User thereIsAUserInSystem(String login, String password) {
        client.reset();
        User myUser = new User();
        String body = String.format("%s:%s", myUser.getLogin(), myUser.getPassword());
        client
            .when(
                request().withMethod("POST").withBody(body),
                Times.once())
            .respond(
                    response().withHeader("Access-Control-Allow-Origin", "*").withStatusCode(200));
        return myUser;
    }
}
