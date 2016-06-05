package ru.scorocode.android.model;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.response.entity.LoginResponseEntity;
import ru.scorocode.android.api.response.entity.RegistrationResponseEntity;
import ru.scorocode.android.manager.UserManager;

public class User extends Object {

    public User(String name) {
        super(name);
    }

    public void register(SCCallback<RegistrationResponseEntity> callback, String username, String email, String password) {
        UserManager userManager = new UserManager();
        userManager.signup(callback, username, email, password);
    }

    public void login(SCCallback<LoginResponseEntity> callback, String email, String password) {
        UserManager userManager = new UserManager();
        userManager.login(callback, email, password);
    }

    public void logout(SCCallback<Boolean> callback, String sessionId) {
        UserManager userManager = new UserManager();
        userManager.logout(callback, sessionId);
    }
}
