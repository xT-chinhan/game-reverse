package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 210})
public class k implements q {
    public long n;
    public int qg;
    public long s;

    public void n(long j) {
        this.n = j;
    }

    public void n(int i) {
        this.qg = i;
    }

    public void qg(long j) {
        this.s = j;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.n);
            jSONObject.put("buffers_count", this.qg);
            jSONObject.put("total_duration", this.s);
        } catch (Throwable unused) {
        }
    }
}
