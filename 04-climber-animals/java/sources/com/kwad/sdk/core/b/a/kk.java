package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class kk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.u.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.b.u.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.b.u.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.b.u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
        bVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(bVar.errorMsg)) {
            bVar.errorMsg = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.b.u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, bVar.errorCode);
        }
        if (bVar.errorMsg != null && !bVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, bVar.errorMsg);
        }
        return jSONObject;
    }
}
