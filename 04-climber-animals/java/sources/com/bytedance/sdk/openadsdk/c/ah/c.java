package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1845ms;
    private long xr;

    public void ms(long j) {
        this.f1845ms = j;
    }

    public void xr(long j) {
        this.xr = j;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f1845ms);
            jSONObject.put("total_duration", this.xr);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
