package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1853ms;
    private long xr;

    public sl(String str, long j) {
        this.f1853ms = str;
        this.xr = j;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ah.d
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f1853ms);
            jSONObject.put("preload_size", this.xr);
            com.bykv.vk.openvk.component.video.api.ah.d dVarMs = ms();
            if (dVarMs != null) {
                jSONObject.put("run_task_mills", dVarMs.ms().optLong("run_task_mills"));
            }
            ms(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }
}
