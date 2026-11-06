package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2546ms;
    private com.bytedance.sdk.openadsdk.core.pc xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, lm lmVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("adViewInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new ny(lmVar, pcVar));
    }

    public ny(lm lmVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2546ms = lmVar;
        this.xr = pcVar;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.xr.ms());
        jSONObject2.put("creative", this.xr.xr());
        return jSONObject2;
    }
}
