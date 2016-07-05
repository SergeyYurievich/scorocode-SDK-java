package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Object;

public class UpdateFileRequestEntity extends BaseRequestEntity {

    private String coll;
    private String _id;
    private Object doc;

    public UpdateFileRequestEntity(String coll, Object doc, String id) {
        this.coll = coll;
        this._id = id;
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

    public void setDoc(Object doc) {
        this.doc = doc;
    }

    public String getId() {
        return _id;
    }

    public void seId(String _id) {
        this._id = _id;
    }
}
