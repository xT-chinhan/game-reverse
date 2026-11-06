package com.byazt.yq;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 776, 8})
public final class s {
    public static final s n = new s(0, 0, 0, 0, 0, 0);
    public final int l;
    public final int q;
    public final int qg;
    public final int s;
    public final long w;
    public final int x;

    public s(int i, int i2, int i3, int i4, long j, int i5) {
        this.qg = i;
        this.s = i2;
        this.q = i3;
        this.l = i4;
        this.w = j;
        this.x = i5;
    }

    public int n() {
        return this.qg;
    }

    public int qg() {
        return this.s;
    }

    public int s() {
        return this.q;
    }

    public int q() {
        return this.l;
    }

    public int l() {
        return this.x;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("webview_count", this.qg);
            jSONObject.put("player_count", this.s);
            jSONObject.put("native_ad_count", this.q);
            jSONObject.put("oom_count", this.l);
            jSONObject.put("cache_kb", this.w);
            jSONObject.put("thread_count", this.x);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
