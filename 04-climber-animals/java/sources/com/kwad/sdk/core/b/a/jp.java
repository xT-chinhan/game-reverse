package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class jp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.e.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.e.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.e.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aeM = jSONObject.optString("base64String");
        if (JSONObject.NULL.toString().equals(aVar.aeM)) {
            aVar.aeM = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aeM != null && !aVar.aeM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "base64String", aVar.aeM);
        }
        return jSONObject;
    }
}
