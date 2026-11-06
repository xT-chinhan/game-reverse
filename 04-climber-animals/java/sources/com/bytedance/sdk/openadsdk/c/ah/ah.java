package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements d {
    private int ab;
    private int ah;
    private long c;
    private int d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1843ms;
    private long xr;

    public void ms(long j) {
        this.c = j;
    }

    public void ms(int i) {
        this.ab = i;
    }

    public void xr(long j) {
        this.ka = j;
    }

    public void ah(long j) {
        this.f1843ms = j;
    }

    public void d(long j) {
        this.xr = j;
    }

    public void xr(int i) {
        this.ah = i;
    }

    public void ah(int i) {
        this.d = i;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f1843ms);
            jSONObject.put("total_duration", this.xr);
            jSONObject.put("vbtt_skip_type", this.ah);
            jSONObject.put("skip_reason", this.d);
            jSONObject.put("video_cache_size", this.ka);
            jSONObject.put("current", this.c);
            jSONObject.put("percent", this.ab);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
