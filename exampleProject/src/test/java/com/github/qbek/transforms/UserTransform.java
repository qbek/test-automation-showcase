package com.github.qbek.transforms;

import cucumber.api.PendingException;
import cucumber.api.Transformer;
import data.User;

public class UserTransform extends Transformer<User> {
    @Override
    public User transform(String userName) {
        User myUser = new User();
        switch (userName) {
            case "User":
                myUser.login = "user";
                myUser.password = "userPass";
                break;
            case "Admin":
                myUser.login = "admin";
                myUser.password = "admPass";
                break;
            case "Moderator":
                myUser.login = "mod";
                myUser.password = "modPass";
                break;
            default:
                throw new PendingException("User type not supported");
        }
        return myUser;
    }
}
