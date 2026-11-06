package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 18})
public class l implements q {
    public int l;
    public long n;
    public int q = 0;
    public long qg;
    public int s;

    public void n(int i) {
        this.l = i;
    }

    public void n(long j) {
        this.n = j;
    }

    public void qg(long j) {
        this.qg = j;
    }

    public void qg(int i) {
        this.s = i;
    }

    public void s(int i) {
        this.q = i;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.n);
            jSONObject.put("buffers_time", this.qg);
            jSONObject.put("break_reason", this.s);
            jSONObject.put("video_backup", this.q);
            jSONObject.put("vbtt_skip_type", this.l);
        } catch (Throwable unused) {
        }
    }
}
