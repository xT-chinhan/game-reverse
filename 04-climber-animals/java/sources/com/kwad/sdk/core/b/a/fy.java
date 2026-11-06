package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fy implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.m.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.m.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.m.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt("progress");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.acv = jSONObject.optInt("realProgress");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.progress != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", bVar.progress);
        }
        if (bVar.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", bVar.soFarBytes);
        }
        if (bVar.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", bVar.totalBytes);
        }
        if (bVar.acv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", bVar.acv);
        }
        return jSONObject;
    }
}
