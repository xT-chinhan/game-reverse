package com.bytedance.sdk.openadsdk.core.h.ms;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.pc f2533ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("businessStatusNotify", (com.bytedance.sdk.component.ms.ka<?, ?>) new d(pcVar));
    }

    public d(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2533ms = pcVar;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.pc pcVar;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && (pcVar = this.f2533ms) != null) {
            pcVar.pc();
        }
        return jSONObject2;
    }
}
