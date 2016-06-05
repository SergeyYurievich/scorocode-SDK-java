package ru.scorocode.android.api.request;

public class GetFileLinkRequestEntity extends BaseRequestEntity {

    private String coll;
    private String field;
    private String file;

    public GetFileLinkRequestEntity(String coll, String field, String file) {
        this.coll = coll;
        this.field = field;
        this.file = file;
    }

    public String getColl() {
        return coll;
    }

    public void setColl(String coll) {
        this.coll = coll;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


}
