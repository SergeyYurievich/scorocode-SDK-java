package ru.scorocode.android.api.request;

import ru.scorocode.android.model.Query;

public class CountRequestEntity extends BaseRequestEntity {

    private String coll;
    private Query query;

    public CountRequestEntity(String coll, Query query) {
        this.coll = coll;
        this.query = query;
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
