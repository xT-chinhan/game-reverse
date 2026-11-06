package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class le extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.pc f2543ms;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ab.xr> xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ab.xr> weakReference) {
        hVar.ms("resumeRewardCountDown", (com.bytedance.sdk.component.ms.ka<?, ?>) new le(pcVar, weakReference));
    }

    public le(com.bytedance.sdk.openadsdk.core.pc pcVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ab.xr> weakReference) {
        this.f2543ms = pcVar;
        this.xr = weakReference;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ab.xr> weakReference = this.xr;
        if (weakReference != null && weakReference.get() != null) {
            this.xr.get().xr();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
