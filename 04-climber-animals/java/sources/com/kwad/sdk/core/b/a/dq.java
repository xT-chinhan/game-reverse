package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.C0446a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.C0446a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.C0446a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.a.a.C0446a c0446a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0446a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0446a.url)) {
            c0446a.url = "";
        }
        c0446a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0446a.packageName)) {
            c0446a.packageName = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.C0446a c0446a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0446a.url != null && !c0446a.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", c0446a.url);
        }
        if (c0446a.packageName != null && !c0446a.packageName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageName", c0446a.packageName);
        }
        return jSONObject;
    }
}
