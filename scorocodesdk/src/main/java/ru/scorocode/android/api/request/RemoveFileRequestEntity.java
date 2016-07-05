package ru.scorocode.android.api.request;

public class RemoveFileRequestEntity extends BaseRequestEntity {

    private String coll;
    private String _id;

    public RemoveFileRequestEntity(String coll, String id) {
        this.coll = coll;
        this._id = id;
    }

    public String getColl() {
        return coll;
    }

    public void setColl(String coll) {
        this.coll = coll;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
