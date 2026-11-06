package com.byazt.mu;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1123, 8})
public class s {
    public JSONObject n;
    public int qg;
    public String s;

    public s() {
    }

    public s(JSONObject jSONObject, int i) {
        this.n = jSONObject;
        this.qg = i;
    }

    public s(JSONObject jSONObject, String str) {
        this.n = jSONObject;
        this.s = str;
    }

    public JSONObject n() {
        return this.n;
    }

    public void n(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public int qg() {
        return this.qg;
    }

    public void n(int i) {
        this.qg = i;
    }

    public String s() {
        return this.s;
    }
}
