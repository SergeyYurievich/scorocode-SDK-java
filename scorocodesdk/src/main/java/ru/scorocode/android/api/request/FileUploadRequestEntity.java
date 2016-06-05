package ru.scorocode.android.api.request;

public class FileUploadRequestEntity extends BaseRequestEntity {

    private String acc;
    private String sess;
    private String coll;
    private String docId;
    private String field;
    private String content;

    public FileUploadRequestEntity(String acc, String sess, String coll, String doc, String field, String content) {
        this.acc = acc;
        this.sess = sess;
        this.coll = coll;
        this.docId = doc;
        this.field = field;
        this.content = content;
    }

    public String getSess() {
        return sess;
    }

    public void setSess(String sess) {
        this.sess = sess;
    }

    public String getColl() {
        return coll;
    }

    public void setColl(String coll) {
        this.coll = coll;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String doc) {
        this.docId = doc;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
