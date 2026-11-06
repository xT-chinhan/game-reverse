package com.bytedance.sdk.openadsdk.c.ah;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.ah.d f1851ms;

    public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        this.f1851ms = dVar;
    }

    public com.bykv.vk.openvk.component.video.api.ah.d ms() {
        return this.f1851ms;
    }

    protected void ms(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.ah.d dVar = this.f1851ms;
            if (dVar == null || jSONObject == null) {
                return;
            }
            JSONObject jSONObjectMs = dVar.ms();
            jSONObject.put("pitaya_cache_size", this.f1851ms.xr());
            jSONObject.put("pitaya_code", this.f1851ms.ah());
            jSONObject.put("pitaya_msg", this.f1851ms.d());
            jSONObject.put("ext_plugin_code", jSONObjectMs.optInt("ext_plugin_code"));
            jSONObject.put("package", jSONObjectMs.optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
