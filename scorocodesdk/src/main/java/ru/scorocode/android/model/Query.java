package ru.scorocode.android.model;

import org.json.JSONObject;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.response.entity.UpdateDataResponseEntity;
import ru.scorocode.android.manager.DataManager;

public class Query {

    private int limit;
    private int skip;
    private JSONObject options;
    private String ascending;
    private String descending;
    private String[] fields;

    public Query(String name) {
        this.options = new JSONObject();
    }

    public void find(SCCallback<String> callback, String sess, String coll) {
        DataManager dataManager = new DataManager();
        dataManager.find(callback, sess, coll, this);
    }

    public void count(SCCallback<Integer> callback, String sess, String coll) {
        DataManager dataManager = new DataManager();
        dataManager.count(callback, sess, coll, this);
    }

    public void update(SCCallback<UpdateDataResponseEntity> callback, String sess, String acc, String coll, Object doc) {
        DataManager dataManager = new DataManager();
        dataManager.update(callback, sess, acc, coll, this, doc, this.limit);
    }

    public void remove(SCCallback<UpdateDataResponseEntity> callback, String sess, String coll) {
        DataManager dataManager = new DataManager();
        dataManager.remove(callback, sess, coll, this);
    }

    public void limit(int limit) {
        this.limit = limit;
    }

    public void skip(int skip) {
        this.skip = skip;
    }

    public int page(int pageNumber) {
        return limit - pageNumber; // TODO check logic
    }

    public void equalTo(String name, String value) {
    }

    public void notEqualTo(String name, String value) {
    }

    public void containedIn(String name, String value) {
    }

    public void containsAll(String name, String value) {
    }

    public void notContainedIn(String name, String value) {
    }

    public void greaterThan(String name, String value) {
    }

    public void greaterThenOrEqualTo(String name, String value) {
    }

    public void lessThan(String name, String value) {
    }

    public void lessThanOrEqualTo(String name, String value) {
    }

    public void exists(String name, String value) {
    }

    public void doesNotExist(String name, String value) {
    }

    public void contains(String name, String value) {
    }

    public void startsWith(String name, String value) {
    }

    public void endsWith(String name, String value) {
    }

    public void or(String name, String value) {
    }

    public void and(String name, String value) {
    }

    public void raw(JSONObject options) {
        this.options = options;
    }

    public void reset() {
        this.limit = 0;
        this.skip = 0;
        this.options = new JSONObject();
    }

    public void ascending(String asc) {
        this.ascending = asc;
    }

    public void descending(String dsc) {
        this.descending = dsc;
    }

    public void fields(String[] fields) {
        this.fields = fields;
    }

}
