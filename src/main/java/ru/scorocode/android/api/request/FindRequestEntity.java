package ru.scorocode.android.api.request;

public class FindRequestEntity extends BaseRequestEntity {

    private String coll;
    private String id;
    private String[] fields;
    private String[] sort;
    private int limit;
    private int skip;

    public FindRequestEntity(String coll, String id) {
        this.coll = coll;
        this.id = id;
    }

    public FindRequestEntity(String coll, String id, String[] fields, String[] sort, int limit, int skip) {
        this.coll = coll;
        this.id = id;
        this.fields = fields;
        this.sort = sort;
        this.limit = limit;
        this.skip = skip;
    }

    public String getColl() {
        return coll;
    }

    public void setColl(String coll) {
        this.coll = coll;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String[] getSort() {
        return sort;
    }

    public void setSort(String[] sort) {
        this.sort = sort;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
