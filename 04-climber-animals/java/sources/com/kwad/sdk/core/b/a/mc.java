package com.kwad.sdk.core.b.a;

import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class mc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.z> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.qz = jSONObject.optInt("currentTime");
        zVar.aho = jSONObject.optBoolean(IdentityVerifyStateKt.VERIFY_STATE_FAILED);
        zVar.Wy = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (zVar.qz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", zVar.qz);
        }
        if (zVar.aho) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, IdentityVerifyStateKt.VERIFY_STATE_FAILED, zVar.aho);
        }
        if (zVar.Wy) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finished", zVar.Wy);
        }
        return jSONObject;
    }
}
