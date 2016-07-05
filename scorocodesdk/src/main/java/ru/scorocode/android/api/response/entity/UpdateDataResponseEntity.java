package ru.scorocode.android.api.response.entity;

public class UpdateDataResponseEntity {

    private int count;
    private String[] docs;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getDocs() {
        return docs;
    }

    public void setDocs(String[] docs) {
        this.docs = docs;
    }

}
