package com.bytedance.sdk.openadsdk.core.h.ms;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pc extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.pc f2554ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("ShowUgenDownloadDialog", (com.bytedance.sdk.component.ms.ka<?, ?>) new pc(pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        return ah();
    }

    public pc(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2554ms = pcVar;
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.pc pcVar = this.f2554ms;
        if (pcVar == null) {
            try {
                jSONObject.put("code", -1);
                jSONObject.put("codeMsg", "JsObject is null");
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return pcVar.hi();
    }
}
