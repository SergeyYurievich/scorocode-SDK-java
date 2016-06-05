package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Query;

public class FindRequestEntity extends BaseRequestEntity {

    private String sess;
    private String coll;
    private Query query;
    private String[] fields;
    private String[] sort;
    private int limit;
    private int skip;

    public FindRequestEntity(String sess, String coll, Query query) {
        this.sess = sess;
        this.coll = coll;
        this.query = query;
    }

    public FindRequestEntity(String sess, String coll, Query query, String[] fields, String[] sort, int limit, int skip) {
        this.sess = sess;
        this.coll = coll;
        this.query = query;
        this.fields = fields;
        this.sort = sort;
        this.limit = limit;
        this.skip = skip;
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

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
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
}
