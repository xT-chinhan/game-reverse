package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2538ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("getSendRewardStatus", (com.bytedance.sdk.component.ms.ka<?, ?>) new h(pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.pc pcVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2538ms;
        if (weakReference != null && weakReference.get() != null && (pcVar = this.f2538ms.get()) != null) {
            jSONObject2.put("isReward", pcVar.ab());
        }
        return jSONObject2;
    }

    public h(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2538ms = new WeakReference<>(pcVar);
    }
}
