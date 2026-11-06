package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ao extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2525ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("getPlayTimeCurrent", (com.bytedance.sdk.component.ms.ka<?, ?>) new ao(pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2525ms;
        if (weakReference != null && weakReference.get() != null) {
            com.bytedance.sdk.openadsdk.core.pc pcVar = this.f2525ms.get();
            jSONObject2.put("currentTime", pcVar != null ? pcVar.g() : 0);
        }
        return jSONObject2;
    }

    public ao(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2525ms = new WeakReference<>(pcVar);
    }
}
