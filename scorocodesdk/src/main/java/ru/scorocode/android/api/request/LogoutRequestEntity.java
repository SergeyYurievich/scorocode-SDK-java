package ru.scorocode.android.api.request;

public class LogoutRequestEntity extends BaseRequestEntity {

    private String sess;

    public LogoutRequestEntity(String sess) {
        this.sess = sess;
    }

    public String getSess() {
        return sess;
    }

    public void setSess(String sess) {
        this.sess = sess;
    }

}
