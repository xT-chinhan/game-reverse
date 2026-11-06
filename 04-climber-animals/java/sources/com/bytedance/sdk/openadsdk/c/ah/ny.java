package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements d {
    private int ah;
    private int d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1852ms;
    private long xr;

    public void ms(long j) {
        this.f1852ms = j;
    }

    public void ms(int i) {
        this.d = i;
    }

    public void xr(long j) {
        this.xr = j;
    }

    public void xr(int i) {
        this.ah = i;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.f1852ms);
            jSONObject.put("video_cache_size", this.xr);
            jSONObject.put("is_auto_play", this.ah);
            jSONObject.put("is_supplement_replay", this.d);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
