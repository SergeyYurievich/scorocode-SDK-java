package ru.scorocode.android.api.request;

public class ScriptRequestEntity extends BaseRequestEntity {

    private String script;
    private String[] pool;

    public ScriptRequestEntity(String script, String[] pool) {
        this.script = script;
        this.pool = pool;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String[] getPool() {
        return pool;
    }

    public void setPool(String[] pool) {
        this.pool = pool;
    }
}
