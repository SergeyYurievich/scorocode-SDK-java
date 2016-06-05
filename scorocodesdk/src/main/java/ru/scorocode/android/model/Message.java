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

    public void sendEmail(SCCallback<Boolean> callback, String sessionId, String accessKey) {
        MessagingManager messagingManager = new MessagingManager();
        messagingManager.send(callback, sessionId, accessKey, this, MessagingManager.MessageType.EMAIL);
    }

    public void sendPush(SCCallback<Boolean> callback, String sessionId, String accessKey) {
        MessagingManager messagingManager = new MessagingManager();
        messagingManager.send(callback, sessionId, accessKey, this, MessagingManager.MessageType.PUSH);
    }

    public void sendSms(SCCallback<Boolean> callback, String sessionId, String accessKey) {
        MessagingManager messagingManager = new MessagingManager();
        messagingManager.send(callback, sessionId, accessKey, this, MessagingManager.MessageType.SMS);
    }

}
