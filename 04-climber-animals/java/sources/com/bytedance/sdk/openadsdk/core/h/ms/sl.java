package com.bytedance.sdk.openadsdk.core.h.ms;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f2557ms;

    public sl(JSONObject jSONObject) {
        this.f2557ms = jSONObject;
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, JSONObject jSONObject) {
        hVar.ms("getData", (com.bytedance.sdk.component.ms.ka<?, ?>) new sl(jSONObject));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.f2557ms, jSONObject);
    }
}
