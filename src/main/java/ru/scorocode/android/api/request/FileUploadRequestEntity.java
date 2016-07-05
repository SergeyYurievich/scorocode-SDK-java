package ru.scorocode.android.api.request;

public class FileUploadRequestEntity extends BaseRequestEntity {

    private String coll;
    private String docId;
    private String field;
    private String content;
    private String fileName;

    public FileUploadRequestEntity(String coll, String fileName, String doc, String field, String content) {
        this.coll = coll;
        this.fileName = fileName;
        this.docId = doc;
        this.field = field;
        this.content = content;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
