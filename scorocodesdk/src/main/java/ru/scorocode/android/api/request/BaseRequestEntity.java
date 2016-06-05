package ru.scorocode.android.api.request;

public class BaseRequestEntity {

    private String app;
    private String cli;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }
}
