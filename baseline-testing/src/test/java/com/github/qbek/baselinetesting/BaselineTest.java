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

    private static final String PUBLIC = "/user";
    private static final String PRIVATE = "/details";

    private MockServerClient mockServerClient = new MockServerClient("localhost", 8888);
    private Response response;

    @Before
    public void setup() throws JSONException {
        mockServerClient.reset();
        there_is_a_user_record_in_database();
    }


//    REQUIREMENTS:
//
//    REQ GET /user
//    RETURNS
//    {
//        "name": "...",
//        "nickname": "..."
//    }
    @Test
    public void get_user_public_data() throws Exception {
        request_user_data(PUBLIC);
        save_response_to_file("user_public_data");
    }

//    REQUIREMENTS:
//
//    REQ GET /details
//    RETURNS
//    {
//        "name": "...",
//        "nickname": "...",
//        "surname": "...",
//        "gender": "..."
//    }
    @Test
    public void get_user_private_data() throws Exception {
        request_user_data(PRIVATE);
        save_response_to_file("user_private_data");
    }


    private BaselineTest request_user_data(String path) {
        response = RestAssured.given()
                .baseUri("http://localhost:1888")
                .log().all()
                .when()
                .get(path);
        return this;
    }

    private void there_is_a_user_record_in_database() throws JSONException {
        JSONObject userData = new JSONObject();
        userData.put("name", "Jakub")
              .put("nickname", "qbek");
        setResponse(userData, PUBLIC);
        userData.put("surname", "Szewczyk");
        setResponse(userData, PRIVATE);
    }

    private void setResponse(JSONObject body, String path) {
        mockServerClient
            .when(
                request().withMethod("GET").withPath(path)
            )
            .respond(
                response().withStatusCode(200)
                    .withHeader("Content-type", "application/json")
                    .withBody(body.toString())
            );
    }

    private void save_response_to_file(String filename) throws Exception {
        String file = String.format("target/%s.json", filename);
        JSONObject json = new JSONObject(response.asString());
        FileUtils.writeStringToFile(new File(file), json.toString(4), forName("UTF-8"));
    }
}
