package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.a.C0448a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.a.C0448a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.a.C0448a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.a.C0448a c0448a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0448a.aeH = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0448a.aeH)) {
            c0448a.aeH = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.a.C0448a c0448a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0448a.aeH != null && !c0448a.aeH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "android", c0448a.aeH);
        }
        return jSONObject;
    }
}
