package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class mg implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ay.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ay.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ay.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ay.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aeg = jSONObject.optString("windowFocusEvent");
        if (JSONObject.NULL.toString().equals(aVar.aeg)) {
            aVar.aeg = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ay.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aeg != null && !aVar.aeg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "windowFocusEvent", aVar.aeg);
        }
        return jSONObject;
    }
}
