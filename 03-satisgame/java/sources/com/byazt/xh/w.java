package com.byazt.xh;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 768, 13})
public class w {
    public final int n;
    public String qg;
    public JSONObject s;

    public w(int i) {
        this.n = i;
    }

    public w(int i, Throwable th) {
        this.n = i;
        if (th != null) {
            this.qg = th.getMessage();
        }
    }

    public w(int i, String str) {
        this.n = i;
        this.qg = str;
    }

    public w(int i, JSONObject jSONObject) {
        this.n = i;
        this.s = jSONObject;
    }

    public boolean n() {
        return this.n == 0;
    }
}
