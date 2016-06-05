package ru.scorocode.android.api.request;

public class StatRequestEntity extends BaseRequestEntity {

    private String acc;

    public StatRequestEntity(String acc) {
        this.acc = acc;
    }


    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
}
