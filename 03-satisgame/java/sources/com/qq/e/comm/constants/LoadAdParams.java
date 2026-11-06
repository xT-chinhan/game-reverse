package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LoadAdParams {
    private Map<String, String> a;
    private final JSONObject b = new JSONObject();

    public Map getDevExtra() {
        return this.a;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.a;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.a).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getParams() {
        return this.b;
    }

    public void setDevExtra(Map<String, String> map) {
        this.a = map;
    }

    public String toString() {
        return String.format("LoadAdParams{devExtra=%s}", getDevExtraJsonString());
    }
}
