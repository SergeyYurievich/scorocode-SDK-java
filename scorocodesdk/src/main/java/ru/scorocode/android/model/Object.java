package ru.scorocode.android.model;

import java.io.InputStream;
import java.util.HashMap;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.response.entity.DataResponseEntity;
import ru.scorocode.android.api.response.entity.UpdateDataResponseEntity;
import ru.scorocode.android.manager.DataManager;
import ru.scorocode.android.manager.FileManager;

public class Object<ValueType> {

    private HashMap<String, ValueType> map;

    private String name;
    private String _id;
    private String createdAt;
    private String updatedAt;
    private String[] readACL;
    private String[] removeACL;
    private String[] updateACL;
    private Update update;

    public Object(String name) {
        this.name = name;
        this.map = new HashMap<>();
        this.update = new Update();
    }

    public void getById(SCCallback<String> callback, String sess, String coll, Query query) {
        DataManager dataManager = new DataManager();
        dataManager.find(callback, sess, coll, query);
    }

    public void save(SCCallback callback, String sess, String acc, String coll, Query query, int limit) {
        if (!exists()) {
            insert(callback, sess, coll, this);
        } else {
            updateById(callback, sess, acc, coll, query, this, limit);
        }
    }

    private boolean exists() {
        return this._id != null; // TODO change
    }

    protected void insert(SCCallback<DataResponseEntity> callback, String sess, String coll, Object doc) {
        DataManager dataManager = new DataManager();
        dataManager.insert(callback, sess, coll, doc);
    }

    protected void updateById(SCCallback<UpdateDataResponseEntity> callback, String sess, String acc, String coll, Query query, Object doc, int limit) {
        DataManager dataManager = new DataManager();
        dataManager.updateById(callback, sess, acc, coll, query, doc, limit);
    }

    public void remove(SCCallback<UpdateDataResponseEntity> callback, String sess, String coll, Query query) {
        DataManager dataManager = new DataManager();
        dataManager.remove(callback, sess, coll, query);
    }

    public ValueType get(String name) {
        return map.get(name);
    }

    public void getFile(SCCallback<InputStream> callback, String app, String coll, String field, String file) {
        FileManager fileManager = new FileManager();
        fileManager.getFile(callback, app, coll, field, file);
    }

    public void getFileLink(SCCallback<String> callback, String coll, String doc, String field, String file) {
        FileManager fileManager = new FileManager();
        fileManager.getFileLink(callback, coll, field, file);
    }

    public void deleteFile(SCCallback<String> callback, String coll, String doc, String field, String file) {
        FileManager fileManager = new FileManager();
        fileManager.deleteFile(callback, coll, field, file);
    }

    public void set(String name, ValueType value) {
        map.put(name, value);
    }

    public void update(SCCallback<UpdateDataResponseEntity> callback, String sess, String acc, String coll, Query query, Object doc, int limit) {
        DataManager dataManager = new DataManager();
        dataManager.update(callback, sess, acc, coll, query, doc, limit);
    }

    public void count(SCCallback<Integer> callback, String sess, String coll, Query query) {
        DataManager dataManager = new DataManager();
        dataManager.count(callback, sess, coll, query);
    }

    public void upload(SCCallback<String> callback, String acc, String sess, String coll, String doc, String field, String content) {
        FileManager fileManager = new FileManager();
        fileManager.upload(callback, acc, sess, coll, doc, field, content);
    }

    /**
     * Getters and setters
     **/

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

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
}
