package com.byazt.yr;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1087, 26})
public final class qg {
    public final long fs;
    public final long l;
    public final long n;
    public final int q;
    public final long qg;
    public final long rv;
    public final long s;
    public final com.byazt.yq.s tj;
    public final long w;
    public final long x;

    public qg(long j, long j2, long j3, int i, long j4, long j5, long j6, long j7, long j8, com.byazt.yq.s sVar) {
        this.n = j;
        this.qg = j2;
        this.s = j3;
        this.q = i;
        this.l = j4;
        this.w = j5;
        this.x = j6;
        this.fs = j7;
        this.rv = j8;
        this.tj = sVar == null ? com.byazt.yq.s.n : sVar;
    }

    public int n() {
        return this.q;
    }

    public boolean qg() {
        return this.s > 0 && this.q >= 0;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("used_kb", this.n);
            jSONObject.put("java_used_kb", this.qg);
            jSONObject.put("limit_kb", this.s);
            jSONObject.put("ratio", this.q);
            jSONObject.put("native_kb", this.l);
            jSONObject.put("delta_used_kb", this.w);
            jSONObject.put("delta_java_kb", this.x);
            jSONObject.put("delta_native_kb", this.fs);
            jSONObject.put("ts", this.rv);
            jSONObject.put("res", this.tj.w());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject n(String str) {
        JSONObject jSONObjectS = s();
        try {
            jSONObjectS.put("stage", str);
        } catch (JSONException unused) {
        }
        return jSONObjectS;
    }

    public JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("used_kb", this.n);
            jSONObject.put("java_used_kb", this.qg);
            jSONObject.put("limit_kb", this.s);
            jSONObject.put("ratio", this.q);
            jSONObject.put("native_kb", this.l);
            jSONObject.put("ts", this.rv);
            jSONObject.put("res", n(this.tj));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject n(com.byazt.yq.s sVar) {
        JSONObject jSONObject = new JSONObject();
        if (sVar == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("webview_count", sVar.n());
            jSONObject.put("player_count", sVar.qg());
            jSONObject.put("native_ad_count", sVar.s());
            jSONObject.put("oom_count", sVar.q());
            jSONObject.put("thread_count", sVar.l());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
