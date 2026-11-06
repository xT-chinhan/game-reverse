package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2542ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("changePlaySpeedRatio", (com.bytedance.sdk.component.ms.ka<?, ?>) new ka(pcVar));
    }

    public ka(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2542ms = new WeakReference<>(pcVar);
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2542ms;
        if (weakReference == null || weakReference.get() == null) {
            return new JSONObject();
        }
        float fOptDouble = (float) jSONObject.optDouble("ratio");
        if (fOptDouble > 0.0f && fOptDouble <= 3.0f) {
            this.f2542ms.get().ms(fOptDouble);
        }
        return new JSONObject();
    }
}
