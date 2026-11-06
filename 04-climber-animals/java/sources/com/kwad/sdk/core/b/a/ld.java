package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ld implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.bf.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.bf.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.bf.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.bf.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aet = jSONObject.optInt("taskStatus");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.bf.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aet != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "taskStatus", aVar.aet);
        }
        return jSONObject;
    }
}
