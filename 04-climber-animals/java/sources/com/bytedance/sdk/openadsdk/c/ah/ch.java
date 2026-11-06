package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1846ms;
    private long xr;

    public ch(String str, long j) {
        this.f1846ms = str;
        this.xr = j;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f1846ms);
            jSONObject.put("preload_size", this.xr);
            ms(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
