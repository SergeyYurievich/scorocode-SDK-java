package ru.scorocode.android.model;

import org.json.JSONObject;

import java.util.Date;
import java.util.List;

import ru.scorocode.android.api.response.entity.UpdateDataResponseEntity;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.manager.DataManager;

public class Query<ValueType> {

    private String collection;
    private int limit;
    private int skip;
    private JSONObject options;
    private String ascending;
    private String descending;
    private String[] fields;

    public Query(String collection) {
        this.collection = collection;
        this.options = new JSONObject();
    }

    public void find(SCCallback<List<Object>> callback, String id) {
        DataManager dataManager = new DataManager();
        dataManager.find(callback, this.collection, id);
    }

    public void count(SCCallback<Integer> callback) {
        DataManager dataManager = new DataManager();
        dataManager.count(callback, this.collection, this);
    }

    public void update(SCCallback<UpdateDataResponseEntity> callback, Object doc, String id) {
        DataManager dataManager = new DataManager();
        dataManager.update(callback, this.collection, doc, id);
    }

    public void remove(SCCallback<UpdateDataResponseEntity> callback, String id) {
        DataManager dataManager = new DataManager();
        dataManager.remove(callback, this.collection, id);
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

    public void equalTo(String name, ValueType value) {
    }

    public void notEqualTo(String name, ValueType value) {
    }

    public void containedIn(String name, List<ValueType> value) {
    }

    public void containsAll(String name, List<ValueType> value) {
    }

    public void notContainedIn(String name, List<ValueType> value) {
    }

    public void greaterThan(String name, Date value) {
    }

    public void greaterThenOrEqualTo(String name, Date value) {
    }

    public void lessThan(String name, Date value) {
    }

    public void lessThanOrEqualTo(String name, Date value) {
    }

    public void greaterThan(String name, Number value) {
    }

    public void greaterThenOrEqualTo(String name, Number value) {
    }

    public void lessThan(String name, Number value) {
    }

    public void lessThanOrEqualTo(String name, Number value) {
    }

    public void exists(String name) {
    }

    public void doesNotExist(String name) {
    }

    public void contains(String name, String value) {
    }

    public void startsWith(String name, String value) {
    }

    public void endsWith(String name, String value) {
    }

    public void or(Query query) {
    }

    public void and(Query query) {
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
