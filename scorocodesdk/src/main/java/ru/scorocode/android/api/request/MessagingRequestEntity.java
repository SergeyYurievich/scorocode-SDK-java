package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Message;

public class MessagingRequestEntity extends BaseRequestEntity {

    private String sess;
    private String acc;
    private Message msg;

    public MessagingRequestEntity(String sess, String acc, Message msg) {
        this.sess = sess;
        this.acc = acc;
        this.msg = msg;
    }

    public String getSess() {
        return sess;
    }

    public void setSess(String sess) {
        this.sess = sess;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
}
