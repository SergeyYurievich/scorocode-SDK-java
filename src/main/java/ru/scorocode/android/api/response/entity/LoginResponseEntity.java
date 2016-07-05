package ru.scorocode.android.api.response.entity;

import ru.scorocode.android.api.request.RegistrationRequestEntity;

public class LoginResponseEntity {

    private String sessionId;
    private RegistrationRequestEntity user;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public RegistrationRequestEntity getUser() {
        return user;
    }

    public void setUser(RegistrationRequestEntity user) {
        this.user = user;
    }
}
