package ru.scorocode.android.main;

public interface SCCallback<ReturnType> {

    void onSuccess(ReturnType result);

    void onError(String message);
}
