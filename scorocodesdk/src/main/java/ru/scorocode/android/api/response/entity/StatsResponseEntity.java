package ru.scorocode.android.api.response.entity;

public class StatsResponseEntity {

    private int dataSize;
    private int indexSize;
    private int filesSize;

    public int getFilesSize() {
        return filesSize;
    }

    public void setFilesSize(int filesSize) {
        this.filesSize = filesSize;
    }

    public int getIndexSize() {
        return indexSize;
    }

    public void setIndexSize(int indexSize) {
        this.indexSize = indexSize;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }
}
