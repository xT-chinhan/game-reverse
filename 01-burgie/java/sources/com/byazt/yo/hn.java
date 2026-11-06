package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 20})
public class hn implements x {
    public long c;
    public int fw;
    public int hn;
    public long hw;
    public long pr;
    public long uc;
    public int x;

    public void pr(long j) {
        this.uc = j;
    }

    public void pr(int i) {
        this.fw = i;
    }

    public void hw(long j) {
        this.c = j;
    }

    public void hn(long j) {
        this.pr = j;
    }

    public void x(long j) {
        this.hw = j;
    }

    public void hw(int i) {
        this.hn = i;
    }

    public void hn(int i) {
        this.x = i;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pr);
            jSONObject.put("total_duration", this.hw);
            jSONObject.put("vbtt_skip_type", this.hn);
            jSONObject.put("skip_reason", this.x);
            jSONObject.put("video_cache_size", this.c);
            jSONObject.put("current", this.uc);
            jSONObject.put("percent", this.fw);
        } catch (Throwable th) {
        }
    }
}
