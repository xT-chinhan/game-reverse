package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 110})
public class sz extends n {
    public String n;
    public long q;
    public long qg;
    public long s;

    public void n(String str) {
        this.n = str;
    }

    public void n(long j) {
        this.qg = j;
    }

    public void qg(long j) {
        this.s = j;
    }

    public void s(long j) {
        this.q = j;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.n);
            jSONObject.put("preload_size", this.qg);
            jSONObject.put("load_time", this.s);
            jSONObject.put("local_cache", this.q);
        } catch (Throwable unused) {
        }
    }
}
