package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends ms {
    private long ah;
    private long d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1858ms;
    private long xr;

    public void ms(String str) {
        this.f1858ms = str;
    }

    public void ms(long j) {
        this.xr = j;
    }

    public void xr(long j) {
        this.ah = j;
    }

    public void ah(long j) {
        this.d = j;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f1858ms);
            jSONObject.put("preload_size", this.xr);
            jSONObject.put(com.baidu.mobads.sdk.internal.d.b, this.ah);
            jSONObject.put("local_cache", this.d);
            ms(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
