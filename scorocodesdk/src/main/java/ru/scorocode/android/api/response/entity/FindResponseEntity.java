package ru.scorocode.android.api.response.entity;

import java.util.List;

import ru.scorocode.android.model.Object;

public class FindResponseEntity {

    private List<Object> list; // TODO check parameter name

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
