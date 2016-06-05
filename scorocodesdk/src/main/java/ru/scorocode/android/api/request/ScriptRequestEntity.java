package ru.scorocode.android.api.request;

public class ScriptRequestEntity extends BaseRequestEntity {

    private String sess;
    private String acc;
    private String script;
    private String[] pool;

    public ScriptRequestEntity(String sess, String acc, String script, String[] pool) {
        this.sess = sess;
        this.script = script;
        this.acc = acc;
        this.pool = pool;
    }

    public String getSess() {
        return sess;
    }

    public void setSess(String sess) {
        this.sess = sess;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getAccessKey() {
        return acc;
    }

    public void setAccessKey(String acc) {
        this.acc = acc;
    }

    public String[] getPool() {
        return pool;
    }

    public void setPool(String[] pool) {
        this.pool = pool;
    }
}
