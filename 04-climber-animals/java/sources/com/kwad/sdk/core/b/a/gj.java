package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ap.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ap.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ap.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ap.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adM = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.adM)) {
            aVar.adM = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ap.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.adM != null && !aVar.adM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adTemplate", aVar.adM);
        }
        return jSONObject;
    }
}
