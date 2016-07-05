package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Message;
import ru.scorocode.android.model.Query;

public class MessagingRequestEntity extends BaseRequestEntity {

    private Message msg;
    private Query query;

    public MessagingRequestEntity(Message msg) {
        this.msg = msg;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
