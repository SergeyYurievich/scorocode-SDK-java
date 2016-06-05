package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Query;

public class CountRequestEntity extends BaseRequestEntity {

    private String sess;
    private String coll;
    private Query query;

    public CountRequestEntity(String sess, String coll, Query query) {
        this.sess = sess;
        this.coll = coll;
        this.query = query;
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
}
