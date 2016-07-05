package ru.scorocode.android.model;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.scorocode.android.api.response.entity.DataResponseEntity;
import ru.scorocode.android.api.response.entity.UpdateDataResponseEntity;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.main.SCException;
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

    public Object(String collection) {
        this.name = collection;
        this.map = new HashMap<>();
        this.update = new Update();
    }

    public void getById(SCCallback<List<Object>> callback, String id) {
        DataManager dataManager = new DataManager();
        dataManager.find(callback, this.name, id);
    }

    public void save(SCCallback callback) {
        if (!exists()) {
            insert(callback, this);
        } else {
            updateById(callback, _id);
        }
    }

    private boolean exists() {
        return this._id != null; // TODO change
    }

    protected void insert(SCCallback<DataResponseEntity> callback, Object doc) {
        DataManager dataManager = new DataManager();
        dataManager.insert(callback, this.name, doc);
    }

    protected void updateById(SCCallback<UpdateDataResponseEntity> callback, String id) {
        DataManager dataManager = new DataManager();
        dataManager.updateById(callback, this.name, this, id);
    }

    public void remove(SCCallback<UpdateDataResponseEntity> callback, String id) {
        DataManager dataManager = new DataManager();
        dataManager.remove(callback, this.name, id);
    }

    public void getFile(SCCallback<InputStream> callback, String field, String file) {
        FileManager fileManager = new FileManager();
        fileManager.getFile(callback, this.name, field, file);
    }

    public void getFileLink(SCCallback<String> callback, String doc, String field, String file) {
        FileManager fileManager = new FileManager();
        fileManager.getFileLink(callback, this.name, field, file);
    }

    public void deleteFile(SCCallback<String> callback, String doc, String field, String file) {
        FileManager fileManager = new FileManager();
        fileManager.deleteFile(callback, this.name, field, file);
    }

    public void upload(SCCallback<String> callback, String fileName, String doc, String field, String content) {
        FileManager fileManager = new FileManager();
        fileManager.upload(callback, fileName, this.name, doc, field, content);
    }

    public ValueType get(String name) {
        return map.get(name);
    }

    public void set(String name, ValueType value) {
        if (value instanceof Number || value instanceof Boolean || value instanceof String || value instanceof Date || value instanceof File || value instanceof Object || value instanceof List) {
            map.put(name, value);
        } else throw new SCException("Incompatible value type.");
    }

    public void push(String name, ValueType value) {
        set(name, value);
    }

    public void pull(String name, ValueType value) {
        map.remove(value);
    }

    public void pullAll(String name, ValueType[] values) {
        Set<ValueType> set = new HashSet<>(Arrays.asList(values));
        map.keySet().removeAll(set);
    }

    public void addToSet(String name, ValueType value) {
        if (!map.containsValue(value))
            map.put(name, value);
    }

    public void pop(String name, int position) {
        if (get(name) instanceof List) {
            List<ValueType> list = (List<ValueType>) get(name);
            switch (position) {
                case 1:
                    list.remove(list.size() - 1);
                    push(name, (ValueType) list);
                    break;
                case -1:
                    list.remove(0);
                    push(name, (ValueType) list);
                    break;
            }
        }
    }

    public void inc(String name, Integer amount) {
        if (get(name) instanceof Integer) {
            Integer object = (Integer) get(name);
            object += amount;
            push(name, (ValueType) object);
        }
    }

    public void inc(String name, Double amount) {
        if (get(name) instanceof Double) {
            Double object = (Double) get(name);
            object += amount;
            push(name, (ValueType) object);
        }
    }

    public void mul(String name, Integer number) {
        if (get(name) instanceof Integer) {
            Integer object = (Integer) get(name);
            object *= number;
            push(name, (ValueType) object);
        }
    }

    public void mul(String name, Double number) {
        if (get(name) instanceof Double) {
            Double object = (Double) get(name);
            object *= number;
            push(name, (ValueType) object);
        }
    }

    public void min(String name, Integer number) {
        if (get(name) instanceof Integer) {
            Integer object = (Integer) get(name);
            if (number < object) {
                object *= number;
                push(name, (ValueType) object);
            }
        }
    }

    public void min(String name, Double number) {
        if (get(name) instanceof Double) {
            Double object = (Double) get(name);
            if (Double.compare(number, object) < 0) {
                object *= number;
                push(name, (ValueType) object);
            }
        }
    }

    public void max(String name, Integer number) {
        if (get(name) instanceof Integer) {
            Integer object = (Integer) get(name);
            if (number > object) {
                object *= number;
                push(name, (ValueType) object);
            }
        }
    }

    public void max(String name, Double number) {
        if (get(name) instanceof Double) {
            Double object = (Double) get(name);
            if (Double.compare(number, object) > 0) {
                object *= number;
                push(name, (ValueType) object);
            }
        }
    }

    public void currentDate(String name, boolean type) {
        if (type) {
            Long mills = System.currentTimeMillis();
            push(name, (ValueType) mills);
        }
    }

    public void currentDate(String name, String type) {
        if (get(name) instanceof String) {
            push(name, (ValueType) type);
        }
    }

    public void currentDate(String name, Long type) {
        if (get(name) instanceof Long) {
            push(name, (ValueType) type);
        }
    }

}
