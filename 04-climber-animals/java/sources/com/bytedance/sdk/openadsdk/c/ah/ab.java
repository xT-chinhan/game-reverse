package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab implements d {
    private int ah = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1842ms;
    private long xr;

    public void ms(long j) {
        this.f1842ms = j;
    }

    public void xr(long j) {
        this.xr = j;
    }

    public void ms(int i) {
        this.ah = i;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f1842ms);
            jSONObject.put("buffers_time", this.xr);
            jSONObject.put("video_backup", this.ah);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
