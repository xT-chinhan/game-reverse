package com.byazt.tzz;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 444, 8})
public class s {
    public JSONObject l;
    public String n;
    public int q;
    public String qg;
    public boolean s;
    public int w;

    public s(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.n = str;
        this.qg = str2;
        this.s = z;
        this.q = i;
        this.l = jSONObject;
        this.w = i2;
    }

    public JSONObject n() {
        if (this.l == null) {
            this.l = new JSONObject();
        }
        return this.l;
    }

    public String qg() {
        return this.n;
    }

    public String s() {
        return this.qg;
    }

    public boolean q() {
        return this.s;
    }

    public int l() {
        return this.q;
    }

    public void n(int i) {
        this.q = i;
    }
}
