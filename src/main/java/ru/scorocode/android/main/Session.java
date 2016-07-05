package ru.scorocode.android.main;

public class Session {

    private static String sessionKey;

    public static String getSessionKey() {
        return sessionKey;
    }

    public static void setSessionKey(String sk) {
        sessionKey = sk;
    }
}
