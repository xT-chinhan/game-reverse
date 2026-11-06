package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u implements d {
    public long ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public long f1854ms;
    public int xr;

    public void ms(long j) {
        this.f1854ms = j;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public void xr(long j) {
        this.ah = j;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f1854ms);
            jSONObject.put("buffers_count", this.xr);
            jSONObject.put("total_duration", this.ah);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
