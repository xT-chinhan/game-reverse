package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements d {
    public int ah;
    public int d = 0;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public long f1850ms;
    public long xr;

    public void ms(int i) {
        this.ka = i;
    }

    public void ms(long j) {
        this.f1850ms = j;
    }

    public void xr(long j) {
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
            jSONObject.put("total_duration", this.f1850ms);
            jSONObject.put("buffers_time", this.xr);
            jSONObject.put("break_reason", this.ah);
            jSONObject.put("video_backup", this.d);
            jSONObject.put("vbtt_skip_type", this.ka);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
