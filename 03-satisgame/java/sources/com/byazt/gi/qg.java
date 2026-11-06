package com.byazt.gi;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1745, 26})
public class qg {
    public static volatile qg n;

    private qg() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    public void n(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.byazt.qyu.qg.qg(com.byazt.qt.qg.getContext(), "tt_sdk_test_tool_data_" + com.byazt.qt.n.d().oa(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.qyu.qg.qg(com.byazt.qt.qg.getContext(), "tt_sdk_test_tool_data_" + com.byazt.qt.n.d().oa(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
