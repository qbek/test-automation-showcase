package com.github.rest;

import com.github.SingInInteface;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;

public class SignInRest implements SingInInteface {

    private String login;
    private String password;

    private Response response;


    @Override
    public void openAnotherWay() { }

    @Override
    public void enterLogin(String login) {
        this.login = login;
    }

    @Override
    public void enterPassword(String password) {
        this.password = password;
    }

    @Override
    public void clickSingIn() {
        String body = String.format("%s:%s", login, password);
        response =   SerenityRest.given()
                .baseUri("http://localhost:8888")
                .body(body)
                .log().all()
                .when().post();
    }

    @Override
    public void verifyResult() {
        response.then().assertThat().statusCode(230);
    }
}
