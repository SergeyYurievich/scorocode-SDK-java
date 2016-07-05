package ru.scorocode.android.model;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.manager.MessagingManager;

public class Message {

    private String from;
    private String subject;
    private String text;

    public Message(String from, String subject, String text) {
        this.from = from;
        this.subject = subject;
        this.text = text;
    }

    public void sendEmail(SCCallback<Boolean> callback, Query query) {
        MessagingManager messagingManager = new MessagingManager();
        messagingManager.send(callback, this, MessagingManager.MessageType.EMAIL, query);
    }

    public void sendPush(SCCallback<Boolean> callback, Query query) {
        MessagingManager messagingManager = new MessagingManager();
        messagingManager.send(callback, this, MessagingManager.MessageType.PUSH, query);
    }

    public void sendSms(SCCallback<Boolean> callback, Query query) {
        MessagingManager messagingManager = new MessagingManager();
        messagingManager.send(callback, this, MessagingManager.MessageType.SMS, query);
    }

}
