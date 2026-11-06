package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 29})
public class cp extends n {
    public String n;
    public long qg;

    public cp(String str, long j) {
        this.n = str;
        this.qg = j;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.n);
            jSONObject.put("preload_size", this.qg);
        } catch (Throwable unused) {
        }
    }
}
