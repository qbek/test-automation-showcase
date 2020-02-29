package com.github.qbek.baselinetesting;

import com.github.qbek.baselinetesting.testobjects.UserDetails;
import com.sun.java.swing.plaf.windows.WindowsPopupMenuSeparatorUI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TddTest {

    @Test
    public void userDetails() throws JSONException {

        Response resp = RestAssured.given()
                .baseUri("http://localhost:8888")
                .log().all()
                .when().get("/user");
        resp.then().log().all();
        String returnBody = resp.getBody().asString();
        JSONObject json = new JSONObject(returnBody);
        assertTrue("User should have name", json.getString("name").equals("Jakub"));
        assertTrue("User sholud have nickname", json.getString("nickname").equals("Kuba"));
    }

    @Test
    public void userSecretDetails() throws JSONException {

        Response resp = RestAssured.given()
                .baseUri("http://localhost:8888")
                .log().all()
                .when().get("/secret");

        resp.then().log().all();
        String returnBody = resp.getBody().asString();
        JSONObject json = new JSONObject(returnBody);

        assertTrue("User should have name", json.getString("name").equals("Jakub"));
        assertTrue("User sholud have nickname", json.getString("nickname").equals("Kuba"));
        assertTrue("User sholud have surename", json.getString("surename").equals("Szewczyk"));
        assertTrue("User sholud have PESEL", json.getString("PESEL").equals("1223412341"));
    }

}
