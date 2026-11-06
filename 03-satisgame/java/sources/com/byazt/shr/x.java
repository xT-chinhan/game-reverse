package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 21})
public class x implements q {
    public long n;
    public long qg;
    public int s = 0;

    public void n(long j) {
        this.n = j;
    }

    public void qg(long j) {
        this.qg = j;
    }

    public void n(int i) {
        this.s = i;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.n);
            jSONObject.put("buffers_time", this.qg);
            jSONObject.put("video_backup", this.s);
        } catch (Throwable unused) {
        }
    }
}
