package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Object;

public class InsertFileRequestEntity extends BaseRequestEntity {

    private String coll;
    private Object doc;

    public InsertFileRequestEntity(String coll, Object doc) {
        this.coll = coll;
        this.doc = doc;
    }

    public String getColl() {
        return coll;
    }

    public void setColl(String coll) {
        this.coll = coll;
    }

    public Object getDoc() {
        return doc;
    }

    public void setMsg(Object doc) {
        this.doc = doc;
    }
}
