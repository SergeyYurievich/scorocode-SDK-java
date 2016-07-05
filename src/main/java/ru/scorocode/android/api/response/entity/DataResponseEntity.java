package ru.scorocode.android.api.response.entity;

public class DataResponseEntity {

    private String _id;
    private String createdAt;
    private String updatedAt;
    private String[] readACL;
    private String[] removeACL;
    private String[] updateACL;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String[] getReadACL() {
        return readACL;
    }

    public void setReadACL(String[] readACL) {
        this.readACL = readACL;
    }

    public String[] getRemoveACL() {
        return removeACL;
    }

    public void setRemoveACL(String[] removeACL) {
        this.removeACL = removeACL;
    }

    public String[] getUpdateACL() {
        return updateACL;
    }

    public void setUpdateACL(String[] updateACL) {
        this.updateACL = updateACL;
    }

}
