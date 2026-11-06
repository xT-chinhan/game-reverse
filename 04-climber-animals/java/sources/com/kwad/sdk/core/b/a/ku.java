package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ku implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.u.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.u.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.u.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString(com.anythink.core.common.e.f.a.b);
        if (JSONObject.NULL.toString().equals(aVar.key)) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optString(com.anythink.core.common.e.f.a.d);
        if (JSONObject.NULL.toString().equals(aVar.value)) {
            aVar.value = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.key != null && !aVar.key.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.anythink.core.common.e.f.a.b, aVar.key);
        }
        if (aVar.value != null && !aVar.value.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.anythink.core.common.e.f.a.d, aVar.value);
        }
        return jSONObject;
    }
}
