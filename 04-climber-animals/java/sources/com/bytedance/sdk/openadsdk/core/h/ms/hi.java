package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2539ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("getAppManage", (com.bytedance.sdk.component.ms.ka<?, ?>) new hi(pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        return ah();
    }

    public hi(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2539ms = new WeakReference<>(pcVar);
    }

    public JSONObject ah() {
        com.bytedance.sdk.openadsdk.core.pc pcVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2539ms;
            return (weakReference == null || (pcVar = weakReference.get()) == null) ? jSONObject : pcVar.i();
        } catch (Throwable unused) {
            return jSONObject;
        }
    }
}
