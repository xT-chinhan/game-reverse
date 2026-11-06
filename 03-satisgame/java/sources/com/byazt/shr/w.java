package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 13})
public class w implements q {
    public long n;
    public long qg;

    public void n(long j) {
        this.n = j;
    }

    public void qg(long j) {
        this.qg = j;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.n);
            jSONObject.put("total_duration", this.qg);
        } catch (Throwable unused) {
        }
    }
}
