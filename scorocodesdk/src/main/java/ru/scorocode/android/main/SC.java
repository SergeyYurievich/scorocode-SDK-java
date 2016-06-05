package ru.scorocode.android.main;

import ru.scorocode.android.api.request.BaseRequestEntity;

public class SC {

    private static String sAppId;
    private static String sClientKey;
    private static String sMasterKey;
    private static String sFileKey;
    private static String sMessageKey;

    private SC() {
    }

    public static void init(String appId, String clientKey, String masterKey, String fileKey, String messageKey) {
        sAppId = appId;
        sClientKey = clientKey;
        sMasterKey = masterKey;
        sFileKey = fileKey;
        sMessageKey = messageKey;
    }

    public static <T extends BaseRequestEntity> void initRequest(T requestEntity) {
        if (!isInitialized()) {
            throw new SCException("SC is not initialized.");
        }
        requestEntity.setApp(sAppId);
        requestEntity.setCli(sClientKey);
    }

    public static boolean isInitialized() {
        return sAppId != null && sClientKey != null;
    }

    public static String getAppId() {
        return sAppId;
    }

    public static String getClientKey() {
        return sClientKey;
    }

    public static String getMasterKey() {
        return sMasterKey;
    }

    public static String getFileKey() {
        return sFileKey;
    }

    public static String getMessageKey() {
        return sMessageKey;
    }
}
