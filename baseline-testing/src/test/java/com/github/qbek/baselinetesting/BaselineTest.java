package com.github.qbek.baselinetesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.io.File;

import static java.nio.charset.Charset.forName;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * Unit test for simple App.
 */
public class BaselineTest {

    private Response response;

    @Test
    public void userDetails() throws Exception {
        response = RestAssured.given()
                .baseUri("http://localhost:8888")
                .log().all()
                .when().get("/user");
        save_response_to_file("user_details");

    }

    @Test
    public void userSecretDetails() throws Exception {

        response = RestAssured.given()
                .baseUri("http://localhost:8888")
                .log().all()
                .when().get("/secret");
        save_response_to_file("user_sercret_details");
    }

    private void save_response_to_file(String filename) throws Exception {
        String file = String.format("target/%s.json", filename);
        JSONObject json = new JSONObject(response.asString());
        FileUtils.writeStringToFile(new File(file), json.toString(4), forName("UTF-8"));
    }
}
