package com.byazt.shr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 8})
public class s implements q {
    public long l;
    public long n;
    public int q;
    public long qg;
    public int s;
    public long w;
    public int x;

    public void n(long j) {
        this.w = j;
    }

    public void n(int i) {
        this.x = i;
    }

    public void qg(long j) {
        this.l = j;
    }

    public void s(long j) {
        this.n = j;
    }

    public void q(long j) {
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
            jSONObject.put("buffers_time", this.n);
            jSONObject.put("total_duration", this.qg);
            jSONObject.put("vbtt_skip_type", this.s);
            jSONObject.put("skip_reason", this.q);
            jSONObject.put("video_cache_size", this.l);
            jSONObject.put("current", this.w);
            jSONObject.put("percent", this.x);
        } catch (Throwable unused) {
        }
    }
}
