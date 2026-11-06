package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class yu extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.xr f2566ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.ugeno.xr xrVar) {
        hVar.ms("RendUgenDownloadDialogState", (com.bytedance.sdk.component.ms.ka<?, ?>) new yu(xrVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        ms(jSONObject);
        return ah();
    }

    private void ms(JSONObject jSONObject) {
        if (jSONObject == null || this.f2566ms == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("code");
        if (iOptInt == 200) {
            this.f2566ms.ms();
        } else {
            this.f2566ms.ms(iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }

    public yu(com.bytedance.sdk.openadsdk.core.ugeno.xr xrVar) {
        this.f2566ms = xrVar;
    }

    public JSONObject ah() {
        return new JSONObject();
    }
}
