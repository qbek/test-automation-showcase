package com.github.data;

import com.github.javafaker.Faker;

public class User {

    private static Faker faker = new Faker();

    private String login;
    private String password;

    public User() {
        login = faker.dragonBall().character();
        password = faker.animal().name();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
