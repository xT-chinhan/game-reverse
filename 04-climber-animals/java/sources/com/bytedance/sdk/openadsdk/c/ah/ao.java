package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ao implements d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1844ms;
    private boolean xr;

    public void ms(long j) {
        this.f1844ms = j;
    }

    public void ms(boolean z) {
        this.xr = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.f1844ms);
            jSONObject.put("is_auto_play", this.xr);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
