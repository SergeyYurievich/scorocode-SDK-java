package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Object;
import ru.scorocode.android.model.Query;

public class UpdateFileRequestEntity extends BaseRequestEntity {

    private String sess;
    private String acc;
    private String coll;
    private Query query;
    private Object doc;
    private int limit;

    public UpdateFileRequestEntity(String sess, String acc, String coll, Query query, Object doc, int limit) {
        this.sess = sess;
        this.acc = acc;
        this.coll = coll;
        this.query = query;
        this.doc = doc;
        this.limit = limit;
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

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Object getDoc() {
        return doc;
    }

    public void setDoc(Object doc) {
        this.doc = doc;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
