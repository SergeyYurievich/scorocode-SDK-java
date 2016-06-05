package ru.scorocode.android.model;

import java.lang.*;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.manager.ScriptManager;

public class Script {

    public void run(SCCallback<Boolean> callback, String sessionId, String accessKey, String scriptId, String[] pool) {
        ScriptManager scriptManager = new ScriptManager();
        scriptManager.scripts(callback, sessionId, accessKey, scriptId, pool);
    }

    public void stat(SCCallback<Boolean> callback, String accessKey) {
        ScriptManager scriptManager = new ScriptManager();
        scriptManager.stats(callback, accessKey);
    }
}
